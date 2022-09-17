package univercity_project;
import java.sql.*;
import java.util.Scanner;

public class UpdateRecord {
    Connection con;
    PreparedStatement p;
    ResultSet rs;
    Scanner s1;

    String name, email, address, fatherName;
    int id, phone;
    String ch;

    public UpdateRecord(Scanner s1, Connection con) {
        this.s1 = s1;
        this.con = con;
        this.updateRec();
    }
    public void updateRec() {
        do {
            try {
                System.out.println("Enter id whose record you want to update");
                id = s1.nextInt();
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Univercity", "root", "");
                try {
                    p = con.prepareStatement("select * from Student where id=?");
                    p.setInt(1, id);

                    rs = p.executeQuery();

                    if (!rs.next()) {
                        System.out.println("Record not found");
                    } else {
                        String ch;
                        id = rs.getInt(1);
                        name = rs.getString(2);
                        fatherName = rs.getString(3);
                        phone = rs.getInt(4);
                        email = rs.getString(5);
                        address = rs.getString(6);

                        System.out.println("Name:" + name);
                        System.out.println("FatherName:" + fatherName);
                        System.out.println("Phone:" + phone);
                        System.out.println("Email:" + email);
                        System.out.println("Address:" + address);

                        System.out.println("What do you want to update");
                        ch = s1.next();
                        ch.toLowerCase();  

                        if (ch.equals("name")) {
                            System.out.println("Enter new name:");
                            s1.nextLine();
                            name = s1.nextLine();
                        } else if (ch.equals("fathername")) {
                            System.out.println("Enter new father name");
                            fatherName = s1.next();
                        } else if (ch.equals("email")) {
                            System.out.println("Enter new email id:");
                            email = s1.next();
                        } else if (ch.equals("address")) {
                            System.out.println("Enter new address:");
                            s1.nextLine();
                            address = s1.nextLine();
                        } else if (ch.equals("phone")) {
                            System.out.println("Enter new phone number");
                            phone = s1.nextInt();
                        }

                        p = con.prepareStatement("update Student set name=?,fatherName=?,phonenumber=?,email=?,address=?");
//                        p.setInt(1, id);
                        p.setString(1, name);
                        p.setString(2, fatherName);
                        p.setInt(3, phone);
                        p.setString(4, email);
                        p.setString(5, address);

                        int i = p.executeUpdate();

                        if (i > 0) {
                            System.err.println("\n******* Record update successfully *******");
                        }
                    }
                    rs.close();
                    con.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                System.out.println("Do you want to update more record press y");
                ch = s1.next();
                //      ch=toLowerCase();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (ch.equals("y"));
        Menu m = new Menu(s1, con);
    }
}