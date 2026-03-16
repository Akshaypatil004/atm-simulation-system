/*    */ package com.atm.controller;
/*    */ import com.atm.service.AccountService;

import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebServlet({"/login"})
/*    */ public class LoginServlet extends HttpServlet {
/* 14 */   private AccountService accountService = new AccountService();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 21 */     String accountNumber = request.getParameter("accountNumber");
/* 22 */     String pin = request.getParameter("pin");
/*    */     
/* 24 */     boolean valid = this.accountService.login(accountNumber, pin);
/*    */     
/* 26 */     if (valid) {
/*    */       
/* 28 */       HttpSession session = request.getSession();
/*    */       
/* 30 */       session.setAttribute("accountNumber", accountNumber);
/*    */       
/* 32 */       response.sendRedirect(request
/* 33 */           .getContextPath() + "/views/dashboard.jsp");
/*    */     
/*    */     }
/*    */     else {
/*    */       
/* 38 */       request.setAttribute("error", "Invalid account number or PIN");
/*    */       
/* 40 */       request.getRequestDispatcher("/views/login.jsp")
/* 41 */         .forward((ServletRequest)request, (ServletResponse)response);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\LoginServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */