/*    */ package com.atm.dao.impl;
/*    */ 
/*    */ import com.atm.dao.TransactionDAO;
/*    */ import com.atm.model.Transaction;
/*    */ import com.atm.util.DataSourceProvider;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransactionDAOImpl
/*    */   implements TransactionDAO
/*    */ {
/*    */   private static final String INSERT_TRANSACTION_QUERY = "INSERT INTO transactions(account_id, transaction_type, amount, target_account, transaction_date, description) VALUES(?,?,?,?,?,?)";
/*    */   private static final String MINI_STATEMENT_QUERY = "SELECT t.* FROM transactions t JOIN accounts a ON t.account_id = a.account_id WHERE a.account_number = ? ORDER BY t.transaction_date DESC";
/*    */   
/*    */   public boolean insertTransaction(Transaction transaction) {
/*    */     
/* 31 */     try { Connection con = DataSourceProvider.getDataSource().getConnection();
/*    */ 
/*    */       
/* 34 */       try { PreparedStatement ps = con.prepareStatement("INSERT INTO transactions(account_id, transaction_type, amount, target_account, transaction_date, description) VALUES(?,?,?,?,?,?)");
/*    */         
/* 36 */         try { ps.setInt(1, transaction.getAccountId().intValue());
/* 37 */           ps.setString(2, transaction.getTransactionType());
/* 38 */           ps.setDouble(3, transaction.getAmount().doubleValue());
/* 39 */           ps.setString(4, transaction.getTargetAccount());
/* 40 */           ps.setTimestamp(5, 
/* 41 */               Timestamp.valueOf(transaction.getTransactionDate()));
/* 42 */           ps.setString(6, transaction.getDescription());
/*    */           
/* 44 */           boolean bool = (ps.executeUpdate() > 0) ? true : false;
/*    */           
/* 46 */           if (ps != null) ps.close();  if (con != null) con.close();  return bool; } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Throwable throwable) { if (con != null) try { con.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 47 */     { e.printStackTrace();
/*    */ 
/*    */       
/* 50 */       return false; }
/*    */   
/*    */   }
/*    */ 
/*    */   
/*    */   public List<Transaction> getMiniStatement(String accountNumber) {
/* 56 */     List<Transaction> transactions = new ArrayList<>();
/*    */ 
/*    */     
/* 59 */     try { Connection conn = DataSourceProvider.getDataSource().getConnection();
/*    */ 
/*    */       
/* 62 */       try { PreparedStatement ps = conn.prepareStatement("SELECT t.* FROM transactions t JOIN accounts a ON t.account_id = a.account_id WHERE a.account_number = ? ORDER BY t.transaction_date DESC");
/*    */         
/* 64 */         try { ps.setString(1, accountNumber);
/*    */           
/* 66 */           ResultSet rs = ps.executeQuery();
/*    */           
/* 68 */           while (rs.next()) {
/*    */             
/* 70 */             Transaction tx = new Transaction();
/*    */             
/* 72 */             tx.setTransactionId(Integer.valueOf(rs.getInt("transaction_id")));
/* 73 */             tx.setAccountId(Integer.valueOf(rs.getInt("account_id")));
/* 74 */             tx.setTransactionType(rs.getString("transaction_type"));
/* 75 */             tx.setAmount(Double.valueOf(rs.getDouble("amount")));
/* 76 */             tx.setTargetAccount(rs.getString("target_account"));
/* 77 */             tx.setTransactionDate(rs
/* 78 */                 .getTimestamp("transaction_date")
/* 79 */                 .toLocalDateTime());
/* 80 */             tx.setDescription(rs.getString("description"));
/*    */             
/* 82 */             transactions.add(tx);
/*    */           } 
/*    */           
/* 85 */           if (ps != null) ps.close();  } catch (Throwable throwable) { if (ps != null) try { ps.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (conn != null) conn.close();  } catch (Throwable throwable) { if (conn != null) try { conn.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  } catch (Exception e)
/* 86 */     { e.printStackTrace(); }
/*    */ 
/*    */     
/* 89 */     return transactions;
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\dao\impl\TransactionDAOImpl.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */