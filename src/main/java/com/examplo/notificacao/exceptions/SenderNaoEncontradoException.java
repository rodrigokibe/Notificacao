package com.examplo.notificacao.exceptions;

public class SenderNaoEncontradoException extends RuntimeException {


    public SenderNaoEncontradoException(){
        super("Sender nao encontrato");
    }


    public SenderNaoEncontradoException(String erro){
        super("Sender nao encontrato - "+erro);
    }

}
