/*    */ package com.atm.filter;
/*    */ 
/*    */ import jakarta.servlet.Filter;
/*    */ import jakarta.servlet.FilterChain;
/*    */ import jakarta.servlet.ServletException;
/*    */ import jakarta.servlet.ServletRequest;
/*    */ import jakarta.servlet.ServletResponse;
/*    */ import jakarta.servlet.annotation.WebFilter;
/*    */ import java.io.IOException;
/*    */ 
/*    */ 
/*    */ @WebFilter({"/*"})
/*    */ public class ExceptionHandlerFilter
/*    */   implements Filter
/*    */ {
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
/*    */     try {
/* 18 */       chain.doFilter(request, response);
/*    */     }
/* 20 */     catch (Exception e) {
/*    */       
/* 22 */       e.printStackTrace();
/*    */       
/* 24 */       request.setAttribute("errorMessage", "Something went wrong. Please try again.");
/*    */ 
/*    */       
/* 27 */       request.getRequestDispatcher("/views/error.jsp")
/* 28 */         .forward(request, response);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\filter\ExceptionHandlerFilter.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */