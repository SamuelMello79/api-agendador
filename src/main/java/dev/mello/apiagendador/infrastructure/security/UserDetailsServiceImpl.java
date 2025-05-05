package dev.mello.apiagendador.infrastructure.security;

import dev.mello.apiagendador.business.dto.UsuarioDTO;
import dev.mello.apiagendador.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl {

    // Cria instancia da client da api-usuario
    private final UsuarioClient usuarioClient;

    public UserDetails loadUserByUsename(String email, String token) {
        UsuarioDTO usuarioDTO = usuarioClient.buscarUsuarioPorEmail(email, token);
        return User.withUsername(usuarioDTO.getEmail()) // Define o nome do usuário como o email
                .password(usuarioDTO.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }

}

