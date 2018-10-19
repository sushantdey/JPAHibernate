package com.cg.project.daoservices;
import java.util.ArrayList;
import com.cg.project.beans.Associate;
public interface AssociateDAO {
	Associate save(Associate associate);
	public boolean update(Associate associate);
	Associate findOne(int associateId);
	ArrayList<Associate> findAll();
	ArrayList< Associate> findFewAssociate(int yearlyInvestmentUnder80C);
}