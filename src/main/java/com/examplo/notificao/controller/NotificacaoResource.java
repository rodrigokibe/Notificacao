package com.examplo.notificao.controller;

import com.examplo.notificao.model.NotificacaoDTO;
import com.examplo.notificao.service.NotificacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificao/")
@Api(value = "api/notificao/", description = "Operações relacionadas a notificao")
public class NotificacaoResource {


    private final Logger logger = LoggerFactory.getLogger(NotificacaoResource.class);

    @Autowired
    private NotificacaoService notificacaoService;


    @PostMapping("/enviar")
    @ApiOperation(value = "enviar",
            tags = {"todos", "notificao"},
            response = String[].class)
    public ResponseEntity enviarNotificacao(@RequestBody List<NotificacaoDTO> notificacoes) throws Exception {
        logger.info(""+notificacoes.size());
        notificacaoService.enviarNotificacao(notificacoes);
        return ResponseEntity.ok().build();
    }        

}
