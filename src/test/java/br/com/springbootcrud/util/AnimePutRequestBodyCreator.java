package br.com.springbootcrud.util;

import br.com.springbootcrud.requests.AnimePostRequestBody;
import br.com.springbootcrud.requests.AnimePutRequestBody;

public class AnimePutRequestBodyCreator {
    public static AnimePutRequestBody createAnimePutRequestBody() {
        return AnimePutRequestBody.builder()
                .id(AnimeCreator.createValidUpdateAnime().getId())
                .name(AnimeCreator.createValidUpdateAnime().getName())
                .build();
    }
}
