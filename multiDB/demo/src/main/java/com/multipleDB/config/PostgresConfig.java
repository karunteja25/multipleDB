package com.multipleDB.config;/*
 **@author karunteja
 **
 **/

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class PostgresConfig {
    @Value("${spring.data.postgres.uri}")
    private String postgresUri;
    @Value("${spring.data.postgres.username}")
    private String postgresUsername;
    @Value("${spring.data.postgres.password}")
    private String postgresPassword;
    @Value("${spring.data.postgres.driver}")
    private String postgresDriverClass;
//    @Value("${spring.data.postgres.dialect}")
//    private String postgresDialect;
//    @Autowired
//    private Environment env;

//    @PersistenceContext
//    private EntityManager entityManager;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(postgresUri);
        dataSource.setUsername(postgresUsername);
        dataSource.setPassword(postgresPassword);
        dataSource.setDriverClassName(postgresDriverClass);
//        dataSource.setSchema("public");
        return dataSource;
    }
    private HibernateJpaVendorAdapter vendorAdaptor() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean(name="entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan("com.multipleDB.postgres");
        Map<String,String> props=new HashMap<>();
//        props.put("hibernate.ddl-auto","update");
//        props.put("show-sql","true");
//        entityManagerFactoryBean.setJpaPropertyMap(props);
        entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

        return entityManagerFactoryBean;
    }

    private Properties jpaHibernateProperties() {

        Properties properties = new Properties();

        properties.put("true", "hibernate.show_sql");
        properties.put("update", "hibernate.ddl-auto");

        return properties;
    }
}
