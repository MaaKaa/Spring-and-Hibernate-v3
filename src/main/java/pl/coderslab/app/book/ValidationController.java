package pl.coderslab.app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/validate")
    public String validateBook(Model model){
        Book book = new Book();
        book.setTitle("The");
        book.setRating(BigDecimal.valueOf(8));
        book.setDescription("Lorem ipsum dolor sit amet");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        List<String> error = new ArrayList<>();

        if(violations.isEmpty()){
            return "Walidacja poprawna";
        } else {
            for (ConstraintViolation<Book> constViolation : violations){
                error.add("Pole: " + constViolation.getPropertyPath() + ", message: " + constViolation.getMessage());
            }

            model.addAttribute("errors", error);
            return "errors";
        }
    }

    //dodać metody do validacji Authora i Publishera


}
