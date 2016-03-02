package Lab;


public class Record implements java.io.Serializable
{
    public String username;
    public String notes;
    public int operation;
    
    public Record(String A,String B, int Operation)
    {
        username = A ;
        notes = B;
        operation = Operation;
    }
    
    
    public String getName()
    {
        return username;
    }
    
    public String getNotes()
    {
        return notes;
    }
    
}
