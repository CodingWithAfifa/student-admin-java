package univercity_project;
import java.sql.Connection;
import java.util.Scanner;

public class Menu
{
    Scanner s1;
    Connection con;
    int ch;
    public Menu(Scanner ss,Connection con)
    {
        s1=ss;
        this.con=con;         
        this.show_menu();
    }
    
    public void show_menu()
    {
        System.out.println("\n ____________ Select From Menu ___________");
        System.out.println("1. Insert Record");
        System.out.println("2. Delete Record");
        System.out.println("3. Update Record");
        System.out.println("4. Display Record");
        System.out.println("5. Course Details");
        System.out.println("6. Exam Menu");
        System.out.println("7. Exit(0)");
        System.out.println("\n_____________ Enter your choice _____________");
        ch=s1.nextInt();
        
        switch(ch)
        {
            case 1: 
                    Insert_rec  obj =new Insert_rec(s1,con);   
                break;
            case 2:
                Delete_Record obj2 =new Delete_Record(s1,con);
                break;
            case 3:
                UpdateRecord obj3=new UpdateRecord(s1,con);
                break;
            case 4:
                Display_Record dr =new Display_Record(s1,con);
                break;
            case 5:
                Course_Details cd = new Course_Details(s1,con);
                break;
//            case 6:
//               Exam_Menu emi = new Exam_Menu(s1,con);
//                break;
            case 7:
                System.exit(0);
                break;
        } 
    }

}
