package com.example.springbooth2;

import com.example.springbooth2.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Parameter;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootH2Application {

	@RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
	public User users(@PathVariable Long id) {
        Session session = buildSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.close();

        return user;
	}

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            return configuration
                    .buildSessionFactory(new StandardServiceRegistryBuilder()
                            .build());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("There was an error building the factory");
        }
    }

    public static void main(String[] args) {
		SpringApplication.run(SpringBootH2Application.class, args);
	}
}
