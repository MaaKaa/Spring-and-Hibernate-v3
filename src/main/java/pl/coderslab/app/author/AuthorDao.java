package pl.coderslab.app.author;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    //do weryfikacji:
    public List<Author> findAllAuthors(Author entity){
        Query query = entityManager.createQuery("SELECT a FROM " + Author.class + " a");
        List<Author> authors = query.getResultList();
        return authors;
    }

    public void delete(Author entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}
