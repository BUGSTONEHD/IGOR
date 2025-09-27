package com.example.IGORPROYECTO.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.IGORPROYECTO.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Encriptador de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Provider que conecta Spring Security con tu UserDetailsService
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // AuthenticationManager (lo usa el login)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Configuración HTTP con la nueva API (nada deprecated)
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth -> auth
                // públicas
                .requestMatchers("/", "/registro", "/guardar", "/css/**", "/js/**").permitAll()
                
                .requestMatchers("/administrador/**").hasRole("DIRECTOR")
                .requestMatchers("/cliente/").hasRole("CLIENTE") 
                .requestMatchers("/trabajador/**").hasRole("TRABAJADOR")
                .requestMatchers("/supervisor/**").hasRole("SUPERVISOR")

                .requestMatchers("/analisis/peticion/**").hasRole("CLIENTE")
                .requestMatchers("/analisis/solicitud/**").hasAnyRole("TRABAJADOR", "SUPERVISOR")
                .requestMatchers("/analisis/kpi/**").hasRole("DIRECTOR")
                .requestMatchers("/analisis/solicitudes/pendientes").hasRole("DIRECTOR")
                .requestMatchers("/analisis/**").authenticated()


                .requestMatchers("/proyectos/nuevo/").hasAnyRole("TRABAJADOR", "SUPERVISOR", "DIRECTOR")
                .requestMatchers("/Proyectos/**").authenticated()
                

                .requestMatchers("/recursos/recursoNuevo/").hasAnyRole("TRABAJADOR", "SUPERVISOR")
                .requestMatchers("/recursos/**").authenticated()

                .requestMatchers("/proyectos/**").authenticated()
                .requestMatchers("/recursos/**").authenticated()
                .anyRequest().authenticated()   
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/home", true)
                    .permitAll()
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            );

            http.authenticationProvider(authenticationProvider());

    return http.build();
}
}
