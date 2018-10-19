package com.cg.project.client;
import java.util.List;

import com.cg.project.beans.Associate;
import com.cg.project.beans.BankDetails;
import com.cg.project.beans.Salary;
import com.cg.project.daoservices.AssociateDAO;
import com.cg.project.daoservices.AssociateDAOImpl;
public class MainClass {
	public static void main(String[] args) {
		AssociateDAO associateDAO = new AssociateDAOImpl();
		Associate associate = new Associate(20000, "Sushant", "Dey", "ytp", "Sr. Analyst", "ACSFD6789J", "sushant@gmail.com", new BankDetails(12345, "ICICI", "ICIC0000985"), new Salary(17300, 2076, 2076));
		associate = associateDAO.save(associate);
		System.out.println(associate.toString());
		/*associate = new Associate("Sushant", "Dey", "sushant@gmail.com", "Sr. analyst");
		associate = associateDAO.save(associate);*/
		List<Associate> associates = associateDAO.findAll();
		System.out.println(associates.toString());
		associates = associateDAO.findFewAssociate(20000);
	}
}
