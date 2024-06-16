package SMWU.NaesoneulJAVA.NidonNaedon.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NidonNaedon API")
                        .version("1.0.0")
                        .description("NidonNaedon API 문서"));
    }
}
