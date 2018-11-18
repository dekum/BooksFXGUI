package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Philemon Petit-Frere
 * 11/17/2018
 * Controller.java
 * This controller will allow the user to press the connect button
 * and then data from the database will appear on the GUI>
 * First the user clicks the connect button which will connect program to the database
 * Then the user can click the next or previous button to move through each row of table.
 * The results are displayed in 3 different labels.
 */
public class Controller {
  int nextClicks=0; //A counter variable to see how many times user clicks next Button.

  @FXML
  Button buttonNext; //This button activates handleNext event, set to disable on default.

  @FXML
  Button buttonPrevious; //This button activates handlePrevious event, set to disable on default.
  @FXML
  private Label lblFirst; //This label will print from the first name Column

  @FXML
  private Label lblLast;//This label will print from the last name Column
  @FXML
  private Label lblID;//This label will print from the ID Column
  @FXML void handlePrevious(ActionEvent event){
    /**
     * This method is called when "Previous" button is clicked
     * This method should only be able to called if Connect was successful.
     * This method only works if next button was already clicked.
     * It will change the 3 labels that show database results and will show results of the previous row.
     */
    //System.out.println(nextClicks);
    if (nextClicks >0)
    {
      nextClicks--; //decrement nextClick variable
      System.out.println(nextClicks+" after mnus");
      // Access the database via a local path. Within the source files, there a folder called
      //lib and in that folder there is a directory called books which stores our database
      final String DATABASE_URL = "jdbc:derby:lib\\books";
      //Use the sql Query "Select" To get data from the "authorID", "firstName" and "lastName"
      //from the table named author.
      final String SELECT_QUERY =
          "SELECT authorID, firstName, lastName FROM authors";
      // use try-with-resources to connect to and query the database
      try (
          //Make a new connection with the database
          Connection connection = DriverManager.getConnection(
              DATABASE_URL, "deitel", "deitel");
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
        // get ResultSet's meta data
        {
          resultSet.next();// This must be done so the results are at the first row
          //System.out.println(nextClicks);
          for (int i =0; i <nextClicks;i++){
            //Keep going to th next row for as many times user clicks button
            resultSet.next();
          }
          //Changes the labels with the new results
          lblFirst.setText(resultSet.getString(2)); //firstName label gets FirstName column Result
          lblLast.setText(resultSet.getString(3));//lastName label gets LastName column Result
          lblID.setText(resultSet.getString(1));//authorID label gets authorID column Result
        }
      } // AutoCloseable objects' close methods are called now
      catch (SQLException sqlException) {
        sqlException.printStackTrace();
      } catch (Exception ex) {
        //Database was unable to connect
        System.out.println("Error");
      }
    }
  }
  @FXML void handleNext(ActionEvent event){
    /**
     * This method is called when "Next" button is clicked
     * This method should only be able to called if Connect was successful.
     * It will change the 3 labels that show database results and will show whats the next,
     * row of the columns.
     * This allows enables the buttonPrevious to be clicked.
     * I would make a class variables of resultset and connections but it the IDE doesn't accept it.
     */
    nextClicks++; //increment nextClicks variable.
    buttonPrevious.setDisable(false); //alow buttonPrevious to be clicked
    // Access the database via a local path. Within the source files, there a folder called
    //lib and in that folder there is a directory called books which stores our database
    final String DATABASE_URL = "jdbc:derby:lib\\books";
    //Use the sql Query "Select" To get data from the "authorID", "firstName" and "lastName"
    //from the table named author.
    final String SELECT_QUERY =
        "SELECT authorID, firstName, lastName FROM authors";

    // use try-with-resources to connect to and query the database
    try (
        //Make a new connection with the database
        Connection connection = DriverManager.getConnection(
            DATABASE_URL, "deitel", "deitel");
        Statement statement = connection.createStatement();
        //Use the previously defined SELECT_QUERY To get resultset
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
      // get ResultSet's meta data
      {
        resultSet.next();// This must be done so the results are at the first row
        //System.out.println(nextClicks);
        if (nextClicks< 5){

          //Max number of rows, stop or program causes an error
          for (int i =0; i <nextClicks;i++){
            //Keep going to th next row for as many times user clicks button
            resultSet.next();
            //Changes the labels with the new results
            lblFirst.setText(resultSet.getString(2)); //firstName label gets FirstName column Result
            lblLast.setText(resultSet.getString(3));//lastName label gets LastName column Result
            lblID.setText(resultSet.getString(1));//authorID label gets authorID column Result
          }
        }
        else{
          nextClicks=4;//Set nextClicks to 4 so user wont have click Previous so many times to go back.
        }
      }
    } // AutoCloseable objects' close methods are called now
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } catch (Exception ex) {
      //Database was unable to connect
      System.out.println("Error");
    }

  }

  @FXML
  void handleConnect(ActionEvent event) {
    /**
     * This actionevent is activated when the "handleConnect" Button is clicked
     * This method will connect the program to the database
     * and then it will change the labels to show the data.
     */
    nextClicks=0; //restart counter
    buttonNext.setDisable(false); //Allows buttonNext to be clicked
    buttonPrevious.setDisable(true); //buttonPrevious is now disabled.

    // Access the database via a local path. Within the source files, there a folder called
    //lib and in that folder there is a directory called books which stores our database
    final String DATABASE_URL = "jdbc:derby:lib\\books";
    //Use the sql Query "Select" To get data from the "authorID", "firstName" and "lastName"
    //from the table named author.
    final String SELECT_QUERY =
        "SELECT authorID, firstName, lastName FROM authors";

    // use try-with-resources to connect to and query the database
    try (
        //Make a new connection with the database
        Connection connection = DriverManager.getConnection(
            DATABASE_URL, "deitel", "deitel");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY)) {
      // get ResultSet's meta data
      {
        resultSet.next(); //This line is important, it set results to first row instead of an error.
        lblFirst.setText(resultSet.getString(2)); //firstName label gets FirstName column Result
        lblLast.setText(resultSet.getString(3));//lastName label gets LastName column Result
        lblID.setText(resultSet.getString(1));//authorID label gets authorID column Result

      }
    } // AutoCloseable objects' close methods are called now
    catch (SQLException sqlException) {
      sqlException.printStackTrace();
    } catch (Exception ex) {
      //Database was unable to connect
      System.out.println("Error");
    }
  }
}
