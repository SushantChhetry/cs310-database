# cs310-database
# Database and JSON CONVERTOR

## Project Summary
This program retrieves data from a sample database and parses it into an array of JSON objects. It is written in Java 8 and makes use of third party library json-simple and the JSONObject and JSONArray classes as well as MySQL database.
The database for this assignment is a simple list of twenty names and addresses, stored in a single table called "people".  For each record (or row) in the table, your program should retrieve the value from each field (or column), and store these values (with the exception of the numeric id) in a new JSONObject, using the field (column) names as the key names.  These JSON objects should then be added to a JSONArray, in the same order in which the corresponding records appear in the database.  The JSONArray should then be returned to the caller.

JSON
JSON stands for "JavaScript Object Notation", and it is used as a general-purpose format for many kinds of data, particularly in Web-based applications; again, see the "Data Exchange" lecture notes for more details. 

## Running the Program
Before starting program, install the MySQL server on your workstation. First, import the attached "p2_test.sql" database, using the MySQL Administrator or the MySQL.
To run this program, you'll need Java 8, Netbeans, json simple library. Once you have all these requirements, you can clone this program link in your workstation. Afterwards, you can create a Netbeans project with existing files (i.e. the clone source files).
The requirements to run this program are as follows:
•	Java 8
•	Netbeans (or any other IDE)
•	Libraries: json-simple 
•	MySQL Administrator or the MySQL Workbench
•	p2_test.sql
(Ensure that there are four compile-time libraries added to the project: json-simple, JUnit 4.x, and Hamcrest 1.x. In the NetBeans project tree, right-click the project name (""cs310-database "), select "Properties", and in the "Project Properties" tree, choose "Libraries" from the list of categories. If any libraries are missing, click "Add Library" and add them from the list of libraries.  Click "OK" to commit your changes.)
 After these requirements are fulfilled, you can clone the program link to your workstation. Then, creating a new project in Netbeans with existing files (i.e. the clone source files)

## Classes Documentation
“cs310-database” contains classes: DatabaseTest and one test class
________________________________________
Class: DatabaseTest
________________________________________
This is the main class of cs310-database that communicates with Convertor class and provides the necessary data.
Methods
Returns	Method
JSONArray	getJSONData()
	Method to execute convertor
String	JSONArray()
	To create new JSON array.
String	ArrayList()
	Create a resizable arraylist.
Integer	JSONObject()
	Creates new JSON Object
String	toString()
	Returns a string representation of the object


________________________________________
Class: JSONParseTest
________________________________________
This is a test class for the Database/JSON convertor.
Methods
Returns	Method
Void	setUp()
	A method used by the class JSONParseTest to prepare for the test methods.
void	testConvertCSVtoJSON()
	A test method used by the class ConvertorTest to check converted database and JSON results.
________________________________________
## Contributors
The following are the contributors for "cs310-database ": here
________________________________________
