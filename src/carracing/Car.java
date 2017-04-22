/*
 * 2.	Defining the Data Model
 */
package carracing;

import javafx.beans.property.SimpleIntegerProperty;
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
    private final SimpleIntegerProperty time;


    public Car(String regNumber, int carTime)
    {
        this.registrationNumber = new SimpleStringProperty(regNumber);
        this.time = new SimpleIntegerProperty(carTime);
        
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
        registrationNumber.set(regNumber);
    }

    public int getTime()
    {
        return time.get();
    }

    public void setTime(int carTime)
    {
        time.set(carTime);
    }

    @Override
    public String toString()
    {
       
        int min =  getTime()/60;//getIntTime()
        int sec =  getTime()%60;
        return "Car: " + registrationNumber + " time: " + min + " min " + sec + " sec" ;
    }

    //Sorting according to the time in ascending order
    @Override
    public int compareTo(Object compareCar)
    {
        int compareTime=((Car)compareCar).getTime();
        System.out.println("compareTime: " + compareTime);
        System.out.println("this.timeToPass: " + this.time);
        System.out.println("this.timeToPass-compareTime: " + (time.get()-compareTime));
        return getTime()-compareTime;
       
        /* For Descending order do like this */
        //return compareTime-getTime();
    }
    
}
