package br.com.rafaellbarros.spring.producer.controller;

import br.com.rafaellbarros.spring.producer.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/message")
    public String send(@RequestBody String message) {
        messageService.send(message);
        return message;
    }
}
