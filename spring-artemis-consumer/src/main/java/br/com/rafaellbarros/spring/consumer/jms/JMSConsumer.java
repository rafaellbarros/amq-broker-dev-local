package br.com.rafaellbarros.spring.consumer.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JMSConsumer {

    @JmsListener(destination = "address.foo::queue_1")
    public void consumer(String message) {
        log.info("consumer() {}", message);
    }
}
