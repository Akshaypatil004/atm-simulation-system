/*    */ package com.atm.config;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class DatabaseConfig
/*    */ {
/*    */   static {
/*    */     try {
/* 14 */       String driver = PropertiesLoader.getDriver();
/*    */       
/* 16 */       Class.forName(driver);
/*    */       
/* 18 */       System.out.println("Database Driver Loaded succesfully");
/*    */     }
/* 20 */     catch (Exception e) {
/* 21 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\config\DatabaseConfig.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */