package pl.coderslab.app.author;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;
    public void save(Author entity) {
        entityManager.persist(entity);
    }

    public void edit(Author entity){
        entityManager.merge(entity);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
