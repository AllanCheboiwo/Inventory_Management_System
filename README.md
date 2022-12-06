# Inventory-Management-System
We are building a generic inventory system, for our project, that could be used for any business. 
The system can be customized for, or by, a business to suit their specific type of inventory.
It can help to manage a business’ stock by keeping track of all inventory on hand,
the rate at which the inventory is reduced,and suggested dates to reorder new stock.
This allows the system to send alerts to warn of low inventory or reminders to place an order with a product vendor. 
Alerts can also be generated to warn of vendor changes such as price changes or new products added. 
The user can select specific inventory to generate an order to send out to product vendors and they can also generate reports with any pertinent information that the system stores about the inventory.

# WHAT WE DID LAST TIME
1. Creates a product
2. Stores the product on a file 
3. Loads the file with the product everytime the program is run
4. Print the products that are currently in the invenotry
5. Modify the quantity of products in the inventory
6. Print the products that are running low

# WHAT WE HAVE DONE THIS ITERATION
1. We migrated from the fileserver system to mySQL(Library) database to store the products
2. In addition to the previous classes, we added two classes: Supplier class, User class and supply class
3.We used the commons apache email library to send alerts to Users about products that are low in inventory
4.We used the java preferences library to store the database connection credentials
5.We created a graphical user interface using java swing library
6. We used the java time library to calculate the rate at which products are moving. This helps determine which stocks are moving fast and recalibrate what we will order next time
7.We also generated reports for specific queries which we can send to vendors if need be

# Setting up the database
1. Download docker desktop
2. Download visual studio code
3. Open your terminal and navigate it to the COSC 310 folder in you local repository of the project
4. Run the command: docker-compose up -d
 If everything is successful, the MySQL database will start on port 3306. If there is a port conflict, change the port to 3307 in the docker-compose.yml file in the COSC 310 folder
5. Run the command: docker exec -it inventorySystem-mysql bash
6. Run the command: mysql -u team22 -p
    The password is in the docker-compose.yml file
7. Enter password(The password is in the docker-compose.yml file)
If successful
Open VS code and create a connection to the database using the username and password from the docker-compose.yml file

# HOW TO COMPILE AND RUN THE PROGRAM
1. Clone the repository to your computer
2. Import the files in the repository as a project in you IDE that supports java preferebly VS CODE/eclipse
3. Open the COSC 310 Folder
4. Open the src folder
5. Open the proj folder
6. Run the java files in the proj folder. The program should execute

# README 2
1. We migrated from the fileserver system to mySQL(Library) database to store the products.This enhanced the security of our data since a user will require credentials to access it. MySql also reduced chances of duplicate records via keys. Also it made it easier for us to query the data using sql
<img width="1146" alt="Screen Shot 2022-11-13 at 6 30 34 PM" src="https://user-images.githubusercontent.com/84111301/201563347-ff197ba5-21c5-40ac-9a89-0a5023612ac1.png">

<img width="1200" alt="Screen Shot 2022-11-13 at 6 31 18 PM" src="https://user-images.githubusercontent.com/84111301/201563372-a41b936a-6981-4dc0-a571-04d81f503bf5.png">

<img width="1243" alt="Screen Shot 2022-11-13 at 6 32 19 PM" src="https://user-images.githubusercontent.com/84111301/201563379-88218ae8-2caf-4197-ba05-fab0f5d34ce3.png"><img width="1501" alt="Screen Shot 2022-11-13 at 6 33 53 PM" src="https://user-images.githubusercontent.com/84111301/201563390-273d248d-6649-4582-b1f2-a39ffd9c46bf.png">
<img width="1512" alt="Screen Shot 2022-11-13 at 6 34 39 PM" src="https://user-images.githubusercontent.com/84111301/201563399-0a8b710c-6aef-466d-ac36-2f834cdc4819.png">


2.We used the commons apache email library to send alerts to Users about products that are low in inventory
<img width="865" alt="Screen Shot 2022-11-13 at 6 19 41 PM" src="https://user-images.githubusercontent.com/84111301/201563546-e4c57071-2dfe-49fe-a5a3-4a3050569589.png">
<img width="793" alt="Screen Shot 2022-11-13 at 6 27 56 PM" src="https://user-images.githubusercontent.com/84111301/201563620-a787e0d4-c08b-482b-8d25-af2be47c29cd.png">
<img width="983" alt="Screen Shot 2022-11-13 at 6 28 32 PM" src="https://user-images.githubusercontent.com/84111301/201563632-e8c08576-c592-4911-b0f3-5bed6bb176e7.png">


