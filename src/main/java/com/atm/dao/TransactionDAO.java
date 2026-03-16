package com.atm.dao;

import com.atm.model.Transaction;
import java.util.List;

public interface TransactionDAO {
  boolean insertTransaction(Transaction paramTransaction);
  
  List<Transaction> getMiniStatement(String paramString);
}


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\dao\TransactionDAO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */