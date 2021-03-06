package br.com.springbootcrud.service;

import br.com.springbootcrud.domain.Anime;
import br.com.springbootcrud.exception.BadRequestException;
import br.com.springbootcrud.mapper.AnimeMapper;
import br.com.springbootcrud.repository.AnimeRepository;
import br.com.springbootcrud.requests.AnimePostRequestBody;
import br.com.springbootcrud.requests.AnimePutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animeRepository;

    public Page<Anime> listAll(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }

    public List<Anime> listAllNonPageable() {
        return animeRepository.findAll();
    }

    public List<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

    public Anime findByIdOrThrowBadRequestException(Long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Anime not found"));


    }

    @Transactional
    public Anime save(AnimePostRequestBody animePostRequestBody) {
        return animeRepository.save(AnimeMapper.INSTANCE.ToAnime(animePostRequestBody));

    }

    public void delete(Long id) {
        animeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
        Anime savedAnime = findByIdOrThrowBadRequestException(animePutRequestBody.getId());
        Anime anime = AnimeMapper.INSTANCE.ToAnime(animePutRequestBody);
        anime.setId(savedAnime.getId());
        animeRepository.save(anime);

    }

}
