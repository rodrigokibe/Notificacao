package com.examplo.notificao.sender;

import com.examplo.notificao.model.NotificacaoDTO;

public interface InterfaceSender {

    void enviar(NotificacaoDTO dto) throws Exception;

}
