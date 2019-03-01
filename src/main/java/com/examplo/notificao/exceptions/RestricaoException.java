package com.examplo.notificao.exceptions;

public class RestricaoException extends Exception {


    public RestricaoException(String destinatarioInvalido) {
        super(destinatarioInvalido);
    }
}
