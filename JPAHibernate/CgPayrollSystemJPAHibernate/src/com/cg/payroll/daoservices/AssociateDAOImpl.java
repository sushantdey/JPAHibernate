package com.cg.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.util.ConnectionProvider;
public class AssociateDAOImpl implements AssociateDAO {
	private Connection conn = ConnectionProvider.getDBConnection();
	@Override
	public Associate save(Associate associate) throws SQLException {
		try{
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("insert into Associate(yearlyInvestmentUnder80C,firstName,lastName,department,designation,pancard,emailId) values (?,?,?,?,?,?,?)");
			pstmt1.setInt(1, associate.getYearlyInvestmentUnder80C());
			pstmt1.setString(2, associate.getFirstName());
			pstmt1.setString(3, associate.getLastName());
			pstmt1.setString(4, associate.getDepartment());
			pstmt1.setString(5, associate.getDesignation());
			pstmt1.setString(6, associate.getPancard());
			pstmt1.setString(7, associate.getEmailId());
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = conn.prepareStatement("select max(associateId) from Associate");
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			int associateId = rs.getInt(1);
			
			PreparedStatement pstmt3 = conn.prepareStatement("insert into BankDetails values (?,?,?,?)");
			pstmt3.setInt(4, associateId);
			pstmt3.setInt(1, associate.getBankDetails().getAccountNumber());
			pstmt3.setString(2, associate.getBankDetails().getBankName());
			pstmt3.setString(3, associate.getBankDetails().getIfscCode());
			pstmt3.executeUpdate();
			
			PreparedStatement pstmt4 = conn.prepareStatement("insert into Salary (associateId,basicSalary) values (?,?)");
			pstmt4.setInt(1, associateId);
			pstmt4.setInt(2, associate.getSalary().getBasicSalary());
			pstmt4.executeUpdate();
			conn.commit();
			associate.setAssociateID(associateId);
			return associate;
		}catch (SQLException e){
			/*e.printStackTrace();*/
			conn.rollback();
			throw e;
		}
		finally{
			conn.setAutoCommit(true);
		}
	}
	@Override
	public Associate findOne(int associateId) throws SQLException {
		PreparedStatement pstmt1 = conn.prepareStatement("Select * from Associate where associateId="+associateId);
		ResultSet associateRS = pstmt1.executeQuery();
		if(associateRS.next()) {
			
			String firstName=associateRS.getString("firstName");
			String lastName=associateRS.getString("lastName");
			String department=associateRS.getString("department");
			String designation=associateRS.getString("designation");
			String pancard=associateRS.getString("pancard");
			String emailId=associateRS.getString("emailId");
			int yearlyInvestmentUnder80C=associateRS.getInt("yearlyInvestmentUnder80C");
			Associate associate = new Associate(associateId, yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, null, null);
			
			PreparedStatement pstmt2 = conn.prepareStatement("Select * from BankDetails where associateId="+associateId);
			ResultSet bankdetailsRs=pstmt2.executeQuery();
			bankdetailsRs.next();
			
			int accountNumber=bankdetailsRs.getInt("accountNumber");
			String bankName=bankdetailsRs.getString("bankName");
			String ifscCode=bankdetailsRs.getString("ifscCode");
			associate.setBankDetails(new BankDetails(accountNumber, bankName, ifscCode));
			
			PreparedStatement pstmt3 = conn.prepareStatement("select * from Salary where associateId="+associateId);
			
			
			ResultSet salaryRS =pstmt3.executeQuery();
			salaryRS.next();
			associate.setSalary(new Salary(salaryRS.getInt("basicSalary"), salaryRS.getInt("hra"), salaryRS.getInt("conveyenceAllowance"), salaryRS.getInt("otherAllowance"), salaryRS.getInt("personalAllowance"), salaryRS.getInt("monthlyTax"), salaryRS.getInt("epf"), salaryRS.getInt("companyPf"),salaryRS.getInt("gratuity"), salaryRS.getInt("grossSalary"), salaryRS.getInt("netSalary")));
			
			return associate;
		}	
		return null;
	}
	@Override
	public ArrayList<Associate> findAll() throws SQLException  {
		ArrayList<Associate> associates = new ArrayList<Associate>();
		PreparedStatement pstmt1 = conn.prepareStatement("Select * from Associate");
		ResultSet associateRS = pstmt1.executeQuery();
	
		while(associateRS.next()) {
			
			int associateId = associateRS.getInt("associateId");
			String firstName=associateRS.getString("firstName");
			String lastName=associateRS.getString("lastName");
			String department=associateRS.getString("department");
			String designation=associateRS.getString("designation");
			String pancard=associateRS.getString("pancard");
			String emailId=associateRS.getString("emailId");
			int yearlyInvestmentUnder80C=associateRS.getInt("yearlyInvestmentUnder80C");
			Associate associate = new Associate(associateId, yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, null, null);
			
			PreparedStatement pstmt2 = conn.prepareStatement("Select * from BankDetails where associateId="+associateId);
			ResultSet bankdetailsRs=pstmt2.executeQuery();
			bankdetailsRs.next();
			int accountNumber=bankdetailsRs.getInt("accountNumber");
			String bankName=bankdetailsRs.getString("bankName");
			String ifscCode=bankdetailsRs.getString("ifscCode");
			associate.setBankDetails(new BankDetails(accountNumber, bankName, ifscCode));
			
			PreparedStatement pstmt3 = conn.prepareStatement("select * from Salary where associateId="+associateId);
			ResultSet salaryRS =pstmt3.executeQuery();
			salaryRS.next();
			int basicSalary= salaryRS.getInt("basicSalary");
			int hra = salaryRS.getInt("hra");
			int conveyenceAllowance = salaryRS.getInt("conveyenceAllowance");
			int otherAllowance = salaryRS.getInt("otherAllowance");
			int personalAllowance= salaryRS.getInt("personalAllowance");
			int monthlyTax= salaryRS.getInt("monthlyTax");
			int epf = salaryRS.getInt("epf");
			int companyPf=salaryRS.getInt("companyPf");
			int gratuity= salaryRS.getInt("gratuity");
			int grossSalary= salaryRS.getInt("grossSalary");
			int netSalary= salaryRS.getInt("netSalary");
			associate.setSalary(new Salary(basicSalary,hra ,conveyenceAllowance ,otherAllowance ,personalAllowance ,monthlyTax ,epf ,companyPf ,gratuity , grossSalary, netSalary));
			associates.add(associate);
			System.out.println(associate.toString());
		}
		return associates;
	}
	@Override
	public boolean update(Associate associate) throws SQLException {
		try{
			conn.setAutoCommit(false);
			PreparedStatement pstmt1 = conn.prepareStatement("update salary set hra=?, conveyenceAllowance=?, otherAllowance=?, personalAllowance=?, monthlyTax=?, epf=?, companyPf=?, gratuity=?, grossSalary=?, netSalary=? where associateId=?");
			pstmt1.setInt(1, associate.getSalary().getHra());
			pstmt1.setInt(2, associate.getSalary().getConveyenceAllowance());
			pstmt1.setInt(3, associate.getSalary().getOtherAllowance());
			pstmt1.setInt(4, associate.getSalary().getPersonalAllowance());
			pstmt1.setInt(5, associate.getSalary().getMonthlyTax());
			pstmt1.setInt(6, associate.getSalary().getEpf());
			pstmt1.setInt(7, associate.getSalary().getCompanyPf());
			pstmt1.setInt(8, associate.getSalary().getGratuity());
			pstmt1.setInt(9, associate.getSalary().getGrossSalary());
			pstmt1.setInt(10, associate.getSalary().getNetSalary());
			pstmt1.setInt(11, associate.getAssociateID());
			pstmt1.executeUpdate();
			conn.commit();
		}catch (SQLException e){
			/*e.printStackTrace();*/
			conn.rollback();
			throw e;
		}
		finally{
			conn.setAutoCommit(true);
		}
		return false;
	}
	
}
