/*    */ package com.atm.controller;
/*    */ 
/*    */ import com.atm.service.AccountService;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebServlet({"/deposit"})
/*    */ public class DepositServlet
/*    */   extends BaseServlet {
/* 14 */   private AccountService accountService = new AccountService();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 21 */     HttpSession session = request.getSession(false);
/*    */     
/* 23 */     if (session == null) {
/* 24 */       response.sendRedirect(request.getContextPath() + "/views/login.jsp");
/*    */       
/*    */       return;
/*    */     } 
/* 28 */     String accountNumber = getAccountNumber(session);
/*    */     
/* 30 */     String amountParam = request.getParameter("amount");
/*    */     
/* 32 */     double amount = 0.0D;
/*    */ 
/*    */     
/*    */     try {
/* 36 */       amount = Double.parseDouble(amountParam);
/*    */     }
/* 38 */     catch (Exception e) {
/*    */       
/* 40 */       response.sendRedirect(request
/* 41 */           .getContextPath() + "/views/deposit.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 46 */     if (amount <= 0.0D) {
/*    */       
/* 48 */       response.sendRedirect(request
/* 49 */           .getContextPath() + "/views/deposit.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 54 */     boolean success = this.accountService.deposit(accountNumber, amount);
/*    */     
/* 56 */     if (success) {
/*    */       
/* 58 */       response.sendRedirect(request
/* 59 */           .getContextPath() + "/views/deposit.jsp?status=success");
/*    */     }
/*    */     else {
/*    */       
/* 63 */       response.sendRedirect(request
/* 64 */           .getContextPath() + "/views/deposit.jsp?status=fail");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\DepositServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */