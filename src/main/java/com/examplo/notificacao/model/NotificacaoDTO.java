package com.examplo.notificacao.model;

import com.examplo.notificacao.enums.EnumTipoNotificacao;
import com.examplo.notificacao.exceptions.ValidacaoCriacaoNotificacaoException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class NotificacaoDTO implements Serializable {

    @JsonProperty("destino")
    private String destino;

    @JsonProperty("cabecalho")
    private String cabecalho;

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("tipo")
    private String tipo;

    @JsonCreator
    public NotificacaoDTO(@JsonProperty("destino") String destino, @JsonProperty("cabecalho") String cabecalho, @JsonProperty("mensagem") String mensagem, @JsonProperty("tipo") String tipo) {
        String msg = "";
        if(destino == null || destino.isEmpty()){
            msg += "campo destino invalido; ";
        }
        if(cabecalho == null || cabecalho.isEmpty()){
            msg += "campo cabecalho invalido; ";
        }
        if(mensagem == null || mensagem.isEmpty()){
            msg += "campo mensagem invalido; ";
        }
        if(tipo == null || tipo.isEmpty() || !EnumTipoNotificacao.isTipoValido(tipo)){
            msg += "campo tipo invalido; ";
        }
        if(!msg.isEmpty()){
            throw new ValidacaoCriacaoNotificacaoException(msg);
        }
        this.destino = destino;
        this.mensagem = mensagem;
        this.cabecalho = cabecalho;
        this.tipo = tipo;
    }

    public String getDestino() {
        return destino;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCabecalho() {
        return cabecalho;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificacaoDTO that = (NotificacaoDTO) o;
        return Objects.equals(destino, that.destino) &&
                Objects.equals(mensagem, that.mensagem) &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(cabecalho, that.cabecalho)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destino, mensagem, tipo, cabecalho);
    }
}
