package ru.nsgrigorjev.creationbookservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.nsgrigorjev.creationbookservice.model.Book;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaScheduledProducer {
    private final KafkaTemplate<String, Book> template;



    @Scheduled(fixedDelay = 10000L)
    public void send() {
        Random random = new Random();
        long randomInteger = Instant.now().getEpochSecond();
        Book book = Book.builder()
                .id("Book" + randomInteger)
                .name("book name" + randomInteger)
                .description(String.format("description%s", randomInteger))
                .status("unchecked")
                .price(BigDecimal.valueOf(randomInteger / 1_000_000))
                .build();

        String message = Instant.now().toString();
        log.info(String.format("producing message %s to Kafka, topic=receiving-topic", book));
//      template.send("receiving-topic", message);
      //TODO 26.04.2024 - 9:38: переделать с String -> Book
      template.send("receiving-topic", book);
    }
}
