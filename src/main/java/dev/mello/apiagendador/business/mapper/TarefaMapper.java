package dev.mello.apiagendador.business.mapper;

import dev.mello.apiagendador.business.dto.TarefaDTO;
import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {

    Tarefa toEntity(TarefaDTO tarefaDTO);
    TarefaDTO toDto(Tarefa tarefa);
}
