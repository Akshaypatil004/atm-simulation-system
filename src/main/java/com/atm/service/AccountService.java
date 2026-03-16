/*     */ package com.atm.service;
/*     */ 
/*     */ import com.atm.dao.AccountDAO;
/*     */ import com.atm.dao.TransactionDAO;
/*     */ import com.atm.dao.impl.AccountDAOImpl;
/*     */ import com.atm.dao.impl.TransactionDAOImpl;
/*     */ import com.atm.model.Account;
/*     */ import com.atm.model.Transaction;
/*     */ import java.time.LocalDateTime;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AccountService
/*     */ {
/*  17 */   private AccountDAO accountDAO = (AccountDAO)new AccountDAOImpl();
/*  18 */   private TransactionDAO transactionDAO = (TransactionDAO)new TransactionDAOImpl();
/*     */   
/*     */   public boolean login(String accountNumber, String pin) {
/*  21 */     return this.accountDAO.validateLogin(accountNumber, pin);
/*     */   }
/*     */   
/*     */   public double checkBalance(String accountNumber) {
/*  25 */     return this.accountDAO.getBalance(accountNumber);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean deposit(String accountNumber, double amount) {
/*  30 */     double balance = this.accountDAO.getBalance(accountNumber);
/*     */     
/*  32 */     double newBalance = balance + amount;
/*     */     
/*  34 */     boolean updated = this.accountDAO.updateBalance(accountNumber, newBalance);
/*     */     
/*  36 */     if (updated) {
/*     */ 
/*     */       
/*  39 */       Optional<Account> accountOpt = this.accountDAO.findByAccountNumber(accountNumber);
/*     */       
/*  41 */       accountOpt.ifPresent(account -> {
/*     */             Transaction tx = new Transaction();
/*     */             
/*     */             tx.setAccountId(account.getAccountId());
/*     */             
/*     */             tx.setTransactionType("DEPOSIT");
/*     */             
/*     */             tx.setAmount(Double.valueOf(amount));
/*     */             
/*     */             tx.setTransactionDate(LocalDateTime.now());
/*     */             tx.setDescription("Cash Deposit");
/*     */             this.transactionDAO.insertTransaction(tx);
/*     */           });
/*     */     } 
/*  55 */     return updated;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean withdraw(String accountNumber, double amount) {
/*  60 */     double balance = this.accountDAO.getBalance(accountNumber);
/*     */     
/*  62 */     if (balance < amount) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     double newBalance = balance - amount;
/*     */     
/*  68 */     boolean updated = this.accountDAO.updateBalance(accountNumber, newBalance);
/*     */     
/*  70 */     if (updated) {
/*     */ 
/*     */       
/*  73 */       Optional<Account> accountOpt = this.accountDAO.findByAccountNumber(accountNumber);
/*     */       
/*  75 */       accountOpt.ifPresent(account -> {
/*     */             Transaction tx = new Transaction();
/*     */             
/*     */             tx.setAccountId(account.getAccountId());
/*     */             
/*     */             tx.setTransactionType("WITHDRAW");
/*     */             
/*     */             tx.setAmount(Double.valueOf(amount));
/*     */             
/*     */             tx.setTransactionDate(LocalDateTime.now());
/*     */             tx.setDescription("Cash Withdrawal");
/*     */             this.transactionDAO.insertTransaction(tx);
/*     */           });
/*     */     } 
/*  89 */     return updated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean transfer(String fromAccount, String toAccount, double amount) {
/*  96 */     double balance = this.accountDAO.getBalance(fromAccount);
/*     */     
/*  98 */     if (balance < amount) {
/*  99 */       return false;
/*     */     }
/*     */     
/* 102 */     double newBalanceSender = balance - amount;
/*     */ 
/*     */     
/* 105 */     boolean debit = this.accountDAO.updateBalance(fromAccount, newBalanceSender);
/*     */     
/* 107 */     if (!debit) {
/* 108 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 112 */     double receiverBalance = this.accountDAO.getBalance(toAccount);
/*     */     
/* 114 */     double newBalanceReceiver = receiverBalance + amount;
/*     */ 
/*     */ 
/*     */     
/* 118 */     boolean credit = this.accountDAO.updateBalance(toAccount, newBalanceReceiver);
/*     */     
/* 120 */     if (credit) {
/*     */ 
/*     */       
/* 123 */       Optional<Account> accountOpt = this.accountDAO.findByAccountNumber(fromAccount);
/*     */       
/* 125 */       accountOpt.ifPresent(account -> {
/*     */             Transaction tx = new Transaction();
/*     */             
/*     */             tx.setAccountId(account.getAccountId());
/*     */             
/*     */             tx.setTransactionType("TRANSFER");
/*     */             
/*     */             tx.setAmount(Double.valueOf(amount));
/*     */             
/*     */             tx.setTargetAccount(toAccount);
/*     */             tx.setTransactionDate(LocalDateTime.now());
/*     */             tx.setDescription("Transfer to " + toAccount);
/*     */             this.transactionDAO.insertTransaction(tx);
/*     */           });
/*     */     } 
/* 140 */     return credit;
/*     */   }
/*     */   
/*     */   public List<Transaction> miniStatement(String accountNumber) {
/* 144 */     return this.transactionDAO.getMiniStatement(accountNumber);
/*     */   }
/*     */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\service\AccountService.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */