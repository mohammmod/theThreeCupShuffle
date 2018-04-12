package at.refugeescode.trickster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
public class Endpoints {
    private List<String> urls = Arrays.asList("http://localhost:9000/coin"
            , "http://localhost:9001/coin", "http://localhost:9002/coin");
    private List<String> activeCups = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/play")
    public void playGame(){
        urls.forEach(oneurl -> restTemplate.delete(oneurl));
        Collections.shuffle(urls);
        restTemplate.put(urls.get(0),true);
        Collections.shuffle(urls);
    }

    @GetMapping("/choose/{number}")
    public String chooseOneCup(@PathVariable int number){
        ResponseEntity<String> response = restTemplate.getForEntity(urls.get(number)
                , String.class);

        System.out.println(response.getBody());
        String answer = response.getBody();
        if(answer.equalsIgnoreCase("yes")){
            return "you win";
        }
        return "you lost";
    }
}
