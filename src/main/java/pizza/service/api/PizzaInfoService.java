package pizza.service.api;


import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;
import pizza.api.mapper.PizzaInfoMapper;
import pizza.api.validator.PizzaInfoValidator;
import pizza.dao.api.IPizzaInfoDao;


public class PizzaInfoService implements IPizzaInfoService {
	private final EntityManager em;

	public PizzaInfoService(EntityManager em, IPizzaInfoDao pizzaInfoDao) {
		super();
		this.em = em;
		this.pizzaInfoDao = pizzaInfoDao;
	}

	private final IPizzaInfoDao pizzaInfoDao;
	private static PizzaInfoValidator pizzaInfoValidator;

	public PizzaInfoService(IPizzaInfoDao pizzaInfoDao) {
		this.em = null;
		this.pizzaInfoDao = pizzaInfoDao;
	}

	@Override
	public IPizzaInfo read(long id) {
		return pizzaInfoDao.read(id);
	}

	@Override
	public List<IPizzaInfo> get() {
		return pizzaInfoDao.get();
	}

	public PizzaInfo get(Long id) {
		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.read(id));
	}

	@Override
	public IPizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDto item) {
		IPizzaInfo readed = pizzaInfoDao.read(id);

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

		return pizzaInfoDao.update(id, dtUpdate, readed, em);
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

		pizzaInfoDao.delete(id, dtUpdate, em);

	}

	@Override
	public IPizzaInfo create(PizzaInfoDto dto) {

		em.getTransaction().begin();
		IPizzaInfo pizzaInfo = this.pizzaInfoDao.create(PizzaInfoMapper.pizzaInfoInputMapping(dto), this.em);
		pizzaInfo.setDtCreate(LocalDateTime.now());
		pizzaInfo.setDtUpdate(pizzaInfo.getDtCreate());
		em.getTransaction().commit();
		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.create(pizzaInfo, em));
	}

}
