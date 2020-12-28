package rishi.springFramework.mmscbrewary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MmscBrewaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmscBrewaryApplication.class, args);
	}

}
