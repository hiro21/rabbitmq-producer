package com.course.rabbitmqproducer;

import com.course.rabbitmqproducer.entity.Employee;
import com.course.rabbitmqproducer.producer.HumanResourceProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {

	@Autowired
    private HumanResourceProducer employeeJsonProducer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		for (int i = 0; i < 5; i++) {
			var e  = new Employee("emp" + i, "Employee " + i, LocalDate.now());
			employeeJsonProducer.sendMessage(e);

		}
	}
}
