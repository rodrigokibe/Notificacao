package com.examplo.notificacao.sender;

import com.examplo.notificacao.model.NotificacaoDTO;

public interface InterfaceSender {

    void enviar(NotificacaoDTO dto) throws Exception;

}
