package pl.coderslab.app.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    EntityManager entityManager;
    public void savePerson(Person entity) {
        entityManager.persist(entity);
    }

    public void editPerson(Person entity){
        entityManager.merge(entity);
    }

    public Person findPersonById(long id) {
        return entityManager.find(Person.class, id);
    }

    //do weryfikacji:
    public List<Person> findAllPersons(Person entity){
        Query query = entityManager.createQuery("SELECT a FROM " + Person.class + " a");
        List<Person> persons = query.getResultList();
        return persons;
    }

    public void deletePerson(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
