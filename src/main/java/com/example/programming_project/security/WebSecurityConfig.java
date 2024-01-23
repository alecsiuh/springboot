package com.example.programming_project.security;

import com.example.programming_project.domain.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .httpBasic()
                .and()
                .csrf()
                .ignoringAntMatchers("/api/albums")
                .and()
                .cors()
                .and()
                .authorizeHttpRequests(
                        auths ->
                                auths
                                        .regexMatchers("/(albums|addAlbum|artists|addArtist|songs|addSong)?")
                                        .permitAll()
                                        .regexMatchers(
                                                "/artists_csv")
                                        .hasRole(UserRole.ADMIN.name())
                                        .antMatchers(HttpMethod.GET, "/api/**")
                                        .permitAll()
                                        .antMatchers(HttpMethod.POST, "/api/**")
                                        .permitAll()
                                        .antMatchers(HttpMethod.GET, "/js/**", "/css/**", "/webjars/**", "/favicon.ico")
                                        .permitAll()
                                        .antMatchers("/", "/register")
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated())
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        // @formatter:on
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("http://localhost:9000");
            }
        };
    }
}
