<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
<<<<<<< HEAD
<<<<<<< Updated upstream
>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32

>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00

package com.example.youtube.config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    CorsConfigurationSource corsConfigurationSource() {
        final var configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()).cors((cors) -> cors.configurationSource(corsConfigurationSource()));
                http.authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/channelOtherUser/**").permitAll()
                                .requestMatchers("/channelvideo").permitAll()
                                .requestMatchers("/api/videos/**").permitAll()
                                .requestMatchers("/create").permitAll()
                                .requestMatchers("/css/**","/js/**","/video/**","/images/**").permitAll()
                                .anyRequest().permitAll());
                        http.formLogin(

                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
<<<<<<< HEAD
=======

<<<<<<< HEAD
=======
=======

=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17

package com.example.youtube.config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    CorsConfigurationSource corsConfigurationSource() {
        final var configuration = new CorsConfiguration();
        configuration.addAllowedOriginPattern("*");
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setExposedHeaders(Arrays.asList("*"));
        final var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable()).cors((cors) -> cors.configurationSource(corsConfigurationSource()));
                http.authorizeHttpRequests((authorize) ->
                        authorize
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/channelOtherUser/**").permitAll()
                                .requestMatchers("/channelvideo").permitAll()
                                .requestMatchers("/api/videos/**").permitAll()
                                .requestMatchers("/create").permitAll()
                                .requestMatchers("/css/**","/js/**","/video/**","/images/**").permitAll()
                                .anyRequest().permitAll());
                        http.formLogin(

                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
<<<<<<< HEAD
=======

>>>>>>> a0ec43957822d9d53a48f41f02e2920eba66559e
>>>>>>> 32ccb657380ae0380a511aecf2a254c6615e7630
>>>>>>> bcde6724258af4f83afc4f6aa86aa253689cd780
>>>>>>> 4d72a10a6ea817d7aa0c72e78955ea98495048e1
>>>>>>> 1495cd4c212385b62bfa4865eb0d2d351ffc8e32
>>>>>>> 4377d3d2b63cb6f3b9a070424b3a4149c5d43b17
>>>>>>> 7190cba0e363ca23a9167210c16bff37f263ea00
