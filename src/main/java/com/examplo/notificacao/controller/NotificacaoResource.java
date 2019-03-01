package com.examplo.notificacao.controller;

import com.examplo.notificacao.model.NotificacaoDTO;
import com.examplo.notificacao.service.NotificacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificacao/")
@Api(value = "api/notificacao/", description = "Operações relacionadas a notificacao")
public class NotificacaoResource {


    private final Logger logger = LoggerFactory.getLogger(NotificacaoResource.class);

    @Autowired
    private NotificacaoService notificacaoService;


    @PostMapping("/enviar")
    @ApiOperation(value = "enviar",
            tags = {"todos", "notificacao"},
            response = String[].class)
    public ResponseEntity enviarNotificacao(@RequestBody List<NotificacaoDTO> notificacoes) throws Exception {
        logger.info(""+notificacoes.size());
        notificacaoService.enviarNotificacao(notificacoes);
        return ResponseEntity.ok().build();
    }        

}
