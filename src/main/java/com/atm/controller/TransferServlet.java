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
/*    */ @WebServlet({"/transfer"})
/*    */ public class TransferServlet
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
/* 28 */     String fromAccount = getAccountNumber(session);
/*    */     
/* 30 */     String targetAccount = request.getParameter("targetAccount");
/* 31 */     String amountParam = request.getParameter("amount");
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 36 */       amount = Double.parseDouble(amountParam);
/* 37 */     } catch (Exception e) {
/* 38 */       response.sendRedirect(request
/* 39 */           .getContextPath() + "/views/transfer.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/* 43 */     if (amount <= 0.0D) {
/* 44 */       response.sendRedirect(request
/* 45 */           .getContextPath() + "/views/transfer.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/* 49 */     if (targetAccount == null || targetAccount.trim().isEmpty()) {
/* 50 */       response.sendRedirect(request
/* 51 */           .getContextPath() + "/views/transfer.jsp?status=invalid");
/*    */       
/*    */       return;
/*    */     } 
/* 55 */     if (fromAccount.equals(targetAccount)) {
/* 56 */       response.sendRedirect(request
/* 57 */           .getContextPath() + "/views/transfer.jsp?status=same");
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 62 */     boolean success = this.accountService.transfer(fromAccount, targetAccount, amount);
/*    */     
/* 64 */     if (success) {
/*    */       
/* 66 */       response.sendRedirect(request
/* 67 */           .getContextPath() + "/views/transfer.jsp?status=success");
/*    */     }
/*    */     else {
/*    */       
/* 71 */       response.sendRedirect(request
/* 72 */           .getContextPath() + "/views/transfer.jsp?status=fail");
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\TransferServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */