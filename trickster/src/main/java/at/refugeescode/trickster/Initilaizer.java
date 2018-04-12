package at.refugeescode.trickster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Initilaizer {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
