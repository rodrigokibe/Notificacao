package com.examplo.notificao.sender;

import com.examplo.notificao.exceptions.RestricaoException;
import com.examplo.notificao.model.NotificacaoDTO;

public interface InterfaceRestricao {

    void validar(NotificacaoDTO notificacaoDTO) throws RestricaoException;
}
