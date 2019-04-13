package pl.coderslab.app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.publisher.Publisher;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="title") String title,
                       //@RequestParam(name="author") Author author,
                       @RequestParam(name="authors") List<Author> authors,
                         @RequestParam(name="rating")BigDecimal rating,
                       @RequestParam(name="publisher") Publisher publisher,
                       @RequestParam(name="description") String description){
        Book book = new Book();
        book.setTitle(title);
        //book.setAuthor(author);
        book.setAuthors(authors);
        book.setRating(rating);
        book.setPublisher(publisher);
        book.setDescription(description);
        bookDao.saveBook(book);
        return "Dodano książkę: ID: " + book.getId() + ", title: " + book.getTitle();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        bookDao.findBookById(id);
        return "ID: " + bookDao.findBookById(id).getId() + ", title: " + bookDao.findBookById(id).getTitle();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                       @RequestParam(name="title") String title,
                       //@RequestParam(name="author") Author author,
                         @RequestParam(name="authors") List<Author> authors,
                       @RequestParam(name="rating")BigDecimal rating,
                       @RequestParam(name="publisher") Publisher publisher,
                       @RequestParam(name="description") String description){
        Book book = bookDao.findBookById(id);
        book.setTitle(title);
        //book.setAuthor(author);
        book.setAuthors(authors);
        book.setRating(rating);
        book.setPublisher(publisher);
        book.setDescription(description);
        bookDao.editBook(book);
        return "Zmodyfikowano książkę: " + book.getTitle();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Book book = bookDao.findBookById(id);
        bookDao.deleteBook(book);
        return "Id usuniętej książki to:" + book.getId();
    }

}
