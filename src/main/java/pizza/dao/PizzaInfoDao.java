package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.dao.api.IPizzaInfoDao;

@Repository
public class PizzaInfoDao implements IPizzaInfoDao {
	@Autowired
	private EntityManager em;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update, name, description, size"
			+ "	FROM app.pizza_info;";


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
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	public List<IPizzaInfo> get() {
		try {
			em.getTransaction().begin();
			List<IPizzaInfo> pizzaInfo = em.createQuery(SELECT_SQL).getResultList();
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			return pizzaInfo;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	public IPizzaInfo update(long id, LocalDateTime dtUpdate, IPizzaInfo type, EntityManager em) {
		try {
			em.getTransaction().begin();
			PizzaInfo pizzaInfo = em.find(PizzaInfo.class, id);
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!pizzaInfo.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			pizzaInfo.setDtUpdate(type.getDtUpdate());
			pizzaInfo.setName(type.getName());
			pizzaInfo.setDescription(type.getDescription());
			pizzaInfo.setSize(type.getSize());
			;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
		return type;
	}

	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
		try {
			em.getTransaction().begin();
			PizzaInfo pizzaInfo = em.find(PizzaInfo.class, id);
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!pizzaInfo.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			em.remove(pizzaInfo);

			;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}
}
