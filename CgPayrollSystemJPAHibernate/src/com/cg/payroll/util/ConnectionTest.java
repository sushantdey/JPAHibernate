package com.cg.payroll.util;
public class ConnectionTest {
	public static void main(String[] args) {
		if(ConnectionProvider.getDBConnection()!=null)
			System.out.println("Connection open");
		else
			System.out.println("Some Problem");
	}
}
