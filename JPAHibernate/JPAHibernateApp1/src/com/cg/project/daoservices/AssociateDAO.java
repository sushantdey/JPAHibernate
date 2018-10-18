package com.cg.project.daoservices;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cg.project.beans.Associate;
public interface AssociateDAO {
	Associate save(Associate associate);
	Associate findOne(int associateId);
	ArrayList<Associate> findAll();
	public boolean update(Associate associate);
}