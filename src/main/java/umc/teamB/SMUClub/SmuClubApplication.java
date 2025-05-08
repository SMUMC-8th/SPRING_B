package umc.teamB.SMUClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 기능을 활성화 시켜 줌.
@SpringBootApplication
public class SmuClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmuClubApplication.class, args);
	}

}
