package BastiKiPathshala.Backend.configs;

import BastiKiPathshala.Backend.service.UserDetailServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    private final UserDetailServiceImplementation userDetailServiceTimplementation;
    private final PasswordEncoderConfig passwordEncoder;

    public SpringSecurity(UserDetailServiceImplementation userDetailServiceTimplementation, PasswordEncoderConfig passwordEncoder) {
        this.userDetailServiceTimplementation = userDetailServiceTimplementation;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/Admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll()
                ).authenticationManager(authenticationManager())
                .csrf((csrf) -> csrf.disable())
                .httpBasic(Customizer.withDefaults());
                return http.build();
    }

    private AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailServiceTimplementation);
        authenticationProvider.setPasswordEncoder(passwordEncoder.passwordEncoder());

        ProviderManager providerManager = new ProviderManager(authenticationProvider);
        providerManager.setEraseCredentialsAfterAuthentication(false);

        return providerManager;
    }



}
