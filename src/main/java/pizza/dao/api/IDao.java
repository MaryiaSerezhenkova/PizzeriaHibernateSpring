package pizza.dao.api;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

public interface IDao<TYPE> {
    TYPE create(TYPE item, EntityManager em);
    TYPE read(long id);
    List<TYPE> get();
    TYPE update(long id, LocalDateTime dtUpdate, TYPE type, EntityManager em);
    void delete(long id, LocalDateTime dtUpdate, EntityManager em);
}
