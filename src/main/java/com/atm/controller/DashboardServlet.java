/*    */ package com.atm.controller;
/*    */ 
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebServlet({"/dashboard"})
/*    */ public class DashboardServlet
/*    */   extends HttpServlet {
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 17 */     HttpSession session = request.getSession(false);
/*    */     
/* 19 */     if (session == null) {
/*    */       
/* 21 */       response.sendRedirect("login.jsp");
/*    */       
/*    */       return;
/*    */     } 
/* 25 */     request.getRequestDispatcher("/views/dashboard.jsp")
/* 26 */       .forward((ServletRequest)request, (ServletResponse)response);
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\DashboardServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */