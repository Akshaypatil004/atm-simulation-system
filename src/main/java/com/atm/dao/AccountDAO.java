package com.atm.dao;

import com.atm.model.Account;
import java.util.Optional;

public interface AccountDAO {
  Optional<Account> findByAccountNumber(String paramString);
  
  boolean validateLogin(String paramString1, String paramString2);
  
  double getBalance(String paramString);
  
  boolean updateBalance(String paramString, double paramDouble);
}


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\dao\AccountDAO.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */