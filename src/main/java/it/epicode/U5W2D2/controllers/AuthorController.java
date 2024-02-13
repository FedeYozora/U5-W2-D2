package it.epicode.U5W2D2.controllers;

import it.epicode.U5W2D2.entities.Author;
import it.epicode.U5W2D2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public List<Author> getAuthor() {
        return authorService.getAuthors();
    }

    @GetMapping("/{id}")
    public Author findByID(@PathVariable int id) {
        return authorService.findById(id);
    }

    @PostMapping("/")
    public Author saveAuthor(@RequestBody Author body) {
        return authorService.save(body);
    }

    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body) {
        return authorService.findByIdAndUpdate(id, body);
    }

    @DeleteMapping("/{id}")
    public void findByIdAndDelete(@PathVariable int id) {
        authorService.findByIdAndDelete(id);
    }

}
