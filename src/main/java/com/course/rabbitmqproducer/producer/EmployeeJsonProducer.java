package com.course.rabbitmqproducer.producer;

import com.course.rabbitmqproducer.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeJsonProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendMessage(Employee emp) {
        try {
            var json = objectMapper.writeValueAsString(emp);
            rabbitTemplate.convertAndSend("course.employee", json);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
