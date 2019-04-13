package pl.coderslab.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    //akcja wyświetlenia formularza:
    @RequestMapping(value ="/form", method = RequestMethod.GET)
    public String showLoginForm(Model model){
        model.addAttribute("person", new Person());
        return "login-form";
    }

    //akcja przetwarzania danych z formularza:
    @RequestMapping(value ="/form", method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute Person person){
        personDao.savePerson(person);
        return "success";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="login") String login,
                         @RequestParam(name="password") String password,
                         @RequestParam(name="email") String email,
                         @RequestParam(name="personDetails") PersonDetails personDetails){
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        person.setPersonDetails(personDetails);
        personDao.savePerson(person);
        return "Dodano użytkownika: ID: " + person.getId() + ", login: " + person.getLogin();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        personDao.findPersonById(id);
        return "ID: " + personDao.findPersonById(id).getId() + ", login: " + personDao.findPersonById(id).getLogin();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                         @RequestParam(name="login") String login,
                         @RequestParam(name="password") String password,
                         @RequestParam(name="email") String email,
                         @RequestParam(name="personDetails") PersonDetails personDetails){
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);
        person.setPersonDetails(personDetails);
        personDao.editPerson(person);
        return "Zmodyfikowano dane użytkownika: ID: " + person.getId() + ", login: " + person.getLogin();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Person person = personDao.findPersonById(id);
        personDao.deletePerson(person);
        return "Id usuniętego użytkownika to:" + person.getId();
    }

}
