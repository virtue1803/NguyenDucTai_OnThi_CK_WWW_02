package vn.edu.iuh.fit.onthick_2023_2024_01.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Tạo người dùng trong bộ nhớ
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("teo")
                .password(passwordEncoder().encode("teo"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Cấu hình các yêu cầu bảo mật
        http
                .authorizeHttpRequests(authRequests -> authRequests
                        .requestMatchers(HttpMethod.GET, "/api/dienthoai/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/dienthoai").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/dienthoai/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/dienthoai/**").hasRole("ADMIN")
                        .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                        // Các URL khác không yêu cầu xác thực
                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        // Cấu hình trang login
                        .defaultSuccessUrl("/dienthoai", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                // Tắt CSRF nếu cần cho API
                .csrf().disable();

        return http.build();
    }


}
