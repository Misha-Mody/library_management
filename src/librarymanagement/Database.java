package librarymanagement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
   public  String NAME="NULL",USERNAME="NULL",PASSWORD="NULL",SECURITY_QUESTION="NULL",ANSWER="NULL";
    public void setdb(String NAME,String USERNAME,String PASSWORD,String SECURITY_QUESTION,String ANSWER)
    {
        this.NAME=NAME;
        this.USERNAME=USERNAME;
        this.PASSWORD=PASSWORD;
        this.SECURITY_QUESTION=SECURITY_QUESTION;
        this.ANSWER=ANSWER;   
    
       
   try{
                Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
                String sql="insert into account(NAME,USERNAME,PASSWORD,SECURITY_QUESTION,ANSWER) values(?,?,?,?,?);";
                    PreparedStatement stat = conn.prepareStatement(sql);
                    stat.setString(1, NAME);
                    stat.setString(1, USERNAME);
                    stat.setString(1, PASSWORD);
                    stat.setString(1, SECURITY_QUESTION);
                    stat.setString(1, ANSWER);
                   conn.close();
                System.out.println("Record Saved");
             }      
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
       
    }
    
   public int getID()
    {
        int ID=0;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement stmt = (Statement) conn.createStatement();
            String querry = "select * from account ORDER BY ID DESC LIMIT 1";
            ResultSet rs= stmt.executeQuery(querry);
            if(rs.next())
            {
                ID = rs.getInt("ID");
            }
            else
            {
                System.out.println("Cannot Get ID");
            }
            System.out.println("Returning ID: "+ID);
        }
        catch(Exception ex)
        {
            //Logger.getLogger(jFrame1.class.getName()).log(level.SEVERE,null,ex);
            System.out.println("BAD REQUEST");
        }
        System.out.println("Returning ID: "+ID);
        return ID;
    }
}
    
    
    
    

