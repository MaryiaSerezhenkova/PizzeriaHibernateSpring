package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import pizza.api.IOrder;
import pizza.api.core.Order;
import pizza.dao.api.IOrderDao;

public class OrderDao  implements IOrderDao {
	private final EntityManager em;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update" + "FROM app.\"order\"";
	public OrderDao(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public IOrder create(IOrder item, EntityManager em) {
		try {
			em.getTransaction().begin();
			em.persist(item);
			em.getTransaction().commit();
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}
	@Override
	public IOrder read(long id) {
		try {
			em.getTransaction().begin();
			Order order = em.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			return order;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}


	@Override
	public List<IOrder> get() {
		try {
			em.getTransaction().begin();
			List<IOrder> order = em.createQuery(SELECT_SQL).getResultList();
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			return order;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public IOrder update(long id, LocalDateTime dtUpdate, IOrder type, EntityManager em) {
		try {
			em.getTransaction().begin();
			Order order = em.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!order.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			order.setDtUpdate(type.getDtUpdate());
			order.setItems(type.getSelected());
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
		return type;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
		try {
			em.getTransaction().begin();
			Order order = em.find(Order.class, id);
			if (order == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!order.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			em.remove(order);
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

}
