package CSC340.IndAssignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IndAssignment2Application {

	public static void main(String[] args) {
		SpringApplication.run(IndAssignment2Application.class, args);
                getJoke();
                System.exit(0);
	}
        private static void getJoke() {
        try {
            String url = "https://v2.jokeapi.dev/joke/Any?safe-mode&type=twopart";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String setup = root.findValue("setup").asText();
            String delivery = root.findValue("delivery").asText();

            System.out.println("**********Your joke********");
            System.out.println(setup);
            System.out.println(delivery);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(IndAssignment2Application.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getJoke");

        }
        }

}
