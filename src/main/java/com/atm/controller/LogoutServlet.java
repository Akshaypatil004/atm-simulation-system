/*    */ package com.atm.controller;
/*    */ 
/*    */ import jakarta.servlet.annotation.WebServlet;
/*    */ import jakarta.servlet.http.HttpServlet;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebServlet({"/logout"})
/*    */ public class LogoutServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
/* 15 */     HttpSession session = request.getSession(false);
/*    */     
/* 17 */     if (session != null) {
/* 18 */       session.invalidate();
/*    */     }
/*    */     
/* 21 */     response.sendRedirect(request.getContextPath() + "/views/login.jsp");
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\LogoutServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */