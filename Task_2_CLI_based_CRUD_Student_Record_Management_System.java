import java.util.*;
class Student
{
    String name;
    String Id;
    double mark;
    public Student(String name, String Id, double mark) 
    {
        this.name = name;
        this.Id = Id;
        this.mark = mark;
    }
    ArrayList<Student> studentList = new ArrayList<>();
    void StudentView()
    {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + Id);
        System.out.println("Student Mark: " + mark);
    }

    void AdminPanel(Scanner sc)
    {
        System.out.println("Welcome to the Admin Panel");
        String DoOperation= "yes";
        while (DoOperation.equalsIgnoreCase("yes")) 
        {
            System.out.println("What would you like to do?");
            System.out.println("(1) Add Student");
            System.out.println("(2) View Student Records");
            System.out.println("(3) Update Student Record");
            System.out.println("(4) Delete Student Record");
            System.out.println("(5) Exit");
            int AdminResponse = sc.nextInt();
            switch (AdminResponse) 
            {
                case 1:
                    System.out.println("Enter Student Name:");
                    String name = sc.next();
                    System.out.println("Enter Student ID:");
                    String Id = sc.next();
                    System.out.println("Enter Student Mark:");
                    double mark = sc.nextDouble();
                    for (Student s : studentList) 
                    {
                        if (s.Id.equals(Id)) 
                        {
                            System.out.println("Student ID already exists. Please enter a unique ID.");
                        }
                    }
                    studentList.add(new Student(name, Id, mark));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    System.out.println("Student Records:");
                    for (Student s : studentList) 
                    {
                        s.StudentView();
                        System.out.println("-------------------");
                    }
                    break;
                case 3:
                    System.out.println("Enter Student ID to update:");
                    String updateId = sc.next();
                    boolean found = false;
                    for (Student s : studentList) 
                    {
                        if (s.Id.equals(updateId)) 
                        {
                            found = true;
                            System.out.println("Enter new Name:");
                            s.name = sc.next();
                            System.out.println("Enter new Mark:");
                            s.mark = sc.nextDouble();
                            System.out.println("Student record updated successfully!");
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Student ID to delete:");
                    String deleteId = sc.next();
                    Iterator<Student> iterator = studentList.iterator();
                    boolean deleted = false;
                    while (iterator.hasNext()) 
                    {
                        Student s = iterator.next();
                        if (s.Id.equals(deleteId)) 
                        {
                            iterator.remove();
                            deleted = true;
                            System.out.println("Student record deleted successfully!");
                            break;
                        }
                    }
                    if (!deleted) 
                    {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Admin Panel.");
                    break;
                default:
                    break;
                
            }
            System.out.println("Do you want to perform again? (yes/no)");
            String response = sc.next();
            if (response.equalsIgnoreCase("yes")) 
            {
                DoOperation = "yes";
            } 
            else 
            {
                DoOperation = "no";
                System.out.println("Exiting the Admin Panel.");
            }
        }
    }
}
public class Task_2_CLI_based_CRUD_Student_Record_Management_System 
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Student Record Management System");
        System.out.println("Please choose an option:");
        System.out.println("(1) Student");
        System.out.println("(2) Admin");
        System.out.println("(3) Exit");
        Scanner sc = new Scanner(System.in);
        int AdminPanelResponse = sc.nextInt();
        Student student = new Student("", "", 0);
        switch (AdminPanelResponse) 
        {
            case 1:
                System.out.println("Welcome to the Student Panel");
                System.out.println("What would you like to do?");
                System.out.println("(1) view record");
                System.out.println("(2) Exit");
                int StudentResponse = sc.nextInt();
                if (StudentResponse == 1) 
                {
                    System.out.println("Enter your Student ID");
                    String studentId = sc.next();
                    boolean found = false;
                    for (Student s : student.studentList) 
                    {
                        if (s.Id.equals(studentId)) 
                        {
                            found = true;
                            s.StudentView();
                            break;
                        }
                    }
                    if (!found) 
                    {
                        System.out.println("Student ID not found.");
                    }
                }
                else 
                {
                    System.out.println("Exiting the Student Panel.");
                }
                break;
        
            case 2:
                student.AdminPanel(sc);
                break;

            case 3:
                System.out.println("Exiting the system. Goodbye!");
                sc.close();

            default:
                break;
        }
    }
}
