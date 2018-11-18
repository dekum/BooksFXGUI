package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller.java
 * This controller will allow the user to press the connect button
 * and then data from the database will appear on the GUI>
 *
 *
 */
public class Controller {
  ResultSet resultSet1;
  int nextClicks=0;
  Connection connection;


  @FXML
  private Label lblFirst; //This label will print from the first name Column

  @FXML
  private Label lblLast;//This label will print from the last name Column
  @FXML
  private Label lblID;//This label will print from the ID Column

  @FXML void handleNext(ActionEvent event){
    /**
     * This method is called when "Next" button is clicked
     * This method should only be able to called if Connect was successful.
     * It will change the 3 labels that show database results and will show whats the next,
     * row of the columss.
     *
     *
     *
     */
    nextClicks++; //increment nextClicks variable.
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
        resultSet.next();
        lblFirst.setText(resultSet.getString(2));
        lblLast.setText(resultSet.getString(3));
        lblID.setText(resultSet.getString(1));





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
        resultSet.next();
        lblFirst.setText(resultSet.getString(2));
        lblLast.setText(resultSet.getString(3));
        lblID.setText(resultSet.getString(1));





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
