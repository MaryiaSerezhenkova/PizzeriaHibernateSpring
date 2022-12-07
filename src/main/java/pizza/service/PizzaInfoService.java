package pizza.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;
import pizza.api.mapper.PizzaInfoMapper;
import pizza.dao.api.IPizzaInfoDao;
import pizza.service.api.IPizzaInfoService;

@Service
public class PizzaInfoService implements IPizzaInfoService {

	@Autowired
	private IPizzaInfoDao pizzaInfoDao;

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
//		IPizzaInfo readed = pizzaInfoDao.read(id);
//
//		if (readed == null) {
//			throw new IllegalArgumentException("Позиция не найдена");
//		}
//
//		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
//			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
//		}
//
//		readed.setDtUpdate(LocalDateTime.now());
//		readed.setName(item.getName());
//		readed.setDescription(item.getDescription());
//		readed.setSize(item.getSize());
//
//		return pizzaInfoDao.update(id, dtUpdate, readed);
		return null;
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
//		IPizzaInfo readed = pizzaInfoDao.read(id);
//		if (readed == null) {
//			throw new IllegalArgumentException("Позиция не найдена");
//		}
//
//		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
//			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
//		}
//
//		pizzaInfoDao.delete(id, dtUpdate, em);
//		

	}

	@Override
	public IPizzaInfo create(PizzaInfoDto dto) {
//
//		em.getTransaction().begin();
//		IPizzaInfo pizzaInfo = this.pizzaInfoDao.create(PizzaInfoMapper.pizzaInfoInputMapping(dto), this.em);
//		pizzaInfo.setDtCreate(LocalDateTime.now());
//		pizzaInfo.setDtUpdate(pizzaInfo.getDtCreate());
//		em.getTransaction().commit();
		//return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.create(pizzaInfo, em));
		return null;
	}

}
