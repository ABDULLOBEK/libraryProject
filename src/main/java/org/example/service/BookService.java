package org.example.service;

import lombok.Setter;
import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Setter
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void bookList() {
        List<Book> bookList=bookRepository.getList();
        if(bookList!=null){
            bookList.forEach(System.out::println);
        }else {
            System.out.println("you don't have any cards");

        }
    }

}
