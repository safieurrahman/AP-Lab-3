package Lab;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static Record Data_Input() {
		
		Record rec = null;
		Scanner input = new Scanner(System.in);
        
        System.out.println("Please select the operation to concieve");
        System.out.println("1. New Record Insertion!");
        System.out.println("2. Data Retrieval");
        
        int operation = Integer.parseInt(input.nextLine());
        
        if(operation == 1)
        {
		System.out.println("Please enter your Name: ");
		String username = input.nextLine();
		
		System.out.println("Please enter your note: ");
		String notes = input.nextLine();		
		
		rec = new Record (username, notes, 1);		
        }
        
        if(operation == 2)
        {
		System.out.println("Please enter the Search Name: ");
		String username = input.nextLine();
		
		rec = new Record (username,"", 2);		
        }
			return rec;
	};

	
    public static void main(String[] args) 
    {
    	boolean x = true;
    	while(x)
    	{
    	try
        {
            Socket sender = new Socket("localhost",9017);
        
            
            Record rec = Data_Input();
            ObjectOutputStream outToServer = new ObjectOutputStream(sender.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(sender.getInputStream());
            outToServer.writeObject(rec);
           
            if(rec.operation == 2)
            {
                while(true)
                {
                    Record newRec = (Record)inFromServer.readObject();
                    if(newRec.username.equals(""))
                        break;
                    System.out.println("User Name: "+newRec.username);
                    System.out.println("Notes : "+newRec.notes);
                    //break;
                }
            }
            
            sender.close();   
        }
        catch(Exception t)
        {
            System.out.println("Exception");
            System.out.println(t.getMessage());
            return;
        }
    }
   }
}
