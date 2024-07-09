package oop.project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
public class Passengers extends Person {
    // Declaring Passengers Class attributes
    private int passportNo;
    private int flightNo;
    private int seatNo;
    private int flightClass;
    private static ArrayList <Passengers> passengers_list = new ArrayList<>();
    Flight passengerFlight = new Flight();

    // Creating an empty & a parameterized constructor
    public Passengers(){}
    public Passengers(String name, int ID, int passportNo, int flightNo, int seatNum,int flightClass) {
        super.setName(name);
        super.setID(ID);
        this.passportNo = passportNo;
        this.flightNo = flightNo;
        this.seatNo = seatNo;
        this.flightClass=flightClass;}

    // Creating 4 setters for Passenger Class attributes
    public void setPassportNum(int passportNo) {this.passportNo = passportNo;}
    public void setFlightNo(int flightNo) {this.flightNo = flightNo;}
    public void setSeatNum(int seatNum) {this.seatNo = seatNum;}
    public void setFlightClass(int classNO) {this.flightClass = classNO;}

    // Creating 5 getters for Passenger Class attributes in addition to flight table
    public int getFlightNo() {return flightNo;}
    public int getSeatNum() {return seatNo;}   
    public int getPassportNo() {return passportNo;}
    public int getFlightClass() {return flightClass;}
    public String getFlightsTable() {
        return "\n"+ getName() + "'s Flights "+"\nFlight No.: " + getFlightNo() + "\nSeat No.: " + getSeatNum();
    }
    
    // This method add a Passenger obj to passengers_list ArrayList created in this class
    public static void addPassenger ( Passengers p ){passengers_list.add(p);}
    
    // This method implements the one in Company interface, it prints passenger's info based on his ID
    @Override
    public void printInfo (){
        boolean flag = false;
        Scanner in = new Scanner (System.in);
        do{
        System.out.print("Please enter Passenger's ID : ");
        int ID = in.nextInt();
        for ( Passengers p : passengers_list)
            if(p.getID()== ID){
                System.out.println( p.toString());
                flag = true;
                break;}
        if ( flag == false )
        System.out.println("Sorry, This Passenger is not found .. try another ID");
        }while( flag == false ); }

    // This method counts how many times a passenger reservesd a flight
    public int PassengerFlights ( int ID ){
        int counter = 0;
        Iterator<Passengers> iterate = passengers_list.iterator();
        while ( iterate.hasNext() ){
            if( (iterate.next()).getID() == ID )
                ++counter;}
        return counter;}
    
    // This method calculates the price of the passenger flights based on his ID
    public void calculatePrice (){       
        boolean flag = false;
        Scanner in = new Scanner (System.in);
        do {
        System.out.println("Please enter Passenger's ID : ");
         int ID = in.nextInt();
          for(Passengers p : passengers_list)
              if(p.getID()== ID){
                  System.out.println(p.getName() +"'s Flight price is "+ ( passengerFlight.getPrice() * PassengerFlights(p.getID()) ) );
                  flag = true;
                  break;}
          if ( flag == false )
              System.out.println("Sorry, This passenger is not found .. try another ID");
        } while ( flag == false );}
    
    @Override
    public String toString()
    {   return super.toString()+ "\tPassport No.: " + passportNo + "\t"+ this.getFlightsTable() ;   }}

