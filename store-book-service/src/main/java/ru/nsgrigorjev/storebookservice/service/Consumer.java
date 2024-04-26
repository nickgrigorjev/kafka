package ru.nsgrigorjev.checkbookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.nsgrigorjev.storebookservice.model.Book;


@Service
@Slf4j
@RequiredArgsConstructor
public class Consumer {

    private final KafkaTemplate<String, Book> template;

    @KafkaListener(topics = "receiving-topic", groupId = "check-book-group",
    containerFactory = "kafkaListenerContainerFactory")
    public void consume(Book book){
      log.info("get message from receiving-topic. message: " + book);
      book.setStatus("checked");
      log.info("set status \"checked\": " + book);
      template.send("saving-topic", book);
    }
}
