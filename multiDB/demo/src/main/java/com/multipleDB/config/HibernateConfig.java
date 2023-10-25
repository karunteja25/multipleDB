//package com.multipleDB.config;/*
// **@author karunteja
// **
// **/
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//public class HibernateConfig {
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        sessionFactory.setPackagesToScan("com.multipleDB.postgres");
//
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("spring.jpa.properties.hibernate.dialect"));
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//        hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
//        hibernateProperties.setProperty("hibernate.format_sql", "true");
//
//        sessionFactory.setHibernateProperties(hibernateProperties);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public HibernateTransactionManager transactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }
//}
