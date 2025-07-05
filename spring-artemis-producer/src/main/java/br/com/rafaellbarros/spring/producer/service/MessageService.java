package br.com.rafaellbarros.spring.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageService {

    private final JmsTemplate jms;

    public void send(String message) {
        log.info("send() {}", message);
        jms.convertAndSend("address.foo", message);
    }
}
