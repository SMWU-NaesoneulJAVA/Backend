package SMWU.NaesoneulJAVA.NidonNaedon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "SMWU.NaesoneulJAVA.NidonNaedon.models")
public class NidonNaedonApplication {

	public static void main(String[] args) {
		SpringApplication.run(NidonNaedonApplication.class, args);
	}
}
