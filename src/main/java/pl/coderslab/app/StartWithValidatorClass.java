package pl.coderslab.app;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidatorClass implements ConstraintValidator<StartWith, String> {

    private String toCheck;

    //odbieramy prametr, który będziemy przekazywali w walidacji:
    @Override
    public void initialize(StartWith startWith) {
        this.toCheck = startWith.value();
    }

    //sprawdzamy, czy String zaczyna się od toCheck- wartości, któ©ą pobraliśmy:
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.startsWith(toCheck);
    }
}
