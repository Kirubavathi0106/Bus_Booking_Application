	package com.demo.Bus_booking_Application.Configuration;

    import com.demo.Bus_booking_Application.Entity.Passenger;
    import com.demo.Bus_booking_Application.Repository.PassengerRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;

    import java.util.ArrayList;
    import java.util.List;
	@Configuration
	@EnableWebSecurity
	public class secConfig {
		@Autowired
		PassengerRepo passRepo;
		@Bean
		public UserDetailsService userDetailsService(PasswordEncoder encoder) {
			List<Passenger> passengers = passRepo.findAll();
			List<UserDetails> allUsers = new ArrayList<>();
			for (Passenger p : passengers) {
				allUsers.add(User.withUsername(p.getEmail()).password(encoder.encode(p.getLogin_password())).roles("USER")
						.build());
			}
			return new InMemoryUserDetailsManager(allUsers);
		}
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			return http
					.csrf(csrf -> csrf.disable())
					.formLogin(formLogin -> formLogin
							.loginPage("/login")
							.defaultSuccessUrl("/", true)
							.permitAll()
					)
					.authorizeRequests(authorizeRequests -> authorizeRequests
							.anyRequest().authenticated()
					)
					.build();
		}
	}