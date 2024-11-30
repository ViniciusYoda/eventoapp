// package com.eventoapp;

// import java.sql.DataSource;



// @Configuration
// public class DataConfiguration {
    
//     @Bean
//     public DataSource dataSource(){
//         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//         dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//         dataSource.setUrl("jdbc:mysql://localhost:3300/eventoapp");
//         dataSource.setUsename("root");
//         dataSource.setPassword("Hayashi11@4");
//         return dataSource;
//     }

//     @Bean
//     public JpaVendorAdapter jpaVendorAdapter(){
//         HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//         adapter.setDatabase(Database.MYSQL);
//         adapter.setShowSql(true);
//         adapter.setFenerateDdl(true);
//         adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
//         adapter.setPrepareConnection(true);
//         return adapter;
//     }
// }
