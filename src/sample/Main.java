package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception{
    /**
     * This method starts the GUI Program
     *
     */
    //Setup the screen, use the url of StartScreen.fxml
    Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
    //Set the title of the next window
    primaryStage.setTitle("Start Screen");
    //set the elements in the Scene and also it's width and height
    primaryStage.setScene(new Scene(root, 500, 260));
    //show the Screen

    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}