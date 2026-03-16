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
/*    */ public class Account
/*    */ {
/*    */   private Integer accountId;
/*    */   private String accountNumber;
/*    */   private String name;
/*    */   private String pin;
/*    */   private Double balance;
/*    */   private LocalDateTime createdAt;
/*    */   
/*    */   public Account() {}
/*    */   
/*    */   public Account(Integer accountId, String accountNumber, String name, String pin, Double balance, LocalDateTime createdAt) {
/* 23 */     this.accountId = accountId;
/* 24 */     this.accountNumber = accountNumber;
/* 25 */     this.name = name;
/* 26 */     this.pin = pin;
/* 27 */     this.balance = balance;
/* 28 */     this.createdAt = createdAt;
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer getAccountId() {
/* 33 */     return this.accountId;
/*    */   }
/*    */   
/*    */   public void setAccountId(Integer accountId) {
/* 37 */     this.accountId = accountId;
/*    */   }
/*    */   
/*    */   public String getAccountNumber() {
/* 41 */     return this.accountNumber;
/*    */   }
/*    */   
/*    */   public void setAccountNumber(String accountNumber) {
/* 45 */     this.accountNumber = accountNumber;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 49 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 53 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getPin() {
/* 57 */     return this.pin;
/*    */   }
/*    */   
/*    */   public void setPin(String pin) {
/* 61 */     this.pin = pin;
/*    */   }
/*    */   
/*    */   public Double getBalance() {
/* 65 */     return this.balance;
/*    */   }
/*    */   
/*    */   public void setBalance(Double balance) {
/* 69 */     this.balance = balance;
/*    */   }
/*    */   
/*    */   public LocalDateTime getCreatedAt() {
/* 73 */     return this.createdAt;
/*    */   }
/*    */   
/*    */   public void setCreatedAt(LocalDateTime createdAt) {
/* 77 */     this.createdAt = createdAt;
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\model\Account.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */