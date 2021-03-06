package pl.coderslab.app.author;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.app.book.Book;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @ManyToMany
    private List<Book> books = new ArrayList<>();

    @PESEL
    private String pesel;

    @Email
    private String email;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getPesel() {
        return pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }*/
}
