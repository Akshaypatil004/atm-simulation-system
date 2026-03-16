/*     */ package com.atm.dao.impl;
/*     */ 
/*     */ import com.atm.dao.AccountDAO;
/*     */ import com.atm.model.Account;
/*     */ import com.atm.util.DataSourceProvider;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.Optional;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccountDAOImpl
/*     */   implements AccountDAO
/*     */ {
/*     */   private static final String FIND_BY_ACCOUNT_NUMBER_QUERY = " SELECT * FROM accounts WHERE account_number = ?";
/*     */   private static final String VALIDATE_LOGIN_QUERY = "SELECT COUNT(*) FROM accounts WHERE account_number = ? AND pin = ?";
/*     */   private static final String BALANCE_QUERY = "SELECT balance FROM accounts WHERE account_number = ?";
/*     */   private static final String UPDATE_BALANCE_QUERY = "UPDATE accounts SET balance = ? WHERE account_number = ?";
/*     */   
/*     */   public Optional<Account> findByAccountNumber(String accountNumber) {
/*     */     
/*  28 */     try { Connection con = DataSourceProvider.getDataSource().getConnection(); 
/*  29 */       try { PreparedStatement ps = con.prepareStatement(" SELECT * FROM accounts WHERE account_number = ?");
/*     */         
/*  31 */         try { ps.setString(1, accountNumber);
/*     */           
/*  33 */           ResultSet rs = ps.executeQuery();
/*     */           
/*  35 */           if (rs.next())
/*     */           
/*  37 */           { Account account = new Account();
/*     */             
/*  39 */             account.setAccountId(Integer.valueOf(rs.getInt("account_id")));
/*  40 */             account.setAccountNumber(rs.getString("account_number"));
/*     */             
/*  42 */             account.setName(rs.getString("name"));
/*     */             
/*  44 */             account.setPin(rs.getString("pin"));
/*     */             
/*  46 */             account.setBalance(Double.valueOf(rs.getDouble("balance")));
/*  47 */             Optional<Account> optional = Optional.of(account);
/*     */ 
/*     */ 
/*     */             
/*  51 */             if (ps != null) ps.close();  if (con != null) con.close();  return optional; }  if (ps != null) ps.close();  } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (con != null) con.close();  } catch (Throwable throwable) { if (con != null) try { con.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  52 */     { e.printStackTrace(); }
/*     */     
/*  54 */     return Optional.empty();
/*     */   }
/*     */   
/*     */   public boolean validateLogin(String accountNumber, String pin) {
/*     */     
/*  59 */     try { Connection con = DataSourceProvider.getDataSource().getConnection(); 
/*  60 */       try { PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM accounts WHERE account_number = ? AND pin = ?");
/*     */         
/*  62 */         try { ps.setString(1, accountNumber);
/*  63 */           ps.setString(2, pin);
/*     */           
/*  65 */           ResultSet rs = ps.executeQuery();
/*     */           
/*  67 */           if (rs.next())
/*  68 */           { boolean bool = (rs.getInt(1) > 0) ? true : false;
/*     */             
/*  70 */             if (ps != null) ps.close();  if (con != null) con.close();  return bool; }  if (ps != null) ps.close();  } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (con != null) con.close();  } catch (Throwable throwable) { if (con != null)
/*  71 */           try { con.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  72 */     { e.printStackTrace(); }
/*     */     
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public double getBalance(String accoutNumber) {
/*     */     
/*  79 */     try { Connection con = DataSourceProvider.getDataSource().getConnection(); 
/*  80 */       try { PreparedStatement ps = con.prepareStatement("SELECT balance FROM accounts WHERE account_number = ?");
/*     */         
/*  82 */         try { ps.setString(1, accoutNumber);
/*     */           
/*  84 */           ResultSet rs = ps.executeQuery();
/*     */           
/*  86 */           if (rs.next())
/*  87 */           { double d = rs.getDouble("balance");
/*     */ 
/*     */             
/*  90 */             if (ps != null) ps.close();  if (con != null) con.close();  return d; }  if (ps != null) ps.close();  } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (con != null) con.close();  } catch (Throwable throwable) { if (con != null)
/*  91 */           try { con.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/*  92 */     { e.printStackTrace(); }
/*     */     
/*  94 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public boolean updateBalance(String accountNumber, double newBalance) {
/*     */     
/*  99 */     try { Connection con = DataSourceProvider.getDataSource().getConnection(); 
/* 100 */       try { PreparedStatement ps = con.prepareStatement("UPDATE accounts SET balance = ? WHERE account_number = ?");
/*     */         
/* 102 */         try { ps.setDouble(1, newBalance);
/* 103 */           ps.setString(2, accountNumber);
/*     */           
/* 105 */           boolean bool = (ps.executeUpdate() > 0) ? true : false;
/* 106 */           if (ps != null) ps.close();  if (con != null) con.close();  return bool; } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Throwable throwable) { if (con != null)
/* 107 */           try { con.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 108 */     { e.printStackTrace();
/*     */       
/* 110 */       return false; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\dao\impl\AccountDAOImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */