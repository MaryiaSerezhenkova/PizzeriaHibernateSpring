package pizza.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;
import pizza.api.mapper.PizzaInfoMapper;
import pizza.dao.api.IPizzaInfoDao;
import pizza.service.api.IPizzaInfoService;

@Service
@Transactional(readOnly=true)
public class PizzaInfoService implements IPizzaInfoService {

	  private final IPizzaInfoDao dao;

	    public PizzaInfoService(IPizzaInfoDao dao) {
	        this.dao = dao;
	    }

	@Override
	public PizzaInfo read(long id) {
		 return dao.getReferenceById(id);
	}

	@Override
	public List<PizzaInfo> get() {
		return dao.findAll();
	}
	
	@Override
	@Transactional
	public PizzaInfo update(long id, LocalDateTime dtUpdate, PizzaInfoDto item) {
		PizzaInfo readed = dao.getReferenceById(id);

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

		  return dao.save(readed);
	}

	@Override
	@Transactional
	public void delete(long id, LocalDateTime dtUpdate) {
		PizzaInfo readed = dao.getReferenceById(id);
		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		dao.delete(readed);
		

	}

	@Override
	@Transactional
	public PizzaInfo create(PizzaInfoDto dto) {

//		em.getTransaction().begin();
//		PizzaInfo pizzaInfo = this.pizzaInfoDao.create(PizzaInfoMapper.pizzaInfoInputMapping(dto), this.em);
//		pizzaInfo.setDtCreate(LocalDateTime.now());
//		pizzaInfo.setDtUpdate(pizzaInfo.getDtCreate());
//		em.getTransaction().commit();
//		return PizzaInfoMapper.pizzaInfoOutputMapping(this.pizzaInfoDao.create(pizzaInfo, em));
		return null;
	}

}
