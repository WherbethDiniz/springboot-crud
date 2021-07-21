package br.com.springbootcrud.repository;

import br.com.springbootcrud.domain.Anime;
import br.com.springbootcrud.domain.CdProjektUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CdProjektUserRepository extends JpaRepository<CdProjektUser, Long> {

    CdProjektUser findByUsername(String username);
}
