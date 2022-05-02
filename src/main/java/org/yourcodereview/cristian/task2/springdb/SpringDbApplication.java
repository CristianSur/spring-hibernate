package org.yourcodereview.cristian.task2.springdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Controller;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDbApplication.class, args);
    }

}
