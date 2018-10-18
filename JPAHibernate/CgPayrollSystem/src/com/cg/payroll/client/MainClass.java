package com.cg.payroll.client;
import java.util.ArrayList;
import java.util.Scanner;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;
public class MainClass {
	public static void main(String[] args) throws PayrollServicesDownException, AssociateDetailsNotFoundException {
		Scanner s = new Scanner(System.in);
		String firstName,lastName,emailId,department,designation,pancard,bankName,ifscCode;
		int associateID,yearlyInvestmentUnder80C,basicSalary,accountNumber;
		int key;
		PayrollServices payrollServices = new PayrollServicesImpl();
		do{
			System.out.println("Welcome to Capgemini Payroll System");
			System.out.println("Enter your choice:");
			System.out.println("1. Enter Associate Details.");
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
				associateID=payrollServices.acceptAssociateDetails(firstName, lastName, emailId, department, designation, pancard, yearlyInvestmentUnder80C, basicSalary, 0, 0, accountNumber, bankName, ifscCode);
				System.out.println("Associate ID: "+associateID);
				break;
			case 2:
				System.out.println("Enter Associate ID:");
				associateID=s.nextInt();
				payrollServices.calculateNetSalary(associateID);
				Associate associate = payrollServices.getAssociateDetails(associateID);
				System.out.println(associate.toString());
				break;
			case 3:
				System.out.println("Enter Associate ID:");
				associateID=s.nextInt();
				System.out.println("Net Salary: "+payrollServices.calculateNetSalary(associateID));
				break;
			case 4:
				ArrayList<Associate> associates=payrollServices.getAllAssociatesDetails();
				for (Associate associate2 : associates) {
					System.out.println(associate2.toString());
				}
			}
		}while (key>0 && key <5);
	}
}