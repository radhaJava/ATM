
 #                                               ATM



## About ATM Project
This project is a  ATM interface. It will emulate the basic functionality of an actual ATM. To use the system users need to be authenticated before being allowed into the system. The credentials consist of a password and a unique username. After entering the correct credentials, users can see their bank details like account balance and perform actions such as transfer, withdraw, deposit and quit. This is a complex project, therefore you need to divide responsibilities into different classes and objects.The app is to be terminal based.

## Introduction

The system starts  with Home page  which gives option to choose- login with their username and password or choose- Signup option , or choose - exit menu to come out of the application.The login option is for already having account (exisiting customer) and Signup is to be come customer which will ask to create a new login username and password.The signup option will ask for Customer full name as well as username and password to set/save for further login process. These are saved in a special way so that the password cant be visible while typing and also cant get even get the password details by others  when they open the saved customer details file (  including ATM bank user/admin too done by MessageDigest).
The customer full name is unchangeable but as a user if they prefer to change the username and password, but they are verified before doing the changes.Both Customer full name and customer name is unique to avoid redunendy so it will check in saved file and ask to enter with new unique way.
On entering the details successfully, then ATM functionalities are unlocked.
ATM functionality include Account setting(view balance,change username ,change password), withdraw money, deposit, transfer money and Logout.  
			Code is done in data security and reusability features of object oriented concepts.
The user interface from the terminal must be user-friendly, telling the user which possible options they can do in each stage of the application.


## Usage
Customer must feel safe with their money when its in their bank and their main consideration is procetction with their password and save banking which isa focused on this ATM project.The customer get a home page  once user either create a account and then login or already having account and choose to  Login ,In both the cases their inputs  are validated with their saved password in the back and  once it verififed they have access to account details.if they fail to verify thier account they are given direction to check username and password which was entered.
![Home page Menu](https://user-images.githubusercontent.com/82042927/189363818-f5268ae3-4441-4066-9d23-249b88bf7b3f.png)

In the account page  displayed with customer name in top and they have menu option like account setting and deposit and withdraw and tranfer amount and logout.![Account PAge menu with Customer Welcome](https://user-images.githubusercontent.com/82042927/189364213-60e7827c-1dfa-4c61-8b17-6efad1f52d22.png)
The account setting have further menu to view balance and option to change their username and change password ,though they have login already while changing the credienticials they opt to enter again thier username and password , then verfied  to ask for changing the new username and password.
![Account details Setting menu](https://user-images.githubusercontent.com/82042927/189364325-fe544514-28c2-43c2-b210-64b1ebef55bf.png)


The deposit option will ask amount to enter and it will deposit but for withdraw and tranfer it will check the customer balance in the account and will intimate the custoemr if the  account balance is lss then withdraw amount or tranfer amount.
For tranfer amount it will also check the entered user name which the customer want to tranfer amount and if the user also valid then only we can check the balance amount to tranfer and then tranfer and update both the account with the amount.
This account menu option will be shown after every process inorder for customer to do what they prefer to do until they logout of the account and their accoutn details are updated and read before every time this menu was shown to avoid false details to customer.
Once thewy logout the user gets home page where they may either exit or login with other customer or signup.

## Technologies
            -User Stories(Jira)
            -UML Usecase diagram(Lucidchart)
            -UML Sequence daigram(Lucidchart)
            -UML Class diagram (PlantUML)
            -Developed code in IntellliJ Idea Community version using Java 17.0.2

The above diagrams are find in Requirements folder .Step by step creation of how project requiremnt started with User Stories and task and also usecases and then sequence daigram and then class diagram and then to code is shown in screenshots.The entire process followed agile methodology.
## Launch
             To run the Jar file in commandprompt(cmd) using java -jar ATM.jar 
## Room for Improvements
Project must have been checking the account details like userName with account details. It contains the authentication code for the user. The application handles any exception in a clean way (using exception classes and not only conditional statements) and prints out an error-message telling the user what the problem is,without ending or crashing the app.Include some unit test cases.
