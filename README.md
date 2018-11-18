# Books FX GUI

* Philemon Petit-Frere
* November 17, 2018
* Demonstrate using a Java GUI with a derby Database


## Overview
<p> This program will allow the user to access a database called "books" and then the user will able to cycle through the rows of that "Author" table. This program exhibits how to connect to a database, how to display results from a database to a JavaFx window and basic functionality of buttons in Javafx.</p>

<p> A detailed rundown on how the program works:<br> 
  1) The startup screen (Image1) tells user to click "Get Started or Quit". If "Get Started" is clicked then the program will open a new window which prompts the user to click the "Connect button"(Image 2). When clicked, the progam runs the ActionEvent that makes a connection to the "Books" Database. IF successful it makes a query for the "firstName, lastName and authorID" columns of the table named Author. This query returns a result set, which the program uses to add data to the screen.
  <br>
  2 ) When that's done the "next" button is now selectable. Every time the "next" is selected, a counter variable is incremented. When the "next" button is clicked the resultset is changed to the next row (for ex. going from AuthorID 1 to Author ID 2). This can be done 4 times as there are only 5 authors listed in the "author table". <br>
  3 )Then there is the "Previous" button which performs the opposite of the "next" button, it's resultset is the row before the current one selected. Using the counter variable the program knows which resultset row it needs. The previous button can only display down to the first authorID. The "previous" button is disabled by default, until the "next" button is selected.<br>
  4 )Lastly, the user can select the "Connect/Restart" button again to restart the counter, and the resultset.</p>


## Images
This is a picture of the start screen, the user can click "Get Started" to begin or "Quit" to leave
![Gui Picture](https://github.com/dekum/BooksFXGUI/blob/master/GuiStart.png?raw=true)<br> 

Included here is a picture of the screen when the database is properly connected. The previous button is selectable here, but is disabled by default. The Next button is selectable when the connection is successful, it moves the resultset to the next row of the table <br>
![Gui Picture](https://github.com/dekum/BooksFXGUI/blob/master/GuiPicture.PNG?raw=true) <br>


And this is a gif of the program running successfully. You can see how the next and the previous button function properly.<br>
![Gui Picture](https://github.com/dekum/BooksFXGUI/blob/master/showcase.gif?raw=true)


 
### Sources
  **Derby**:  an open source relational database implemented entirely in Java. https://db.apache.org/derby/ <br>
  **installation**: https://db.apache.org/derby/papers/DerbyTut/install_software.html <br>
  **IntelliJ IDEA** Java IDE, used to build this program https://www.jetbrains.com/idea/
 
  ## Notes
  Derby needs to be installed for this program to function properly, the install file is provided the "sources" section.
  <br>This was tested November 11/17/18 on IntelliJ 2018 2.3, on a Windows 10 64-bit OS. 
 
