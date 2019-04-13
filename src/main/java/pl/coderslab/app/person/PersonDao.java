package pl.coderslab.app.person;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

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

    public void deletePerson(Person entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
