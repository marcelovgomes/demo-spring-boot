package demo.spring.boot;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;


// https://github.com/spring-projects/spring-boot/issues/11911

@Configuration
@Order(101)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private HttpFirewall allowUrlEncodedSlashHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowSemicolon(true);

		return firewall;
	}

	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		System.out.println(":: SecurityConfig ::");
		webSecurity.httpFirewall(allowUrlEncodedSlashHttpFirewall());
	}
}