3.We used the java preferences library to store the database connection credentials. This avoided hardcoding the credential which results in security libality. Thus, it made our program more secure.
<img width="1512" alt="Screen Shot 2022-11-13 at 6 16 41 PM" src="https://user-images.githubusercontent.com/84111301/201563756-5733a147-8c01-491a-b356-03da708bd8de.png">
<img width="527" alt="Screen Shot 2022-11-13 at 6 17 01 PM" src="https://user-images.githubusercontent.com/84111301/201563765-40313c85-f6b0-4086-aac9-5d04ff333cf7.png">
<img width="828" alt="Screen Shot 2022-11-13 at 6 17 53 PM" src="https://user-images.githubusercontent.com/84111301/201563771-6ec3d337-0730-4dfe-abad-91534cf134c7.png">



4.We created a graphical user interface using java swing library. The GUI made our program more user friendly and easier for any end user to use

<img width="1512" alt="Screen Shot 2022-11-13 at 6 16 41 PM" src="https://user-images.githubusercontent.com/84111301/201563820-5c16c60b-3dab-4e1d-87f8-e634d77e6967.png">
<img width="874" alt="Screen Shot 2022-11-13 at 6 18 52 PM" src="https://user-images.githubusercontent.com/84111301/201563835-735c0d6b-efa6-4e54-b59d-f861d2ada4d5.png">
<img width="808" alt="Screen Shot 2022-11-13 at 6 19 14 PM" src="https://user-images.githubusercontent.com/84111301/201563850-83a14247-5e3a-4c3e-8a3d-25b93d93ed34.png">
<img width="796" alt="Screen Shot 2022-11-13 at 6 25 11 PM" src="https://user-images.githubusercontent.com/84111301/201563875-c9d01c71-b2cf-4a34-aec3-6bc99b6d4e90.png">

5. We used the java time library to calculate the rate at which products are moving per day. This helps determine which stocks are moving fast and recalibrate what we will order next time.
 
 <img width="464" alt="Screen Shot 2022-11-13 at 8 31 29 PM" src="https://user-images.githubusercontent.com/84111301/201575988-42670947-a3b3-4fa2-9116-b635def5eeeb.png">

<img width="449" alt="Screen Shot 2022-11-13 at 8 30 04 PM" src="https://user-images.githubusercontent.com/84111301/201575948-19b1fd32-6fd0-4b27-9389-7287c044417e.png">
<img width="504" alt="Screen Shot 2022-11-13 at 8 30 43 PM" src="https://user-images.githubusercontent.com/84111301/201575979-3fe72e79-7560-4427-8773-5da7e36524d2.png">


6.We also created reports. This will enable us to present/show what we have . It also clearly shows results of queries
<img width="710" alt="Screen Shot 2022-11-13 at 6 43 10 PM" src="https://user-images.githubusercontent.com/84111301/201564674-eeb01c95-8e79-4de8-b755-86b8ffa5a6d7.png">
<img width="455" alt="Screen Shot 2022-11-13 at 6 44 29 PM" src="https://user-images.githubusercontent.com/84111301/201564680-5649b1e4-bdaf-47f6-8a86-8120bcdb2132.png">
<img width="386" alt="Screen Shot 2022-11-13 at 6 45 43 PM" src="https://user-images.githubusercontent.com/84111301/201564689-77719d54-0225-4b15-aac4-acb046e6c951.png">



# READ ME 3
-In this iteration I added two functionalitites to enable the user to create events and tasks and diplay them.
-I used:
(i)Google Calendar API-to create events
(ii)Google Tasks API-to create a taskList(TO DO LIST) AND task

# Google Calendar API 
-An example of an event for our system is the delivery of an order
-The user would create an event for the order that includes the date and time it arrives and person responsible.
-This would be added to the google calendar for the email(admin) used for authentication process of the API
-An email would be sent to the person responsible for the task as a form of reminder.
-The events that have been created are displayed on the users main page using a get function
-This new functionality helps the user keep track of and plan events such orders,restock and auting keeping them more organized

# Google Tasks API
-I used the API to create a to do list for the user
-The user is able to create tasks(TO DO'S) and check them as completed after they have done
-The main page shows tasks that have not yet been completed
-This serves as productivity tool that helps the user plan their or week and accomplish their tasks



