package pizza.dao;


import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.dao.api.IPizzaInfoDao;

public class PizzaInfoDao implements IPizzaInfoDao {
	private final EntityManager em;

	public PizzaInfoDao(EntityManager em) {
		super();
		this.em = em;
	}

	public IPizzaInfo create(IPizzaInfo item, EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}

	public IPizzaInfo read(long id) {
		try {
			em.getTransaction().begin();
			PizzaInfo pizzaInfo = em.find(PizzaInfo.class, id);
            if (pizzaInfo == null) {
                throw new Exception("Такой записи не существует");
            }
            return pizzaInfo;
        } catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
	}
	}

	public List<IPizzaInfo> get() {
		// TODO Auto-generated method stub
		return null;
	}

	public IPizzaInfo update(long id, LocalDateTime dtUpdate, IPizzaInfo type, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
		// TODO Auto-generated method stub

	}

}
