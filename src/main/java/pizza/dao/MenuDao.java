package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pizza.api.core.Menu;
import pizza.api.core.MenuRow;
import pizza.dao.api.IMenuDao;
@Repository
public class MenuDao implements IMenuDao {
	
	private final EntityManager entityManager;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update, name, enable" + "FROM app.menu;";
	private static final String SELECT_ROW_BY_ID_SQL = "SELECT info.id, info.dt_create, info.dt_update, info.name, info.description, info.size, \n"
			+ "rows.price, items.count\n"
			+ "	FROM app.selected_items AS items\n"
			+ "	JOIN app.order AS ord ON items.order=ord.id\n"
			+ "	JOIN app.menu_rows AS rows ON items.row=rows.id\n"
			+ "	JOIN app.pizza_info AS info ON rows.pizza=info.id\n"
			+ "	JOIN app.menu AS men ON men.id=rows.menu\n"
			+ "	WHERE rows.id=?;";
@Autowired
	public MenuDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public Menu create(Menu item, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(item);
			entityManager.getTransaction().commit();
			return item;
		} catch (Exception e) {
			throw new RuntimeException("При сохранении данных произошла ошибка", e);
		}
	}

	@Override
	public Menu read(long id) {
		try {
			entityManager.getTransaction().begin();
			Menu menu = entityManager.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public List<Menu> get() {
		try {
			entityManager.getTransaction().begin();
			List<Menu> menu = entityManager.createQuery(SELECT_SQL).getResultList();
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public Menu update(long id, LocalDateTime dtUpdate, Menu type, EntityManager entityManager) {
		try {
			entityManager.getTransaction().begin();
			Menu menu = entityManager.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			if (!menu.getDtUpdate().equals(dtUpdate)) {
				throw new RuntimeException("Запись устарела");
			}
			menu.setDtUpdate(type.getDtUpdate());
			menu.setName(type.getName());
			menu.setEnabled(type.isEnabled());
			menu.setItems(type.getItems());
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
		return type;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
		try {
			em.getTransaction().begin();
			Menu menu = em.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			if (menu.getDtUpdate() == dtUpdate) {
				em.remove(menu);
			}
			;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public MenuRow readByRowId(long id) {
		try {
			entityManager.getTransaction().begin();
			MenuRow row = (MenuRow) entityManager.createQuery(SELECT_ROW_BY_ID_SQL).getSingleResult();
			if (row == null) {
				throw new Exception("Такой записи не существует");
			}
			return row;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}
}