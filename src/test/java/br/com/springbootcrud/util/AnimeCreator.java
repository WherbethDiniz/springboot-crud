package br.com.springbootcrud.util;

import br.com.springbootcrud.domain.Anime;

public class AnimeCreator {

    public static Anime createAnimeToBeSaved() {
        return Anime.builder()
                .name("Hajime")
                .build();
    }

    public static Anime createValidAnime() {
        return Anime.builder()
                .name("Hajime")
                .id(1L)
                .build();
    }

    public static Anime createValidUpdateAnime() {
        return Anime.builder()
                .name("Hajime 2")
                .id(1L)
                .build();
    }
}
