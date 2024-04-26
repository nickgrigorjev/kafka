package ru.nsgrigorjev.checkbookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class Consumer {


    @KafkaListener(topics = "receiving-topic", groupId = "check-book-group")
    public void consume(String str){
      log.info("get message from receiving-topic. message: " + str);
    }
}
