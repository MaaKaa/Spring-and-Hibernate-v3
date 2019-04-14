package pl.coderslab.app.book;

import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;
import javax.validation.Validation;

@Controller
@Transactional
public class NewValidatorController {
    Validation validator;
}
