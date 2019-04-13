package pl.coderslab.app.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherDao publisherDao;

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="name") String name){
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.save(publisher);
        return "Dodano publishera: ID: " + publisher.getId() + ", name: " + publisher.getName();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        publisherDao.findById(id);
        return "ID: " + publisherDao.findById(id).getId() + ", name: " + publisherDao.findById(id).getName();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                         @RequestParam(name="name") String name){
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherDao.edit(publisher);
        return "Zmodyfikowano publishera: ID: " + publisherDao.findById(id).getId() + ", name: " + publisherDao.findById(id).getName();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Publisher publisher = publisherDao.findById(id);
        publisherDao.delete(publisher);
        return "Id usuniętego publishera to:" + publisher.getId();
    }

}
