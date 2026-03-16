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
/*    */ @WebServlet({"/withdraw"})
/*    */ public class WithdrawServlet
/*    */   extends BaseServlet {
/* 14 */   private AccountService accountService = new AccountService();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*    */     double amount;
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
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 36 */       amount = Double.parseDouble(amountParam);
/*    */     }
/* 38 */     catch (Exception e) {
/*    */       
/* 40 */       response.sendRedirect(request
/* 41 */           .getContextPath() + "/views/withdraw.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (amount <= 0.0D) {
/*    */       
/* 47 */       response.sendRedirect(request
/* 48 */           .getContextPath() + "/views/withdraw.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 53 */     boolean success = this.accountService.withdraw(accountNumber, amount);
/*    */     
/* 55 */     if (success) {
/*    */       
/* 57 */       response.sendRedirect(request
/* 58 */           .getContextPath() + "/views/withdraw.jsp?status=success");
/*    */     }
/*    */     else {
/*    */       
/* 62 */       response.sendRedirect(request
/* 63 */           .getContextPath() + "/views/withdraw.jsp?status=fail");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\WithdrawServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */