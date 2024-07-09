package oop.project;
//importing needed classes  
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class main {
    public static void main (String [] args) throws IOException{ 
        try{
        File emplyeesFile = new File ("path here");//get the file path & save it
        Scanner read = new Scanner(emplyeesFile);//open file to read from 
       
        while (read.hasNext()){ //to read info from the file
        String emplyee_name = read.next();
        int emplyee_ID =read.nextInt();
        String emplyee_address =read.next();
        int emplyee_mobileNumber =read.nextInt();
        String emplyee_email = read.next();
        double emplyee_salary = read.nextDouble();
        
        Employee m = new Employee(emplyee_name,emplyee_ID,emplyee_address,emplyee_mobileNumber,emplyee_email,emplyee_salary);//after reading -> send data in employee constructor to create new one
        m.addEmployee(m); // add obj to arrayList which exist in employee class so we need to this method to deal with it from the main 
        //since method is instance used the same object sent as an argument for invoakion & there is another way by make it static 
            //System.out.println(m); //print employee info after create it as objrct 
        } //end while
        read.close(); //close Scanner object
        
        int selection , choice_1 , choice_2, choice_3; //selection for the main menu,choice_1 for inner employee menu,choice_2 for inner passemgers menu,choice_3 for inner flight menu 
        Scanner input = new Scanner(System.in); //Scanner object to read selections from the user
        System.out.println(Company.info);
        System.out.println("-------------------------------");
       
//        boolean flag =false;
//        do{
//            System.out.print("please enter Employee ID:");
//            int checkID = input.nextInt();
//            for (Employee p : employees_list)
//                if(checkID == p.getID()){
//                    System.out.println("get in");
//                    flag =true;
//                    break;}
//            }while (flag == true);
         Employee.checkID();
        do {   
        
        System.out.println("Menu: \n1-Staff Screen \n2-Passengers Screen \n3-Flight Screen \n4-Exit ");//print the menu
        System.out.print("Please enter your choice: ");        
        selection = input.nextInt(); //to select between the 3 main subjects
        System.out.println("-------------------------------");
        //-----------------------------------------------------------------------------------------------------------------------------------------
        switch ( selection ){
            case 1 : //employee section 
                    do {
                        System.out.println("Menu: \n1-Add Employee \n2-Print Employee Information \n3-Back To The Main Screen ");//to put the choices exist in employee menu
                        System.out.print("Please enter your choice: ");
                        choice_1 = input.nextInt();
                        switch (choice_1) {
                            case 1: //to add employee
                                System.out.print("Please enter the Employee Information: ");
                                System.out.println("Enter the Employee Name:");
                                String name =input.next();
                                System.out.println("Enter the Employee ID:");
                                int ID =input.nextInt();
                                System.out.println("Enter the Employee Address:");
                                String address =input.next();
                                System.out.println("Enter the Employee phone number:");
                                int mobileNum =input.nextInt();
                                System.out.println("Enter the Employee E-mail:");
                                String email =input.next();
                                System.out.println("Enter the Employee salary:");
                                double salary =input.nextDouble();
                                Employee x = new Employee(name,ID,address,mobileNum,email,salary);
                                x.addEmployee(x);
                                System.out.println("-------------------------------");
                                break;
                            case 2: //to print info
                              (new Employee()).printInfo();
                              System.out.println("-------------------------------");
                                break;
                            case 3: //back to employee menu
                                continue;//it terminates the current iteration of the menu - if we use break then it breaks the outer switch and return us to the main menu
                            default :
                                System.out.println("You have entered an invalid choice .. Please try again");}
                    } while (choice_1 != 3); // 3 means Exit
                    System.out.println("-------------------------------");
                    break;
        //--------------------------------------------------------------------------------------------------------------------------------------
case 2 : //passengers menu
                do{
                System.out.println("Menu: \n1- Reserve a flight. \n2- Print the passenger info. \n3- Calculate cost of passenger's flights \n4- Back to main screen.");
                System.out.println("Please enter your choice: ");
                choice_2 = input.nextInt();
                switch ( choice_2 ){
                    case 1 : //to reserve (Filling Passenger information from user -> create new object -> add it to Passengers list)
                        System.out.println("Please enter the following information : ");
                        System.out.print("Passenger's Name : "); 
                        String passenger_name = input.next();                       
                        System.out.print("Passenger's ID : ");
                        int passenger_ID = input.nextInt();
                        System.out.print("Passenger's Passport No. : ");
                        int passenger_passportNo = input.nextInt();
                        System.out.print("Passenger's Flight No. : ");
                        int passenger_flightNo = input.nextInt();
                        System.out.print("Passenger's Seat No. : ");
                        int passenger_seatNo = input.nextInt();
                        System.out.print("Passenger's Class | First(1)\tBussnies(2)\tEconomy(3):");
                        int passengerClass = input.nextInt();
                        
                        Passengers p = new Passengers(passenger_name , passenger_ID , passenger_passportNo , passenger_flightNo , passenger_seatNo , passengerClass);
                        p.addPassenger(p);
                        Flight.addToList( p , p.getFlightClass()); //add the Passenger in propper collection based on chosen class
                        System.out.println("-------------------------------");
                        break;
                    case 2 : //print info 
                        new Passengers().printInfo();
                        System.out.println("-------------------------------");
                        break;
                    case 3 : //calculate cost
                        (new Passengers()).calculatePrice();
                        System.out.println("-------------------------------");
                        break;
                    case 4 : //back to main menu
                        continue;
                    default :
                        System.out.println("You have entered an invalid choice .. Please try again");}
                } while ( choice_2 != 4 ); //4 means Exit
                System.out.println("-------------------------------");
                break;
        //--------------------------------------------------------------------------------------------------------------------------------------
            case 3:  //Flight menu   
             do{
                System.out.println("Menu: \n1-Add Flight. \n2-Print Flight info. \n3-find passenger's flight \n4-Back to main menu.");
                System.out.print("Please enter your choice: ");
                choice_3 = input.nextInt();
                switch ( choice_3 ){
                    case 1 : //to add new flight
                        System.out.println("Please enter Flight information:");
                        System.out.print("Flight number:");  
                        int flightNum = input.nextInt();                        
                        System.out.print("Origin City:");
                        String originCity = input.next();
                        System.out.print("Destnation City:");
                        String desCity = input.next();
                        System.out.print("Flight duration: ");
                        double duration = input.nextDouble();
                        
                        Flight newFlight = new Flight(flightNum,originCity,desCity,duration);
                        Flight.addFlight(newFlight);
                        System.out.println("Done!");
                        System.out.println("-------------------------------");
                        break;
                    case 2 : //print info
                        (new Flight()).printInfo();
                        System.out.println("-------------------------------");
                        break;
                    case 3 : //find passenger flight
                        System.out.print("Passenger's ID : ");
                        int ID = input.nextInt();
                        Flight.findFlight(ID); 
                        System.out.println("-------------------------------");
                        break;
                    case 4 : //back to main menu
                        continue;
                    default :
                        System.out.println("You have entered an invalid choice .. Please try again");
                }
                } while ( choice_3 != 4 ); //4 means Exit
                break;
            case 4 : //final Exit of entire program
                System.out.println("-------------------------------");
                System.out.println("Thank you for choosing HOME SAFE airlines \nEnjoy your day");
                break;
            default:
                System.out.println("You have entered an invalid choice .. Please try again");}
        }while (selection != 4); 
        }catch(IOException e){System.out.println("input/output Exception occurred.");}
         catch(InputMismatchException e){System.out.println("You have enterd invalid input.");}       
        
}} //end main - end Class