/*    */ package com.atm.controller;
/*    */ 
/*    */ import jakarta.servlet.http.HttpServlet;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ 
/*    */ public abstract class BaseServlet
/*    */   extends HttpServlet
/*    */ {
/*    */   protected String getAccountNumber(HttpSession session) {
/* 10 */     return (String)session.getAttribute("accountNumber");
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\controller\BaseServlet.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */