package dev.mello.apiagendador.infrastructure.repository;

import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefa,String> {
    List<Tarefa> findByDataEventoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
    List<Tarefa> findByEmailUsuario(String email);
}
