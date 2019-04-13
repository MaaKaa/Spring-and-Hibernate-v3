package pl.coderslab.app.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="firstName") String firstName,
                       @RequestParam(name="lastName") String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.save(author);
        return "Dodano autora: ID: " + author.getId() + ", first name: " + author.getFirstName() + ", last name: " + author.getLastName();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        authorDao.findById(id);
        return "ID: " + authorDao.findById(id).getId() + ", first name: " + authorDao.findById(id).getFirstName() + ", last name: " + authorDao.findById(id).getLastName();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                       @RequestParam(name="firstName") String firstName,
                       @RequestParam(name="lastName") String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorDao.edit(author);
        return "Zmodyfikowano autora: ID: " + authorDao.findById(id).getId() + ", first name: " + authorDao.findById(id).getFirstName() + ", last name: " + authorDao.findById(id).getLastName();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "Id usuniętej książki to:" + author.getId();
    }

}
