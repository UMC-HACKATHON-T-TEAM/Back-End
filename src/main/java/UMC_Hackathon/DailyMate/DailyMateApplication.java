package UMC_Hackathon.DailyMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DailyMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyMateApplication.class, args);
	}

}
