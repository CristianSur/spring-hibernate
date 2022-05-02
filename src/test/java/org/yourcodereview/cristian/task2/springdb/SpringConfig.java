//package org.yourcodereview.cristian.task2.springdb;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import javax.sql.DataSource;
//
//import static org.yourcodereview.cristian.task2.springdb.config.SpringConfig.*;
//import static org.yourcodereview.cristian.task2.springdb.config.SpringConfig.databasePassword;
//
//public class SpringConfig {
//    public static DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(databaseURL);
//        dataSource.setUsername(databaseUsername);
//        dataSource.setPassword(databasePassword);
//
//        return dataSource;
//    }
//
//    public static JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource());
//    }
//
//}
