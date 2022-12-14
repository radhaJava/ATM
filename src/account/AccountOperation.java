package account;

import Util.PrintHandler;
import customer.Customer;
import customer.CustomerValidation;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;
/*
Account operation using CustomerValidation to read customer details from file  and use the index number to match with other fields
to perform deposit , withdraw, tranfer
and also to update the changes made during above action in the file using Customer.updateFile method
 */

public class AccountOperation extends CustomerValidation {
    private static final Scanner sc = new Scanner(System.in);
    String customerFullName, customerUserName, customerPassword, customerBalance;
    BigDecimal accountBalance;
    BigDecimal bigDecimalUserInputAmount;


    int number = getCustomerNumber();

    public AccountOperation() {

        customerFullName = customerNameList.get(number);
        customerUserName = userNameList.get(number);
        customerPassword = passwordList.get(number);
        customerBalance = balanceList.get(number);
        accountBalance = new BigDecimal(customerBalance);

    }

    public void withdrawAmount() {

        System.out.print("Please enter the amount you want to withdraw from  your account : ");
        bigDecimalUserInputAmount = BigDecimal.valueOf(PrintHandler.scanUserNumberInput());
        if (accountBalance.compareTo(bigDecimalUserInputAmount) >= 0) {
            accountBalance = accountBalance.subtract(bigDecimalUserInputAmount);
            System.out.println(" new available balance " + accountBalance);
            String newLine = (customerFullName + "," + customerUserName + "," + customerPassword + "," + accountBalance);
            try {
                Customer.updateFile(number, newLine);
            } catch (IOException e) {
                System.out.println("error in withdraw fiel to update");

            }

        } else {
            System.out.println("The balance is less than withdraw amount");
        }
    }

    public void depositAmount() {
        readCustomerList("customers.txt");
        System.out.print("Please enter the amount you want to deposit to your account :");
        bigDecimalUserInputAmount = BigDecimal.valueOf(PrintHandler.scanUserNumberInput());
        accountBalance = accountBalance.add(bigDecimalUserInputAmount);
        System.out.println(" new available balance " + accountBalance);
        String newLine = (customerFullName + "," + customerUserName + "," + customerPassword + "," + accountBalance);
        try {
            Customer.updateFile(number, newLine);
        } catch (IOException e) {
            System.out.println("error in deposit field to update");
        }

    }

    public void transferAmount() {
        readCustomerList("customers.txt");
        getTransferCustomerName();


    }


    private void getTransferCustomerName() {

        System.out.print("Enter the Unique user name to transfer the amount  :");
        String transferUsername = PrintHandler.scanUserStringInput();


        for (int i = 0; i < userNameList.size(); i++) {
            if (transferUsername.equalsIgnoreCase(userNameList.get(i))) {
                int transferCustomerNumber = i;
                TransferAmountFromCustomer(transferCustomerNumber);
                break;
            } else if (i == userNameList.size()) {
                System.out.println("User name is not in our ATM system");
            }
        }

    }

    public void TransferAmountFromCustomer(int transferCustomerNumber) {

        System.out.print("Enter transfer amount to transfer :");
        BigDecimal transferAmount = new BigDecimal(PrintHandler.scanUserInput(sc.nextLine()));
        if (accountBalance.compareTo(transferAmount) >= 0) {
            accountBalance = accountBalance.subtract(transferAmount);
            String newLine = (customerFullName + "," + customerUserName + "," + customerPassword + "," + accountBalance);
            try {
                Customer.updateFile(number, newLine);
                BigDecimal amountToTransferAnotherCustomer = transferAmount;
                UpdateTransferCustomer(transferCustomerNumber, amountToTransferAnotherCustomer);
            } catch (IOException e) {
                System.out.println("error in tranfer to customer  update");

            }

        } else {
            System.out.println("Sorry :The balance is your account is less then transfer amount");
        }

    }


    private void UpdateTransferCustomer(int transferNumber, BigDecimal transferAmount) {

        String fullName = customerNameList.get(transferNumber);
        String userName = userNameList.get(transferNumber);
        String pass = passwordList.get(transferNumber);
        String balan = balanceList.get(transferNumber);
        BigDecimal balanB = new BigDecimal(balan);
        balanB = balanB.add(transferAmount);
        String newLine = (fullName + "," + userName + "," + pass + "," + balanB);
        try {
            Customer.updateFile(transferNumber, newLine);
        } catch (IOException e) {
            System.out.println("error in  field to update");
        }
        System.out.println("Transfer to the Account is also updated");


    }


}
