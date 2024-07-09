package oop.project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Flight implements Company {
    
     Scanner input = new Scanner (System.in);
    
    //********* Atrributes *********
    private int flightNo;
    private String originCity;
    private String desCity;
    private double flightDuration;
    private final double price = 2000;
    
    //********* List Atrributes *********
    private static ArrayList<Flight> flights_list= new ArrayList<Flight>();
    //the next 3 lists helped in reserve & search 
    private static ArrayList <Passengers> firstPassengers = new ArrayList<Passengers>();
    private static  ArrayList <Passengers> businessPassengers = new ArrayList<Passengers>();   
    private static ArrayList <Passengers> economyPassengers = new ArrayList<Passengers>();
    
   //********* constructors *********
    public Flight (){}
    public Flight(int flightNo, String originCity, String desCity, double flightDuration) {
        this.flightNo = flightNo;
        this.originCity = originCity;
        this.desCity = desCity;
        this.flightDuration = flightDuration;}
    
    //********* setters *********
    public void setFlightNo(int flightNo) {this.flightNo = flightNo;}
    public void setOriginCity(String originCity) {this.originCity = originCity;}
    public void setDesCity(String desCity) {this.desCity = desCity;}
    public void setFlightDuration(double flightDuration) {this.flightDuration = flightDuration;}
    
    //********* getters *********
    public int getFlightNo() {return flightNo;}
    public String getOriginCity() {return originCity;}
    public String getDesCity() {return desCity;}
    public double getFlightDuration() {return flightDuration;}
    public double getPrice() {return price;}    
    
    //********* methods(add-search-print information (flight & passenger flight)*********
    
    public static void addFlight (Flight newFlight) {flights_list.add(newFlight);} 
    
    public static void addToList (Passengers passenger,int flightClass){ //in passenger reserve option: get the opject and in which class should be added
        switch(flightClass){
            case 1: firstPassengers.add(passenger); break;
            case 2: businessPassengers.add(passenger); break;
            case 3: economyPassengers.add(passenger); break;
            default : System.out.println("invalid class,try again.");} }//end switch - end method
    
    public static void findFlight (int ID){ //by passenger object (taken from method in main(Passengers-> search))-> search passenger collections by class number -> print flght number  
        Scanner input = new Scanner (System.in);
        System.out.print("Passenger's Class | First(1)\tBussnies(2)\tEconomy(3):");
        int Passengerclass = input.nextInt();
        switch(Passengerclass){
            case 1: for(Passengers x : firstPassengers ) //x will take every element ID in firstPassengers then compare it with parameter ID
                        if(x.getID() == ID){
                          System.out.println("the flight NO.:"+x.getFlightNo());
                    break;}
            break;
            case 2: for(Passengers x : businessPassengers )
                        if(x.getID() == ID){
                          System.out.println("the flight NO.:"+x.getFlightNo());
                    break;}
            break;
            case 3:  for(Passengers x : economyPassengers )
                        if(x.getID() == ID){
                          System.out.println("the flight NO.:"+x.getFlightNo());
                    break;}
            break;
            default : System.out.println("This passenger was not found.");
        } } //end switch - end method
           
    //********* override methods *********
    @Override
    public String toString(){
        return "Flight No.:" + flightNo + "\tFlight's Origin City: " + originCity 
                + "\tFlight's Destination City: " + desCity + "\tFlight's Duration: " + flightDuration+"hours";}
     @Override
    public void printInfo( ){ //by flight ID (NO.) -> search flight collection
         //Scanner input = new Scanner (System.in);
        boolean flag = false;
        do{
        System.out.print("Please enter Flight's ID: ");
        int ID = input.nextInt();
        for ( Flight p : flights_list)
            if(p.getFlightNo()== ID){
                System.out.println( p.toString());
                flag = true;
                break;
            }
        if ( flag == false )
        System.out.print("Sorry, This Flight is not found .. try another ID.");
        }while( flag == false ); }      
}