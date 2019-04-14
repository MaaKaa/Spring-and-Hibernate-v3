package pl.coderslab.app.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.util.Set;

@Controller
@Transactional
public class NewValidatorController {
    @Autowired
    Validator validator;

    @GetMapping("/testOfBookValidator")
    @ResponseBody
    public String validateBook(){
        Book book = new Book();
        book.setTitle("The");
        book.setRating(BigDecimal.valueOf(8));
        book.setDescription("Lorem ipsum dolor sit amet");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        if(violations.isEmpty()){
            return "Walidacja poprawna";
        } else {
            for (ConstraintViolation<Book> constViolation : violations){
                System.out.println("Pole: " + constViolation.getPropertyPath() + ", message: " + constViolation.getMessage());
            }

            return "Validation violation";
        }
    }


}
