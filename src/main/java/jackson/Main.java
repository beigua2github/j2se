package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        Kobe kobe = new Kobe();
        Kobe kobe2 = new Kobe();


        ObjectMapper objectMapper = new ObjectMapper();

        String s = objectMapper.writeValueAsString(kobe);

        System.out.println(s);

        String s2 = objectMapper.writeValueAsString(kobe2);

        System.out.println(s2);
    }
}
