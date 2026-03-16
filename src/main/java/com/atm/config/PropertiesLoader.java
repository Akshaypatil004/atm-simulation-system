/*    */ package com.atm.config;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.util.Properties;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class PropertiesLoader
/*    */ {
/* 14 */   private static Properties properties = new Properties();
/*    */   
/*    */   static {
/*    */     try {
/* 18 */       InputStream input = PropertiesLoader.class.getClassLoader().getResourceAsStream("application.properties");
/*    */       
/* 20 */       properties.load(input);
/*    */     }
/* 22 */     catch (Exception e) {
/* 23 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getDriver() {
/* 33 */     return properties.getProperty("db.driver");
/*    */   }
/*    */   
/*    */   public static String getUrl() {
/* 37 */     return properties.getProperty("db.url");
/*    */   }
/*    */   
/*    */   public static String getUsername() {
/* 41 */     return properties.getProperty("db.username");
/*    */   }
/*    */   
/*    */   public static String getPassword() {
/* 45 */     return properties.getProperty("db.password");
/*    */   }
/*    */   
/*    */   public static String getMaxPoolSize() {
/* 49 */     return properties.getProperty("db.pool.maxSize");
/*    */   }
/*    */   
/*    */   public static String getMinPoolSize() {
/* 53 */     return properties.getProperty("db.pool.minIdle");
/*    */   }
/*    */   
/*    */   public static String getConnectionTimeout() {
/* 57 */     return properties.getProperty("db.pool.timeout");
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\atm\config\PropertiesLoader.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */