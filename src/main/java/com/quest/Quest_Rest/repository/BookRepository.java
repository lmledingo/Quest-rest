package com.quest.Quest_Rest.repository;

import com.quest.Quest_Rest.Entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository

public interface BookRepository extends JpaRepository<Book, Long> {


    List<Book> findByTitleContainingOrDescriptionContaining(String searchTerm, String searchTerm1);
}
