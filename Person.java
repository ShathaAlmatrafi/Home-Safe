package oop.project;
public abstract class Person implements Company{
    
    private String name;
    private int ID;

    public void setName(String name) {      this.name = name;       }
    public void setID(int ID) {     this.ID = ID;       }
    
    public String getName() {       return name;        }
    public int getID() {        return ID;      }

    @Override
    public String toString() {      return  "Name:" + name +"\tID:" + ID ;       }
        

}