package br.com.springbootcrud.client;

import br.com.springbootcrud.domain.Anime;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class SpringClient {
    public static void main(String[] args) {
        ResponseEntity<Anime> entity = new RestTemplate().getForEntity("http://localhost:8080/animes/{id}", Anime.class, 10);
        log.info(entity);

        Anime object = new RestTemplate().getForObject("http://localhost:8080/animes/{id}", Anime.class, 10);
        log.info(object);

        Anime[] animes = new RestTemplate().getForObject("http://localhost:8080/animes/all", Anime[].class);
        log.info(Arrays.toString(animes));

        ResponseEntity<List<Anime>> animeList = new RestTemplate().exchange("http://localhost:8080/animes/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {
                });
        log.info(animeList.getBody());

//        Anime Kingdom = Anime.builder().name("Kingdom").build();
//          Anime kingdomSaved = new RestTemplate().postForObject("http://localhost:8080/animes/", Kingdom, Anime.class);
//        log.info("saved anime {}", kingdomSaved);

        Anime samurai = Anime.builder().name("Samurai").build();
        ResponseEntity<Anime> samuraiSaved = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.POST,
                new HttpEntity<>(samurai, createJasonHeaders()),
                Anime.class);

        log.info("saved anime {}", samuraiSaved);

        Anime animeToBeUpdated = samuraiSaved.getBody();
        animeToBeUpdated.setName("Samurai 2");

        ResponseEntity<Void> samuraiUpdated = new RestTemplate().exchange("http://localhost:8080/animes/", HttpMethod.PUT,
                new HttpEntity<>(animeToBeUpdated, createJasonHeaders()),
                Void.class);

        log.info(samuraiUpdated);

        ResponseEntity<Void> samuraiDeleted = new RestTemplate().exchange("http://localhost:8080/animes/{id}", HttpMethod.DELETE,
                null,
                Void.class, animeToBeUpdated.getId());


        log.info(samuraiDeleted);

    }

    private static HttpHeaders createJasonHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

}
