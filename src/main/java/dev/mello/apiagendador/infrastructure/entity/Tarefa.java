package dev.mello.apiagendador.infrastructure.entity;

import dev.mello.apiagendador.infrastructure.enums.StatusNotificacao;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Document("tarefa")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String emailUsuario;
    private LocalDateTime dataAlteracao;
    private StatusNotificacao statusNotificacao;
}
