/*    */ package com.atm.controller;
/*    */ import com.atm.service.AccountService;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebServlet({"/balance"})
/*    */ public class BalanceServlet extends BaseServlet {
/* 14 */   private AccountService accountService = new AccountService();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 21 */     HttpSession session = request.getSession(false);
/*    */     
/* 23 */     if (session == null) {
/* 24 */       response.sendRedirect("login.jsp");
/*    */       
/*    */       return;
/*    */     } 
/* 28 */     String accountNumber = getAccountNumber(session);
/*    */ 
/*    */     
/* 31 */     double balance = this.accountService.checkBalance(accountNumber);
/*    */     
/* 33 */     request.setAttribute("balance", Double.valueOf(balance));
/*    */     
/* 35 */     request.getRequestDispatcher("/views/balance.jsp")
/* 36 */       .forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\BalanceServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */