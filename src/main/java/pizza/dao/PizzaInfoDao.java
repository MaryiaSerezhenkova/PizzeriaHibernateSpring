package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pizza.api.core.PizzaInfo;
import pizza.dao.api.IPizzaInfoDao;

@Repository
public class PizzaInfoDao implements IPizzaInfoDao {
	
	@PersistenceContext
	private final EntityManager entityManager;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update, name, description, size"
			+ "	FROM app.pizza_info;";



	@Autowired
	public PizzaInfoDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public PizzaInfo create(PizzaInfo item, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(item);
			entityManager.getTransaction().commit();
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}

	public PizzaInfo read(long id) {
		try {
			entityManager.getTransaction().begin();
			PizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			return pizzaInfo;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	public List<PizzaInfo> get() {
		try {
			entityManager.getTransaction().begin();
			List<PizzaInfo> pizzaInfo = entityManager.createQuery(SELECT_SQL).getResultList();
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			return pizzaInfo;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfo type, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			PizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
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

	public void delete(long id, LocalDateTime dtUpdate, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			PizzaInfo pizzaInfo = entityManager.find(PizzaInfo.class, id);
			if (pizzaInfo == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!pizzaInfo.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			entityManager.remove(pizzaInfo);

			;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}
}
