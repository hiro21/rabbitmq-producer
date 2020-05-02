package com.course.rabbitmqproducer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.basic.BasicRadioButtonMenuItemUI;

@Service
public class HelloRabbitProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendHello(String name) {
        rabbitTemplate.convertAndSend("course.hello", "Hello " + name);

        // 通常はバイト配列ににする必要」があるが、rabbitTemplateがやる。
        // exchangeにはこの方法は送らない。
    }
}
