package dev.mello.apiagendador.controller;

import dev.mello.apiagendador.business.TarefaService;
import dev.mello.apiagendador.business.dto.TarefaDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaDTO> gravarTarefa(@RequestBody TarefaDTO tarefaDTO,
                                                   @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.save(tarefaDTO, token));
    }

    @GetMapping("/eventos")
    public  ResponseEntity<List<TarefaDTO>> buscarListaTarefasPorPeriodo(
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal
            ) {
        return ResponseEntity.ok(tarefaService.findForPeriod(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTarefasPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefaService.findTarefaByEmail(token));
    }

}
