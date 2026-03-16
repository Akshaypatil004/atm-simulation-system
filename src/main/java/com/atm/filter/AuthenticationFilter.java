/*    */ package com.atm.filter;
/*    */ 
/*    */ import jakarta.servlet.Filter;
/*    */ import jakarta.servlet.FilterChain;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebFilter;
/*    */ import jakarta.servlet.http.HttpServletRequest;
/*    */ import jakarta.servlet.http.HttpServletResponse;
/*    */ import jakarta.servlet.http.HttpSession;
/*    */ import java.io.IOException;
/*    */ 
/*    */ @WebFilter({"/views/*"})
/*    */ public class AuthenticationFilter
/*    */   implements Filter {
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/* 18 */     HttpServletRequest req = (HttpServletRequest)request;
/* 19 */     HttpServletResponse res = (HttpServletResponse)response;
/*    */     
/* 21 */     String uri = req.getRequestURI();
/*    */ 
/*    */     
/* 24 */     if (uri.contains("login.jsp")) {
/* 25 */       chain.doFilter(request, response);
/*    */       
/*    */       return;
/*    */     } 
/* 29 */     HttpSession session = req.getSession(false);
/*    */     
/* 31 */     if (session == null || session.getAttribute("accountNumber") == null) {
/* 32 */       res.sendRedirect(req.getContextPath() + "/views/login.jsp");
/*    */       
/*    */       return;
/*    */     } 
/* 36 */     chain.doFilter(request, response);
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\filter\AuthenticationFilter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */