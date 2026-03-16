/*    */ package com.atm.util;
/*    */ 
/*    */ import com.atm.config.PropertiesLoader;
/*    */ import com.zaxxer.hikari.HikariConfig;
/*    */ import com.zaxxer.hikari.HikariDataSource;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DataSourceProvider
/*    */ {
/*    */   private static HikariDataSource datasource;
/*    */   
/*    */   static {
/* 17 */     HikariConfig config = new HikariConfig();
/*    */     
/* 19 */     config.setDriverClassName(PropertiesLoader.getDriver());
/* 20 */     config.setJdbcUrl(PropertiesLoader.getUrl());
/* 21 */     config.setUsername(PropertiesLoader.getUsername());
/* 22 */     config.setPassword(PropertiesLoader.getPassword());
/* 23 */     config.setMaximumPoolSize(Integer.parseInt(PropertiesLoader.getMaxPoolSize()));
/* 24 */     config.setMinimumIdle(Integer.parseInt(PropertiesLoader.getMinPoolSize()));
/* 25 */     config.setConnectionTimeout(Long.parseLong(PropertiesLoader.getConnectionTimeout()));
/*    */     
/* 27 */     datasource = new HikariDataSource(config);
/*    */   }
/*    */ 
/*    */   
/*    */   public static DataSource getDataSource() {
/* 32 */     return (DataSource)datasource;
/*    */   }
/*    */ }


/* Location:              C:\Tomcat 10.1\webapps\atm-simulation-system\WEB-INF\classes\!\com\at\\util\DataSourceProvider.class
 * Java compiler version: 11 (55.0)
 * JD-Core Version:       1.1.3
 */