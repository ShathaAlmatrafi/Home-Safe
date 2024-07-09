package oop.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person {
    // Declaring Employee Class attributes
    private String address;
    private int mobileNum;
    private String Email;
    private double salary;
    private static ArrayList<Employee> employees_list = new ArrayList<>();

    // Creating an empty & a parameterized constructor
    public Employee(){}
    public Employee(String name, int ID, String address, int mopileNum, String Email, double salary) {
        super.setName(name);
        super.setID(ID);
        this.address = address;
        this.mobileNum = mopileNum;
        this.Email = Email;
        this.salary = salary;}

    // Creating 4 setters for Employee Class attributes
    public void setAddress(String address) {this.address = address;}
    public void setMopileNum(int mopileNum) {this.mobileNum = mopileNum;}
    public void setEmail(String Email) {this.Email = Email;}
    public void setSalary(double salary) { this.salary = salary;}
    
    // Creating 4 getters for Employee Class attributes
    public String getAddress() {return address;}
    public int getMopileNum() {return mobileNum;}
    public String getEmail() {return Email;}
    public double getSalary() {return salary;}

    // This method add a Passenger obj to Employee_list ArrayList created in this class
    public void addEmployee(Employee obj) {employees_list.add(obj);}

    // This method implements the one in Company interface, it prints Employee's info based on his ID
    @Override
    public void printInfo( ){ //by Employee ID -> search Employee collection
        boolean flag = false;
        Scanner input = new Scanner (System.in);
        do{
        System.out.print("Please enter Employee's ID : ");
        int ID = input.nextInt();
        for ( Employee p : employees_list)
            if(p.getID()== ID){
                System.out.println( p.toString());
                flag = true;
                break;
            }
        if ( flag == false )
        System.out.println("Sorry, This Employee is not found .. try another ID");
        }while( flag == false ); }
    
    @Override
     public String toString() {
     return super.toString() + ",address=" + address + ", mobileNum=" + mobileNum + ", Email=" + Email + ", salary=" + salary;}
     
     public static void checkID(){
          boolean flag =false;
          Scanner input = new Scanner (System.in);
     do{
         System.out.print("Please enter Employee ID: ");
         int check = input.nextInt();
            for (Employee p : employees_list)
                if(check == p.getID()){
                    flag =true;
                    System.out.println("-------------------------------");
                    break;}
            }while (flag == false);
         System.out.println("Welcome!\n");    }
}