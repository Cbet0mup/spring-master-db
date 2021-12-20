package ru.database.springmasterdb.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers("/**").permitAll();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/*")
                .allowedOrigins("http://localhost:3000")
                //.allowedOrigins("xn--80aaabrq9ba6exc.xn--h1ahn.xn--p1acf")
                .allowedMethods("*");
    }
}
