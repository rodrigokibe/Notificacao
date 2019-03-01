package com.examplo.notificacao.sender;

import com.examplo.notificacao.exceptions.RestricaoException;
import com.examplo.notificacao.model.NotificacaoDTO;

public interface InterfaceRestricao {

    void validar(NotificacaoDTO notificacaoDTO) throws RestricaoException;
}
