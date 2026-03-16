/*    */ package com.atm.model;
/*    */ 
/*    */ import java.time.LocalDateTime;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Transaction
/*    */ {
/*    */   private Integer transactionId;
/*    */   private Integer accountId;
/*    */   private String transactionType;
/*    */   private Double amount;
/*    */   private String targetAccount;
/*    */   private LocalDateTime transactionDate;
/*    */   private String description;
/*    */   
/*    */   public Transaction() {}
/*    */   
/*    */   public Transaction(Integer transactionId, Integer accountId, String transactionType, Double amount, String targetAccount, LocalDateTime transactionDate, String description) {
/* 24 */     this.transactionId = transactionId;
/* 25 */     this.accountId = accountId;
/* 26 */     this.transactionType = transactionType;
/* 27 */     this.amount = amount;
/* 28 */     this.targetAccount = targetAccount;
/* 29 */     this.transactionDate = transactionDate;
/* 30 */     this.description = description;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getTransactionId() {
/* 35 */     return this.transactionId;
/*    */   }
/*    */   
/*    */   public void setTransactionId(Integer transactionId) {
/* 39 */     this.transactionId = transactionId;
/*    */   }
/*    */   
/*    */   public Integer getAccountId() {
/* 43 */     return this.accountId;
/*    */   }
/*    */   
/*    */   public void setAccountId(Integer accountId) {
/* 47 */     this.accountId = accountId;
/*    */   }
/*    */   
/*    */   public String getTransactionType() {
/* 51 */     return this.transactionType;
/*    */   }
/*    */   
/*    */   public void setTransactionType(String transactionType) {
/* 55 */     this.transactionType = transactionType;
/*    */   }
/*    */   
/*    */   public Double getAmount() {
/* 59 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Double amount) {
/* 63 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public String getTargetAccount() {
/* 67 */     return this.targetAccount;
/*    */   }
/*    */   
/*    */   public void setTargetAccount(String targetAccount) {
/* 71 */     this.targetAccount = targetAccount;
/*    */   }
/*    */   
/*    */   public LocalDateTime getTransactionDate() {
/* 75 */     return this.transactionDate;
/*    */   }
/*    */   
/*    */   public void setTransactionDate(LocalDateTime transactionDate) {
/* 79 */     this.transactionDate = transactionDate;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 83 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 87 */     this.description = description;
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\model\Transaction.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */