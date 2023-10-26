package ru.sobse.hibernate_dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin").
                roles("ADMIN", "USER")
                .build();
        UserDetails userSergey = User.withDefaultPasswordEncoder()
                .username("sergey")
                .password("sergey")
                .roles("READ")
                .build();
        UserDetails userIvan = User.withDefaultPasswordEncoder()
                .username("ivan")
                .password("ivan").
                roles("WRITE")
                .build();
        UserDetails userMichail = User.withDefaultPasswordEncoder()
                .username("michail")
                .password("michail")
                .roles("DELETE")
                .build();
        return new InMemoryUserDetailsManager(user, admin, userSergey, userMichail, userIvan);
    }

}
