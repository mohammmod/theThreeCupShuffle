package at.refugeescode.threecupshuffel.endPoint;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
public class Endpoint {
    private String hasAcoin = "YES";

    @GetMapping
    public String seeIftheCoinThere() {
        return hasAcoin;
    }

    @DeleteMapping
    public String deleteTheCoin(){
        return "";
    }

    @PostMapping
    String posttoTrue(@RequestBody String coin){
        System.out.println(coin);
       return coin;
    }
}
