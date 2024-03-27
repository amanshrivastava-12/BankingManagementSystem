package bank.management.system;

  import java.sql.*;
public class Conn {

      Connection c;
        Statement s;
       Conn(){
             try{
                 
                   c=DriverManager.getConnection("jdbc:mysql:///BANKMANAGEMENTSYSTEM","root","microsoft@123");
                   s=c.createStatement();
             }
               catch(Exception e){
                   System.out.println(e);
               }
       }
}
