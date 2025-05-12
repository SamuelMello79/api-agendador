package dev.mello.apiagendador.infrastructure.repository;

import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<Tarefa,String> {

}
