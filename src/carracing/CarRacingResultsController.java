/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carracing;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Befkadu Degefa
 */
public class CarRacingResultsController implements Initializable
{

    /**
     * Initializes the controller class.
     * 1.	The table is created on the Scene builder
     */
   /* @FXML
    private ListView carsListView; //ListView for the car
    */
    @FXML
    private TableView<Car> carTableView;
    
    @FXML
    private Label winnerCarLabel;
    
    @FXML
    private TableColumn<Car,String> carRegNoColumn ;

    @FXML
    private TableColumn<Car, String> carTimeColumn;
    
    @FXML
    private ImageView imageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        //carsListView.setItems(FXMLDocumentController.carsObservableList);
        //4.	Associate the data with the table columns
        carRegNoColumn.setCellValueFactory(new PropertyValueFactory<>("registrationNumber"));
        carTimeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        carTableView.setItems(FXMLDocumentController.carsObservableList);
        if(FXMLDocumentController.carsObservableList.size()>1){
           winnerCarLabel.setText("The winner is " + FXMLDocumentController.carsObservableList.get(0).getRegistrationNumber()); 
        }
         loadImage();
        
    }  
    
     @FXML
    private void backButton(ActionEvent event) throws IOException
    {
        //forwarding the scene back to "DriverTaxiCheck.fxml" if all the boxes are filled
            Parent root2 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Car racing results");
        
    }
    
        private void loadImage(){
        Image image = new Image(getClass().getResourceAsStream("carImage.png"));
        imageView.setImage(image); 
    }
    
    
}
