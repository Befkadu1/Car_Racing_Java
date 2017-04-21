/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carracing;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author Befkadu Degefa
 */
public class FXMLDocumentController implements Initializable
{

    
    @FXML
    public TextField carRegNumberTextField;  //TextField for the car's registration number
    
    @FXML
    public TextField timeTextField;  //TextField for the car's registration number
    
    @FXML
    private ImageView imageView;
    //ArrayList for cars, to save the cars' registration numbers with their times in the race
    public static ArrayList<Car> carArrayList = new ArrayList();
    
    // When the data model is outlined in the Car class, ObservableList array is created
    //3.	Defining Table Data in an Observable List
   // public static ObservableList<String> carsObservableList ;
    public static ObservableList<Car> carsObservableList ;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException
    {
        String registrationNumber = carRegNumberTextField.getText();
        String carTime = timeTextField.getText();
       // int carTimeInteger = Integer.parseInt(carTime);
        Car carRacingWinners = new Car(registrationNumber, carTime);
        carArrayList.add(carRacingWinners);
        
        Collections.sort(carArrayList);

                   for(Car car: carArrayList){
                        System.out.println("test: "+ car);
                         carsObservableList.add(car);
                   }
                
        
        //To show the sorted Car racing winners on the ListView of the CarRacingResults.fxml        
        /*for(Object eachCar : carArrayList){
           //carsObservableList.add(eachCar.toString()); 
           carsObservableList.add(eachCar);           
        }*/
        System.out.println("carArrayList " + carsObservableList.get(0).getRegistrationNumber());
        
        //forwarding the scene to "DriverTaxiCheck.fxml" if all the boxes are filled
            Parent root2 = FXMLLoader.load(getClass().getResource("CarRacingResults.fxml"));
            Scene scene = new Scene(root2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Car racing results");
        
    }
    
    private void loadImage(){
        Image image = new Image(getClass().getResourceAsStream("carImage.png"));
        imageView.setImage(image); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {               
        //carsObservableList initialized 
        carsObservableList = FXCollections.observableArrayList();
        loadImage();
    } 
    

    
}
