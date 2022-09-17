package univercity_project;
import java.sql.*;
import java.util.Scanner;
public class Course_Details {
    
        PreparedStatement p;  
        Connection  con;         
        Scanner s1;
        int ch;
        String ch1;
        public Course_Details(Scanner s,Connection con){
        s1=s;
        this.con=con;
        this.course_det();
//        this.display();
        
}
        //******************************* java information **********************************
         public void javaDetails(){
        System.out.println("Java Information\nDuration : 3 months\nCourse-fees : 25,000/-");
    }
          //***************************** PHP Information ***********************************
    
        public void phpDetails(){
        System.out.println("PHP Information\nDuration :2 months\nCource-fees :15,000/-");
    }
        //********************************* Python Information ************************************
        public void PythonDetais(){
        System.out.println("Python Information\nDuration :1 months\nCourse-fees : 30,000/-");
    }
         //******************************* C++ Information ****************************************
    
        public void cDetails(){
        System.out.println("C++ Information\nDuration : 1 months\nCourse-fees : 5,000/-");
        
    }
        //*********************************** Html Information *********************************
    
        public void htmlDetails(){
        System.out.println("Html Information\nDuration : 2 months\nCourse-fees :20,000/-");
    }
         
        public void course_det(){
            System.out.println("\n\t____ Course Details ____\n");
            System.out.println("1.JAVA");
            System.out.println("2.PHP");
            System.out.println("3.PYTHON");
            System.out.println("4.C++");
            System.out.println("5.HTML");
            System.out.println("6.Exit(0)");
            System.out.println("\n_________ Enter your choice ________");
            ch=s1.nextInt();
            
            switch(ch){
                case 1:
                    this.javaDetails();
                    break;
                case 2:
                    this.phpDetails();
                    break;
                case 3:
                    this.PythonDetais();
                    break;
                case 4:
                    this.cDetails();
                    break;
                case 5:
                    this.htmlDetails();
                    break;
                case 6:
                    System.exit(0);
                    break;
                    
            }
            System.out.println("Do you want to take admission (Y/N)");          
            ch1 = s1.next();
            if(ch1.equals("y"))
            {
                Insert_rec ic = new Insert_rec(s1,con);
            }else if(ch1.equals("n"))
            {
                this.course_det();
            }
        }
//        public void display(){
//            
//            System.out.println("Do you want to take admission (Y/N)");          
//            ch1 = s1.next();
//            if(ch1.equals("y"))
//            {
//                Insert_rec ic = new Insert_rec(s1,con);
//            }else if(ch1.equals("n"))
//            {
//                this;
//            }
//        }
}
