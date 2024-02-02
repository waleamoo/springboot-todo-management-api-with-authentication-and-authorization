package com.techqwerty.todomanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import lombok.AllArgsConstructor;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private UserDetailsService userDetailsService;

    // Password encoder for account passwords 
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    // configure security filter chain 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // confifure Spring Security 
        httpSecurity.csrf().disable()
                    .authorizeHttpRequests((authorize) -> {
                        // authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN"); // ADMIN can make POST requests 
                        // authorize.requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN"); // ADMIN can make PUT requests 
                        // authorize.requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN"); // ADMIN can make DELETE requests 
                        // authorize.requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN, USER");  
                        // authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll(); // give public access to the GET APIs  
                        // authorize.requestMatchers(HttpMethod.PATCH, "/api/**").hasRole("ADMIN, USER");  
                        authorize.anyRequest().authenticated(); // authorize any request 
                    }).httpBasic(Customizer.withDefaults()); // provides a pop-up for login when user tries to access resource (in browser)
        return httpSecurity.build();
    }

    // authentication manager bean 
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }

    // In-memory authentication - with in memory user 
    // @Bean
    // public UserDetailsService userDetailsService(){
    //     UserDetails waleamoo = User.builder()
    //                                 .username("waleamoo")
    //                                 .password(passwordEncoder().encode("pa$$word"))
    //                                 .roles("USER")
    //                                 .build();
        
    //     UserDetails admin = User.builder()
    //                                 .username("admin")
    //                                 .password(passwordEncoder().encode("@dmi#"))
    //                                 .roles("ADMIN")
    //                                 .build();
    //     return new InMemoryUserDetailsManager(waleamoo, admin);
    // }
}
