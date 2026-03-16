/*    */ package com.atm.controller;
/*    */ import com.atm.model.Transaction;
/*    */ import com.atm.service.AccountService;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ 
/*    */ @WebServlet({"/statement"})
/*    */ public class MiniStatementServlet extends BaseServlet {
/* 16 */   private AccountService accountService = new AccountService();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 23 */     HttpSession session = request.getSession(false);
/*    */     
/* 25 */     if (session == null) {
/* 26 */       response.sendRedirect(request.getContextPath() + "/views/login.jsp");
/*    */       
/*    */       return;
/*    */     } 
/* 30 */     String accountNumber = getAccountNumber(session);
/*    */ 
/*    */     
/* 33 */     List<Transaction> transactions = this.accountService.miniStatement(accountNumber);
/*    */     
/* 35 */     request.setAttribute("transactions", transactions);
/*    */     
/* 37 */     request.getRequestDispatcher("/views/statement.jsp")
/* 38 */       .forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\MiniStatementServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */