package it.epicode.U5W2D2.services;

import it.epicode.U5W2D2.entities.Author;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Service
public class AuthorService {
    private List<Author> authors = new ArrayList<>();

    public Author findById(int id) {
        Author authorFound = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                authorFound = author;
            }
        }
        return authorFound;
    }

    public Author save(Author body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 200));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome() + "+" + body.getCognome());
        this.authors.add(body);
        return body;
    }

    public Author findByIdAndUpdate(int id, Author body) {
        Author authorFound = null;
        for (Author author : this.authors) {
            if (author.getId() == id) {
                authorFound = author;
                authorFound.setId(id);
                authorFound.setNome(body.getNome());
                authorFound.setCognome(body.getCognome());
                authorFound.setEmail(body.getEmail());
                authorFound.setDataDiNascita(body.getDataDiNascita());
            }
        }
        return authorFound;
    }

    public void findByIdAndDelete(int id) {
        this.authors.removeIf(current -> current.getId() == id);
    }
}
