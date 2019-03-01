package com.examplo.notificao.enums;

public enum EnumTipoNotificacao {

    EMAIL,
    ;



    public static boolean isTipoValido(String tipo){
        for(EnumTipoNotificacao item : values()){
            if(item.toString().toLowerCase().equals(tipo.toLowerCase())){
                return true;
            }
        }
        return false;
    }

}
