package dev.mello.apiagendador.business.mapper;

import dev.mello.apiagendador.business.dto.TarefaDTO;
import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

// Caso o valor que seja passado seja nulo,  o nullValue.. mantém os dados já definidos na propriedade do objeto
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefaUpdateMapper {
    // O Mapping target define qual a classe que deve manter os dados caso a outra mande dados nulos
    // Ex: se o dto enviar o nome como nulo, ele mantém o nome definido na entity
    void updateTarefas(TarefaDTO dto, @MappingTarget Tarefa entity);
}
