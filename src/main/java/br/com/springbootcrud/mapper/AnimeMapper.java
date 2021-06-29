package br.com.springbootcrud.mapper;

import br.com.springbootcrud.domain.Anime;
import br.com.springbootcrud.requests.AnimePostRequestBody;
import br.com.springbootcrud.requests.AnimePutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    public abstract Anime ToAnime(AnimePostRequestBody animePostRequestBody);

    public abstract Anime ToAnime(AnimePutRequestBody animePutRequestBody);

}
