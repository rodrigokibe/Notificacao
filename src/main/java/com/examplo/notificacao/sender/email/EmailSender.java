package com.examplo.notificacao.sender.email;


import com.examplo.notificacao.exceptions.EmailSenderException;
import com.examplo.notificacao.exceptions.RestricaoException;
import com.examplo.notificacao.model.NotificacaoDTO;
import com.examplo.notificacao.sender.InterfaceRestricao;
import com.examplo.notificacao.sender.InterfaceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailSender implements InterfaceSender {

    @Value("${spring.mail.from}")
    private String emailFrom;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void enviar(NotificacaoDTO dto) throws Exception {
        validar(dto);
        enviarEmail(dto);
    }

    private void validar(NotificacaoDTO dto) throws RestricaoException {
        for (EnumRestricao item : EnumRestricao.values()){
            item.validar(dto);
        }
    }

    private void enviarEmail(NotificacaoDTO dto) throws Exception{

        try {
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(emailFrom);
            helper.setTo(dto.getDestino());
            helper.setSubject(dto.getCabecalho());
            helper.setText(dto.getMensagem(), false);
            javaMailSender.send(message);
        } catch (MessagingException e) {
           throw new EmailSenderException(e.getMessage());
        }

    }
}

enum EnumRestricao implements InterfaceRestricao {

    DESTINATIO{
        @Override
        public void validar(NotificacaoDTO notificacaoDTO) throws RestricaoException {
            Pattern p = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)");
            Matcher m = p.matcher(notificacaoDTO.getDestino());
            if(!m.find()){
                throw new RestricaoException("Destinatario Invalido");
            }
        }
    },
    ;

}
