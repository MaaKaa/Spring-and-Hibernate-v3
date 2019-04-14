package pl.coderslab.app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.author.Author;
import pl.coderslab.app.publisher.Publisher;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ValidationController {
    @Autowired
    Validator validator;

    @GetMapping("/validateBook")
    public String validateBook(Model model){
        Book book = new Book();
        book.setTitle("The");
        book.setRating(BigDecimal.valueOf(8));
        book.setDescription("Lorem ipsum dolor sit amet");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        List<String> errorsBook = new ArrayList<>();

        if(violations.isEmpty()){
            return "Walidacja poprawna";
        } else {
            for (ConstraintViolation<Book> constViolation : violations){
                errorsBook.add("Pole: " + constViolation.getPropertyPath() + ", message: " + constViolation.getMessage());
            }

            model.addAttribute("errorsBook", errorsBook);
            return "errors";
        }
    }

    @GetMapping("/validateAuthor")
    public String validateAuthor(Model model){
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        author.setPesel("20000899");
        author.setEmail("marzena");

        Set<ConstraintViolation<Author>> violations = validator.validate(author);

        List<String> errorsAuthor = new ArrayList<>();

        if(violations.isEmpty()){
            return "Walidacja poprawna";
        } else {
            for (ConstraintViolation<Author> constViolation : violations){
                errorsAuthor.add("Pole: " + constViolation.getPropertyPath() + ", message: " + constViolation.getMessage());
            }

            model.addAttribute("errorsAuthor", errorsAuthor);
            return "errors";
        }
    }

    @GetMapping("/validatePublisher")
    public String validatePublisher(Model model){
        Publisher publisher = new Publisher();
        publisher.setName("Czarne");
        publisher.setNip("Nip");
        publisher.setRegon("");

        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);

        List<String> errorsPublisher = new ArrayList<>();

        if(violations.isEmpty()){
            return "Walidacja poprawna";
        } else {
            for (ConstraintViolation<Publisher> constViolation : violations){
                errorsPublisher.add("Pole: " + constViolation.getPropertyPath() + ", message: " + constViolation.getMessage());
            }

            model.addAttribute("errorsPublisher", errorsPublisher);
            return "errors";
        }
    }
}
