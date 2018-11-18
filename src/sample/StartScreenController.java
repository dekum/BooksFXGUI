package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Philemon Petit-Frere
 * 11/17/208
 * StartScreenController.java
 * This is the controller for the StartScreen.fxml
 * This is the first screen the user will see, and it will allow the user to open the next window
 * or allow the user to exit the program
 *
 */

public class StartScreenController {

  @FXML
  Button btnExit;

  @FXML
  public void handleStart(ActionEvent evevt){
    /**
     * This method opens a new FXML window
     *
     */
    //To set the stage to exit, use a FXML Element and get it's scene
    Stage stage = (Stage) btnExit.getScene().getWindow(); //Get the current window from the btnExit element
    stage.close(); //Close current Window

    //New FXML Loader, to open a new FXML file
    FXMLLoader Loader = new FXMLLoader();
    //set the Location of the loader to the url of the sample.FXML
    Loader.setLocation(getClass().getResource("sample.fxml"));
    try {
      Loader.load(); //Open the new fxml window.
    }catch ( IOException ex){
      //Check for error
      Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null ,ex);

    }
    //Set new parent window
    Parent p = Loader.getRoot();
    stage = new Stage();
    //set the title for the new window
    stage.setTitle("BooksFX GUI");
    //set the new scene
    stage.setScene(new Scene(p));
    stage.show(); //Opens new Window
  }
  @FXML void  handleQuit(ActionEvent event){
    /**
     * This method Exit Program, closes window
     */
    //To set the stage, use a FXML Element and get it's scene
    Stage stageExit = (Stage) btnExit.getScene().getWindow();
    //closes the program
    stageExit.close();
  }
}
