package com.cg.payroll.services;
import java.sql.SQLException;
import java.util.ArrayList;
import org.jboss.logging.Logger;
import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
public class PayrollServicesImpl implements PayrollServices {
	private AssociateDAO associateDAO = new AssociateDAOImpl() ;
	private static final Logger logger = Logger.getLogger(PayrollServicesImpl.class);
	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String emailId, String department,
			String designation, String pancard, int yearlyInvestmentUnder80C, int basicSalary, int epf, int companyPf,
			int accountNumber, String bankName, String ifscCode) throws PayrollServicesDownException {
		Associate associate = new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails(accountNumber, bankName, ifscCode), new Salary(basicSalary, epf, companyPf)); 
		associate=associateDAO.save(associate);
		return associate.getAssociateID();
	}
	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate;
		associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		//tax calculation code
		int basicSalary=associate.getSalary().getBasicSalary();
		int hra=50*basicSalary/100;
		associate.getSalary().setHra(hra);
		int conveyenceAllowance=25*basicSalary/100;
		associate.getSalary().setConveyenceAllowance(conveyenceAllowance);
		int otherAllowance=25*basicSalary/100;
		associate.getSalary().setOtherAllowance(otherAllowance);
		int personalAllowance=40*basicSalary/100;
		associate.getSalary().setPersonalAllowance(personalAllowance);
		int epf=12*basicSalary/100;
		associate.getSalary().setEpf(epf);
		int companyPf = 12*basicSalary/100;
		associate.getSalary().setCompanyPf(companyPf);
		int gratuity=481*basicSalary/10000;
		associate.getSalary().setGratuity(gratuity);
		int grossSalary=basicSalary+conveyenceAllowance+otherAllowance+personalAllowance+epf;
		associate.getSalary().setGrossSalary(grossSalary);
		int yearlyInvestmentUnder80C = associate.getYearlyInvestmentUnder80C();
		if(yearlyInvestmentUnder80C+epf+companyPf>150000)
			yearlyInvestmentUnder80C=150000-epf-companyPf;
		associate.setYearlyInvestmentUnder80C(yearlyInvestmentUnder80C);
		int taxableIncome = 12*(grossSalary-epf)-yearlyInvestmentUnder80C;
		int yearlyTax=0;
		if(taxableIncome<=250000)
			yearlyTax=0;
		else if(taxableIncome>250000 && taxableIncome<=500000)
			yearlyTax=5*(taxableIncome-250000)/100;
		else if(taxableIncome>500000 && taxableIncome<=1000000)
			yearlyTax=12500+20*(taxableIncome-500000);
		else
			yearlyTax=112500+30*(taxableIncome-1000000);
		int monthlyTax=yearlyTax/12;
		associate.getSalary().setMonthlyTax(monthlyTax);
		int netSalary=grossSalary-epf-monthlyTax;
		associate.getSalary().setNetSalary(netSalary);
		associateDAO.update(associate);
		return netSalary;
	}
	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		Associate associate;
		associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details Not Found");
		return associate;
	}
	@Override
	public ArrayList<Associate> getAllAssociatesDetails() throws PayrollServicesDownException {
		return associateDAO.findAll();
	}
}
