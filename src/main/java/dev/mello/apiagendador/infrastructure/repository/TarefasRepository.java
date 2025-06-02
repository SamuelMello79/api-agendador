package dev.mello.apiagendador.infrastructure.repository;

import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import dev.mello.apiagendador.infrastructure.enums.StatusNotificacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefa,String> {
    List<Tarefa> findByDataEventoBetweenAndStatusNotificacao(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal,
                                                             StatusNotificacao status);
    List<Tarefa> findByEmailUsuario(String email);
}
