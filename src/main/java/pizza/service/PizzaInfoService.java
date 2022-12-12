package pizza.service;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;
import pizza.api.mapper.PizzaInfoMapper;
import pizza.dao.PizzaInfoDao;
import pizza.service.api.IPizzaInfoService;

@Service
public class PizzaInfoService implements IPizzaInfoService {
	@PersistenceContext
	private final EntityManager entityManager;

	private final PizzaInfoDao pizzaInfoDao;

	@Autowired
	public PizzaInfoService(EntityManager entityManager, PizzaInfoDao pizzaInfoDao) {
		super();
		this.entityManager = entityManager;
		this.pizzaInfoDao = pizzaInfoDao;
	}

	@Override
	public PizzaInfo read(long id) {
		return pizzaInfoDao.read(id);
	}

	@Override
	public List<PizzaInfo> get() {
		return pizzaInfoDao.get();
	}

	public PizzaInfo get(Long id) {
		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.read(id));
	}

	@Override
	public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDto item) {
		PizzaInfo readed = pizzaInfoDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		readed.setDtUpdate(LocalDateTime.now());
		readed.setName(item.getName());
		readed.setDescription(item.getDescription());
		readed.setSize(item.getSize());

		return pizzaInfoDao.update(id, dtUpdate, readed, entityManager);
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		IPizzaInfo readed = pizzaInfoDao.read(id);
		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		pizzaInfoDao.delete(id, dtUpdate, entityManager);

	}

	@Override
	public PizzaInfo create(PizzaInfoDto dto) {

		entityManager.getTransaction().begin();
		PizzaInfo pizzaInfo = this.pizzaInfoDao.create(PizzaInfoMapper.pizzaInfoInputMapping(dto), this.entityManager);
		pizzaInfo.setDtCreate(LocalDateTime.now());
		pizzaInfo.setDtUpdate(pizzaInfo.getDtCreate());
		entityManager.getTransaction().commit();
		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.create(pizzaInfo, entityManager));
	}

}
