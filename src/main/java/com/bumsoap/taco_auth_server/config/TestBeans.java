package com.bumsoap.taco_auth_server.config;

import com.bumsoap.taco_auth_server.data.UserRepository;
import com.bumsoap.taco_auth_server.entity.TacoUser;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
