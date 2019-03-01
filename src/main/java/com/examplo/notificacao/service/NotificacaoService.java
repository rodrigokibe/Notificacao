package com.examplo.notificacao.service;

import com.examplo.notificacao.enums.EnumSenders;
import com.examplo.notificacao.exceptions.SenderNaoEncontradoException;
import com.examplo.notificacao.model.NotificacaoDTO;
import com.examplo.notificacao.sender.InterfaceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacaoService {

    @Autowired
    private ApplicationContext context;

    public void enviarNotificacao(List<NotificacaoDTO> notificacoes) throws Exception {
        for(NotificacaoDTO item : notificacoes) {
            Class<? extends InterfaceSender> senderInterface = EnumSenders.getEnumSenders(item.getTipo()).getClasse();
            if(senderInterface != null){
                InterfaceSender senderBean = context.getBean(senderInterface);
                senderBean.enviar(item);
            }else{
                throw new SenderNaoEncontradoException();
            }
        }
    }


}
