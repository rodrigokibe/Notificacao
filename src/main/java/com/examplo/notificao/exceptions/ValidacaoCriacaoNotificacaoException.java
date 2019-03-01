package com.examplo.notificao.exceptions;

public class ValidacaoCriacaoNotificacaoException extends RuntimeException {


    public ValidacaoCriacaoNotificacaoException(){
        super("Erro ao criar Notificacao");
    }


    public ValidacaoCriacaoNotificacaoException(String erro){
        super("Erro ao criar Notificacao - "+erro);
    }

}
