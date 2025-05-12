package dev.mello.apiagendador.business.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import dev.mello.apiagendador.infrastructure.enums.StatusNotificacao;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {
    private String id;
    private String titulo;
    private String descricao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriacao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataEvento;
    private String emailUsuario;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataAlteracao;
    private StatusNotificacao statusNotificacao;
}
