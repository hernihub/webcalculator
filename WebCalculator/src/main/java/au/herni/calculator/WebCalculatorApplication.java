package au.herni.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Principal application class for embbeded Tomcat startup
 * @author Hernán Camilo
 *
 */
@SpringBootApplication
@EnableCaching
public class WebCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCalculatorApplication.class, args);
	}
}
