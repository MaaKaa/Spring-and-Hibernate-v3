package pl.coderslab.app.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBook(Book entity) {
        entityManager.persist(entity);
    }

    public void editBook(Book entity){
        entityManager.merge(entity);
    }

    public Book findBookById(long id) {
        return entityManager.find(Book.class, id);
    }

    //do weryfikacji:
    public List<Book> findAllBooks(){
        Query query = entityManager.createQuery("SELECT a FROM " + Book.class + " a");
        List<Book> books = query.getResultList();
        return books;
    }

    public void deleteBook(Book entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }

    public List<Book> getRatingList(int rating){
        Query query = entityManager.createQuery("SELECT b FROM " + Book.class + "b WHERE rating=" + rating);
        List<Book> booksRating = query.getResultList();
        return booksRating;
    }
}
