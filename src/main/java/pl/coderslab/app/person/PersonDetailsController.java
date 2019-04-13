package pl.coderslab.app.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/person-details")
public class PersonDetailsController {
    @PersistenceContext
    EntityManager entityManager;

    //akcja wyświetlenia formularza:
    @RequestMapping(value ="/form", method = RequestMethod.GET)
    public String showPersonDetailsForm(Model model){
        model.addAttribute("personDTO", new PersonDTO());
        return "registration-form";
    }

    //akcja przetwarzania danych z formularza:
    @RequestMapping(value ="/form", method = RequestMethod.POST)
    @ResponseBody
    public String processPersonDetailsForm(@ModelAttribute PersonDTO personDTO){
        return personDTO.toString();
    }

    @ModelAttribute("countries")
    public Collection<String> showCountries(){
        List<String> countries = new ArrayList<>();
        countries.add("Denmark");
        countries.add("England");
        countries.add("Italy");
        countries.add("Poland");
        countries.add("Spain");
        return countries;
    }

    @ModelAttribute("programmingSkills")
    public Collection<String> showProgrammingSkills(){
        List<String> programmingSkills = new ArrayList<>();
        programmingSkills.add("Github");
        programmingSkills.add("Hibernate");
        programmingSkills.add("Java EE");
        programmingSkills.add("Spring");
        return programmingSkills;
    }

    @ModelAttribute("hobbies")
    public Collection<String> showHobbies(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Eating");
        hobbies.add("Reading");
        hobbies.add("Singing");
        hobbies.add("Walking");
        return hobbies;
    }

}
