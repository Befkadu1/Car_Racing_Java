/*
 * 2.	Defining the Data Model
 */
package carracing;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Befkadu Degefa
 */
public class Car implements Comparable
{
    /*
    The registrationNumber and time are created to enable the referencing of a particular data element.
    */
    private final SimpleStringProperty registrationNumber;
    private final SimpleStringProperty time;
    //String registrationNumber;
    //int time;
    private int intTime;

    public Car(String regNumber, String carTime)
    {
        //this.registrationNumber = registrationNumber;
        //this.time = time;
        this.intTime = Integer.parseInt(carTime);
        this.registrationNumber = new SimpleStringProperty(regNumber);
        this.time = new SimpleStringProperty(carTime);
        
    }
    
    /*
    The get and set methods are provided for each data element. Thus, for example, 
    the getRegistrationNumber method returns the value of the registrationNumber property, 
    and the setRegistrationNumber method specifies a value for this property.
    */

    public String getRegistrationNumber()
    {
        return registrationNumber.get();
    }

    public void setRegistrationNumber(String regNumber)
    {
        //this.registrationNumber = registrationNumber;
        registrationNumber.set(regNumber);
    }

    public String getTime()
    {
        //return time.get();
        int min =  getIntTime()/60;
        int sec =  getIntTime()%60;
        return  Integer.toString(min) + " min " + Integer.toString(sec) + " sec" ;
    }

    public void setTime(String carTime)
    {
        //this.time = time;
        time.set(carTime);
    }

    public int getIntTime()
    {
        return intTime;
       
    }

    public void setIntTime(int intTime)
    {
        this.intTime = intTime;
    }
  


    @Override
    public String toString()
    {
       
        int min =  getIntTime()/60;
        int sec =  getIntTime()%60;
        return "Car: " + registrationNumber + " time: " + min + " min " + sec + " sec" ;
    }

    //Sorting according to the time in ascending order
    @Override
    public int compareTo(Object compareCar)
    {
        
        int compareTime=((Car)compareCar).getIntTime();
        System.out.println("compareTime: " + compareTime);
        System.out.println("this.timeToPass: " + this.intTime);
        System.out.println("this.timeToPass-compareTime: " + (this.intTime-compareTime));
        return this.intTime-compareTime;
        /*
        int compareTime=((Car)compareCar).getTime();
        System.out.println("compareTime: " + compareTime);
        System.out.println("this.time: " + this.time);
        System.out.println("this.time-compareTime: " + (this.time-compareTime));
        return this.time-compareTime;
        */
        
        /* For Descending order do like this */
        //return compareTime-this.time;
    }
    
}
