package pl.coderslab.app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="title") String title,
                       @RequestParam(name="author") String author,
                       @RequestParam(name="rating")BigDecimal rating,
                       @RequestParam(name="publisher") String publisher,
                       @RequestParam(name="description") String description){
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setRating(rating);
        book.setPublisher(publisher);
        book.setDescription(description);
        bookDao.save(book);
        return "Dodano książkę: ID: " + book.getId() + ", title: " + book.getTitle() + ", author: " + book.getAuthor();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        bookDao.findById(id);
        return "ID: " + bookDao.findById(id).getId() + ", title: " + bookDao.findById(id).getTitle() + ", author: " + bookDao.findById(id).getAuthor();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                       @RequestParam(name="title") String title,
                       @RequestParam(name="author") String author,
                       @RequestParam(name="rating")BigDecimal rating,
                       @RequestParam(name="publisher") String publisher,
                       @RequestParam(name="description") String description){
        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setAuthor(author);
        book.setRating(rating);
        book.setPublisher(publisher);
        book.setDescription(description);
        bookDao.edit(book);
        return "Zmodyfikowano książkę: " + book.getTitle();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        return "Id usuniętej książki to:" + book.getId();
    }

}
