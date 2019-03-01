package com.examplo.notificacao.enums;

import com.examplo.notificacao.sender.email.EmailSender;
import com.examplo.notificacao.sender.InterfaceSender;

public enum EnumSenders {

    EMAIL(EnumTipoNotificacao.EMAIL, EmailSender.class),
    ;


    private EnumTipoNotificacao tipoNotificacao;
    private Class< ? extends InterfaceSender> classe;

    EnumSenders(EnumTipoNotificacao tipoNotificacao, Class<? extends InterfaceSender> classe) {
        this.classe = classe;
        this.tipoNotificacao = tipoNotificacao;
    }

    public Class<? extends InterfaceSender> getClasse() {
        return classe;
    }

    public EnumTipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public static EnumSenders getEnumSenders(String tipoNotificacao){
        for(EnumSenders item : EnumSenders.values()){
            if(item.getTipoNotificacao().toString().toLowerCase().equals(tipoNotificacao.toLowerCase())){
                return item;
            }
        }
        return null;
    }

}
