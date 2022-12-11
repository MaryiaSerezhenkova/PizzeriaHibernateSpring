package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import pizza.api.IMenu;
import pizza.api.IMenuRow;
import pizza.api.core.Menu;
import pizza.api.core.PizzaInfo;
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

//	@Override
//	public IMenu create(IMenu item, EntityManager em) {
//		try {
//			em.getTransaction().begin();
//			em.persist(item);
//			em.getTransaction().commit();
//			return item;
//		} catch (Exception e) {
//			throw new RuntimeException("При сохранении данных произошла ошибка", e);
//		}
//	}
//
//	@Override
//	public IMenu read(long id) {
//		try {
//			em.getTransaction().begin();
//			Menu menu = em.find(Menu.class, id);
//			if (menu == null) {
//				throw new Exception("Такой записи не существует");
//			}
//			return menu;
//		} catch (Exception e) {
//			throw new RuntimeException("При чтении данных произошла ошибка", e);
//		}
//	}
//
//	@Override
//	public List<IMenu> get() {
//		try {
//			em.getTransaction().begin();
//			List<IMenu> menu = em.createQuery(SELECT_SQL).getResultList();
//			if (menu == null) {
//				throw new Exception("Такой записи не существует");
//			}
//			return menu;
//		} catch (Exception e) {
//			throw new RuntimeException("При чтении данных произошла ошибка", e);
//		}
//	}
//
//	@Override
//	public IMenu update(long id, LocalDateTime dtUpdate, IMenu type, EntityManager em) {
//		try {
//			em.getTransaction().begin();
//			Menu menu = em.find(Menu.class, id);
//			if (menu == null) {
//				throw new Exception("Такой записи не существует");
//			}
//			if (!menu.getDtUpdate().equals(dtUpdate)) {
//				throw new RuntimeException("Запись устарела");
//			}
//			menu.setDtUpdate(type.getDtUpdate());
//			menu.setName(type.getName());
//			menu.setEnabled(type.isEnabled());
//			menu.setItems(type.getItems());
//		} catch (Exception e) {
//			throw new RuntimeException("При чтении данных произошла ошибка", e);
//		}
//		return type;
//	}
//
//	@Override
//	public void delete(long id, LocalDateTime dtUpdate, EntityManager em) {
//		try {
//			em.getTransaction().begin();
//			Menu menu = em.find(Menu.class, id);
//			if (menu == null) {
//				throw new Exception("Такой записи не существует");
//			}
//			if (menu.getDtUpdate() == dtUpdate) {
//				em.remove(menu);
//			}
//			;
//		} catch (Exception e) {
//			throw new RuntimeException("При чтении данных произошла ошибка", e);
//		}
//	}

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

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends PizzaInfo> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<PizzaInfo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PizzaInfo getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PizzaInfo getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PizzaInfo getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PizzaInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PizzaInfo> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<PizzaInfo> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PizzaInfo entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends PizzaInfo> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PizzaInfo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PizzaInfo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends PizzaInfo> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends PizzaInfo> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends PizzaInfo> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends PizzaInfo, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
}