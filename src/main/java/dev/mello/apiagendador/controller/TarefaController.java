package dev.mello.apiagendador.controller;

import dev.mello.apiagendador.business.TarefaService;
import dev.mello.apiagendador.business.dto.TarefaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


}
