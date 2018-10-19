package com.cg.payroll.daoservices;
import java.util.ArrayList;
import com.cg.payroll.beans.Associate;
public interface AssociateDAO {
	Associate save(Associate associate);
	public boolean update(Associate associate);
	Associate findOne(int associateId);
	ArrayList<Associate> findAll();
}