package com.cg.banking.client;
import java.util.ArrayList;
import java.util.Scanner;
import com.cg.banking.exceptions.*;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;
public class MainClass {
	public static void main(String[] args) throws BankingServicesDownException, AccountDetailsNotFoundException, CustomerDetailsNotFoundException {
		Scanner s = new Scanner(System.in);
		String firstName,lastName,emailId,department,designation,pancard,bankName,ifscCode;
		int associateID,yearlyInvestmentUnder80C,basicSalary,accountNumber;
		int key;
		BankingServices bankingServices = new BankingServicesImpl();
		do{
			System.out.println("Welcome to Capgemini Banking System");
			System.out.println("Enter your choice:");
			System.out.println("1. Enter Customer Details.");
			System.out.println("2. Get Associate Details.");
			System.out.println("3. Calculate Net Salary.");
			System.out.println("4. Get all associate details.");
			System.out.println("5. Exit");
			key=s.nextInt();
			s.nextLine();
			switch (key) {
			case 1:
				System.out.println("Enter first name: ");
				firstName=s.nextLine();
				System.out.println("Enter last name: ");
				lastName=s.nextLine();
				System.out.println("Enter emailId: ");
				emailId=s.nextLine();
				System.out.println("Enter department: ");
				department=s.nextLine();
				System.out.println("Enter designation: ");
				designation=s.nextLine();
				System.out.println("Enter pancard: ");
				pancard=s.nextLine();
				System.out.println("Enter investmentUnder80C: ");
				yearlyInvestmentUnder80C=s.nextInt();
				System.out.println("Enter basic Salary: ");
				basicSalary=s.nextInt();
				System.out.println("Enter account Number: ");
				accountNumber=s.nextInt();
				System.out.println("Enter bank name: ");
				s.nextLine();
				bankName=s.nextLine();
				System.out.println("Enter ifsc code: ");
				ifscCode=s.nextLine();
				associateID=bankingServices.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder80C, basicSalary, 0, 0, accountNumber, bankName, ifscCode);
				System.out.println("Associate ID: "+associateID);
				break;
			case 2:
				System.out.println("Enter Associate ID:");
				associateID=s.nextInt();
				bankingServices.calculateNetSalary(associateID);
				System.out.println(bankingServices.getAssociateDetails(associateID).toString());
				break;
			case 3:
				System.out.println("Enter Associate ID:");
				associateID=s.nextInt();
				System.out.println("Net Salary: "+bankingServices.calculateNetSalary(associateID));
				break;
			case 4:
				ArrayList<Associate> associates=bankingServices.getAllAssociatesDetails();
				for (Associate associate2 : associates) {
					System.out.println(associate2.toString());
				}
			}
		}while (key>0 && key <5);
	}
}