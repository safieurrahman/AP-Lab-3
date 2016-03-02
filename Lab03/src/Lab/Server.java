package Lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) {
		
		try{
			
            ArrayList<Record> list = new ArrayList<Record>();
            ServerSocket listener = new ServerSocket(9017);
            
            while(true)
            {
            	Socket socket = listener.accept();
				System.out.println("Welcome to the Server!");
				
				ObjectOutputStream  OuttoClient = new ObjectOutputStream (socket.getOutputStream());
                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                Record rec ;
                
                rec = (Record)inFromClient.readObject();
                
                if(rec.operation == 1)
                {
                    list.add(rec);
                    System.out.println("Record Inserted!");
                }
                
                else
                {
                	//System.out.println("Inside Function");
                    for(int i = 0; i < list.size(); i++)
                    {
                        if(list.get(i).username.equals(rec.username))
                        {
                            OuttoClient.writeObject(list.get(i));
                        }
                    }
                }
				System.out.println("GoodBye "+rec.username);
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
		
	}
}