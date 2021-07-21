package br.com.springbootcrud.service;

import br.com.springbootcrud.repository.CdProjektUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CdProjektUserDetailsService implements UserDetailsService {
    private final CdProjektUserRepository cdProjektUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return Optional.ofNullable(cdProjektUserRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("CdProjekt User not found"));
    }
}
