package si.ferbisek.snackbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SnackboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnackboxApplication.class, args);
	}

}
