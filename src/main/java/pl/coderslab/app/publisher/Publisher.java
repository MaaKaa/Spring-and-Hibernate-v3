package pl.coderslab.app.publisher;

import pl.coderslab.app.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String nip;

    private String regon;

    @OneToMany(mappedBy="publisher")
    private List<Book> books = new ArrayList<>();

    public Publisher() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }
}
