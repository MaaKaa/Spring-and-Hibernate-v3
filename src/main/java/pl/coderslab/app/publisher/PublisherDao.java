package pl.coderslab.app.publisher;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.person.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity) {
        entityManager.persist(entity);
    }

    public void edit(Publisher entity){
        entityManager.merge(entity);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    //do weryfikacji:
    public List<Publisher> findAllPublishers(Publisher entity){
        Query query = entityManager.createQuery("SELECT a FROM " + Publisher.class + " a");
        List<Publisher> publishers = query.getResultList();
        return publishers;
    }


    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
