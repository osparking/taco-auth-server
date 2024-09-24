package com.bumsoap.taco_auth_server.config;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.data.UserRepository;
import tacos.entity.TacoUser;

@Configuration
public class TestBeans {
    @Bean
    public ApplicationRunner dataLoader(
            UserRepository repo, PasswordEncoder encoder) {
        var user1 = new TacoUser("admin", encoder.encode("1234"), "ROLE_ADMIN");
        var user2 = new TacoUser("manager", encoder.encode("1234"), "ROLE_ADMIN");
        return args -> {
            repo.save(user1);
            repo.save(user2);
        };
    }
}
