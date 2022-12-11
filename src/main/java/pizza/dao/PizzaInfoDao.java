package pizza.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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
