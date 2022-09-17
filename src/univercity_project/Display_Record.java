package univercity_project;
import java.sql.*;
import java.util.Scanner;

public class Display_Record{
    PreparedStatement p;
    Connection con;
    Scanner s1;
    ResultSet rs;
    String name,fatherName,address,email;
    int id,phone;
    String ch;
    
    public Display_Record(Scanner s,Connection con){
        s1=s;
        this.con =con;
        this.display_rec();
    }
    public void display_rec(){
        do{
            try{
                System.out.println("Please enter your id");
                id = s1.nextInt();
                Class.forName("com.mysql.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost:3306/univercity","root","");
                try{
                    p =con.prepareStatement("select * from student where id=?");
                    p.setInt(1, id);
                    rs = p.executeQuery();
                    
                    if(!rs.next()){
                        System.out.println("Display unsuccessfull");
                    }else{
                        id =rs.getInt(1);
                        name =rs.getString(2);
                        fatherName = rs.getString(3);
                        phone = rs.getInt(4);
                        email=rs.getString(5);
                        address =rs.getString(6);
                        
                        System.out.println("Id:"+id);
                        System.out.println("Name:"+name);
                        System.out.println("FatherName:"+fatherName);
                        System.out.println("phone:"+phone);
                        System.out.println("Email:"+email);
                        System.out.println("Address:"+address);
                    }
                    rs.close();
                    con.close();

                }catch(Exception e){
                    System.out.println(e);
                }
                System.out.println("\n____________ Do you want to Display more record _____________");
                ch = s1.next();
            }catch(Exception e){
                e.printStackTrace();
            }
        }while(ch.equals("y"));
        Menu m = new Menu(s1,con);
    }
}
