package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import pizza.api.IMenu;
import pizza.api.IMenuRow;
import pizza.api.core.Menu;
import pizza.dao.api.IMenuDao;

public class MenuDao implements IMenuDao {
	private final EntityManager em;
	private static final String SELECT_SQL = "SELECT id, dt_create, dt_update, name, enable" + "FROM app.menu;";
	private static final String SELECT_ROW_BY_ID_SQL = "SELECT info.id, info.dt_create, info.dt_update, info.name, info.description, info.size, \n"
			+ "rows.price, items.count\n"
			+ "	FROM app.selected_items AS items\n"
			+ "	JOIN app.order AS ord ON items.order=ord.id\n"
			+ "	JOIN app.menu_rows AS rows ON items.row=rows.id\n"
			+ "	JOIN app.pizza_info AS info ON rows.pizza=info.id\n"
			+ "	JOIN app.menu AS men ON men.id=rows.menu\n"
			+ "	WHERE rows.id=?;";

	public MenuDao(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public IMenu create(IMenu item, EntityManager em) {
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
	public IMenu read(long id) {
		try {
			em.getTransaction().begin();
			Menu menu = em.find(Menu.class, id);
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public List<IMenu> get() {
		try {
			em.getTransaction().begin();
			List<IMenu> menu = em.createQuery(SELECT_SQL).getResultList();
			if (menu == null) {
				throw new Exception("Такой записи не существует");
			}
			return menu;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}

	@Override
	public IMenu update(long id, LocalDateTime dtUpdate, IMenu type, EntityManager em) {
		try {
			em.getTransaction().begin();
			Menu menu = em.find(Menu.class, id);
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
	public IMenuRow readByRowId(long id) {
		try {
			em.getTransaction().begin();
			IMenuRow row = (IMenuRow) em.createQuery(SELECT_ROW_BY_ID_SQL).getSingleResult();
			if (row == null) {
				throw new Exception("Такой записи не существует");
			}
			return row;
		} catch (Exception e) {
			throw new RuntimeException("При чтении данных произошла ошибка", e);
		}
	}
}