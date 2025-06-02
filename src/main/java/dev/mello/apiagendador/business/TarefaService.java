package dev.mello.apiagendador.business;

import dev.mello.apiagendador.business.dto.TarefaDTO;
import dev.mello.apiagendador.business.mapper.TarefaMapper;
import dev.mello.apiagendador.business.mapper.TarefaUpdateMapper;
import dev.mello.apiagendador.infrastructure.exception.NotFoundException;
import dev.mello.apiagendador.infrastructure.entity.Tarefa;
import dev.mello.apiagendador.infrastructure.enums.StatusNotificacao;
import dev.mello.apiagendador.infrastructure.repository.TarefasRepository;
import dev.mello.apiagendador.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final TarefasRepository tarefasRepository;
    private final TarefaMapper tarefaMapper;
    private final TarefaUpdateMapper tarefaUpdateMapper;
    private final JwtUtil jwtUtil;

    public TarefaDTO save(TarefaDTO tarefaDTO, String token) {
        String email = jwtUtil.extractUsername(token.substring(7)); // Coleta o email do usuário via token retirando o 'Bearer '
        tarefaDTO.setEmailUsuario(email); // Define o email do usuário na tarefa
        tarefaDTO.setDataCriacao(LocalDateTime.now()); // Define a data como data atual
        tarefaDTO.setStatusNotificacao(StatusNotificacao.PENDENTE); // Define o status com valor padrão 'PENDENTE'
        return tarefaMapper.toDto(tarefasRepository.save(tarefaMapper.toEntity(tarefaDTO)));
    }

    public List<TarefaDTO> findForPeriod(LocalDateTime dataInicio, LocalDateTime dataFinal) {
        return tarefasRepository.findByDataEventoBetweenAndStatusNotificacao(dataInicio, dataFinal, StatusNotificacao.PENDENTE)
                .stream()
                .map(tarefaMapper::toDto)
                .toList();
    }

    public List<TarefaDTO> findTarefaByEmail(String token) {
        String email = jwtUtil.extractUsername(token.substring(7));
        return tarefasRepository.findByEmailUsuario(email).stream()
                .map(tarefaMapper::toDto)
                .toList();
    }

    public void deleteById(String id) {
        tarefasRepository.deleteById(id);
    }

    public TarefaDTO updateStatus(StatusNotificacao status, String id) {
        Tarefa entity = tarefasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("A Tarefa com id: " + id + " não foi encontrada"));
        entity.setStatusNotificacao(status);
        return tarefaMapper.toDto(tarefasRepository.save(entity));
    }

    public TarefaDTO updateTarefa(TarefaDTO dto, String id) {
        Tarefa entity = tarefasRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("A Tarefa com id: " + id + " não foi encontrada"));
        tarefaUpdateMapper.updateTarefas(dto, entity);
        return tarefaMapper.toDto(tarefasRepository.save(entity));
    }
}
