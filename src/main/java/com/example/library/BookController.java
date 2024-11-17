package com.example.library;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<String, Book> bookCollection = new HashMap<>();

    @PostMapping
    public String addBook(@RequestBody Book book) {
        if (bookCollection.containsKey(book.getIsbn())) {
            return "Book with this ISBN already exists!";
        }
        bookCollection.put(book.getIsbn(), book);
        return "Book added successfully!";
    }

    @GetMapping
    public Collection<Book> listBooks() {
        return bookCollection.values();
    }

    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return bookCollection.getOrDefault(isbn, null);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookCollection.values()) {
            if ((title == null || book.getTitle().equalsIgnoreCase(title)) &&
                    (author == null || book.getAuthor().equalsIgnoreCase(author))) {
                result.add(book);
            }
        }
        return result;
    }

    @PutMapping("/{isbn}/borrow")
    public String borrowBook(@PathVariable String isbn) {
        Book book = bookCollection.get(isbn);
        if (book == null) {
            return "Book not found!";
        }
        if (!book.isAvailable()) {
            return "Book is already borrowed!";
        }
        book.setAvailable(false);
        return "Book borrowed successfully!";
    }

    @PutMapping("/{isbn}/return")
    public String returnBook(@PathVariable String isbn) {
        Book book = bookCollection.get(isbn);
        if (book == null) {
            return "Book not found!";
        }
        if (book.isAvailable()) {
            return "Book was not borrowed!";
        }
        book.setAvailable(true);
        return "Book returned successfully!";
    }
}
