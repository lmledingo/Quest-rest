package com.quest.Quest_Rest.controller;

import com.quest.Quest_Rest.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quest.Quest_Rest.repository.BookRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @GetMapping("/books")
    public List<Book> index(){
        return (bookRepository.findAll());

    }
    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }
    @PutMapping("/books/{id}")
        public Book modify(@PathVariable Long id, @RequestBody Book book) {
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getTitle());
        return bookRepository.save(bookToUpdate);

    }



 /*   @PostMapping("/books")
    public void postBook(@ModelAttribute Book book) {

        bookRepository.save(book);

    }*/
 @PostMapping("/books")
 public Book create(@RequestBody Book book){
     return bookRepository.save(book);
 }
    @DeleteMapping("/books/{id}")
    public Boolean delete(@PathVariable Long id) {

        bookRepository.deleteById(id);
        return true;


    }


}
