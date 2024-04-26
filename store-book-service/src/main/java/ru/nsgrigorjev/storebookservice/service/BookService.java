package ru.nsgrigorjev.storebookservice;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nsgrigorjev.storebookservice.model.Book;
import ru.nsgrigorjev.storebookservice.repository.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
