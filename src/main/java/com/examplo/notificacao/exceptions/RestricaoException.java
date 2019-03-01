package com.examplo.notificacao.exceptions;

public class RestricaoException extends Exception {


    public RestricaoException(String destinatarioInvalido) {
        super(destinatarioInvalido);
    }
}
