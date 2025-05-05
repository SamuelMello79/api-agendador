package dev.mello.apiagendador.business.dto;

import lombok.*;

import java.util.List;

@Builder
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String email;
    private String senha;
}
