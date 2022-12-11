package pizza.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import pizza.api.IMenu;
import pizza.api.IMenuRow;
import pizza.api.core.Menu;
import pizza.api.core.MenuRow;
import pizza.api.dto.MenuDTO;
import pizza.api.mapper.MenuMapper;
import pizza.dao.api.IMenuDao;
import pizza.service.api.IMenuService;
import pizza.service.api.IPizzaInfoService;
@Transactional(readOnly=true)
public class MenuService implements IMenuService {
	
	private final EntityManager em;
	private final IMenuDao menuDao;
	private final IPizzaInfoService pizzaInfoService;

	public MenuService(EntityManager em, IMenuDao menuDao, IPizzaInfoService pizzaInfoService) {
		super();
		this.em = em;
		this.menuDao=menuDao;
		this.pizzaInfoService = pizzaInfoService;
	}

	@Override
	@Transactional
	public Menu create(MenuDTO dto) {
//		em.getTransaction().begin();
//		IMenu menu = this.menuDao.create(MenuMapper.menuInputMapping(dto), this.em);
//		menu.setDtCreate(LocalDateTime.now());
//		menu.setDtUpdate(menu.getDtCreate());
//		menu.setName(dto.getName());
//		menu.setEnabled(dto.isEnabled());
//		menu.setItems(dto.getItems().stream()
//				.map(i -> new MenuRow(this.pizzaInfoService.read(i.getPizzaInfo()), i.getPrice()))
//				.collect(Collectors.toList()));
//		em.getTransaction().commit();
//		return MenuMapper.menuOutputMapping(this.menuDao.create(menu, em));
		return null;
	}

	@Override
	public Menu read(long id) {
		return menuDao.read(id);
	}

	@Override
	public List<Menu> get() {
		return menuDao.findAll();
	}

	@Override
	@Transactional
	public Menu update(long id, LocalDateTime dtUpdate, MenuDTO dto) {
//		IMenu readed = menuDao.read(id);
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
//		readed.setName(dto.getName());
//		readed.setEnabled(dto.isEnabled());

//		return menuDao.update(id, dtUpdate, readed, em);
		return null;
	}

	@Override
	@Transactional
	public void delete(long id, LocalDateTime dtUpdate) {
//		IMenu readed = menuDao.read(id);
//
//		if (readed == null) {
//			throw new IllegalArgumentException("Меню не найдено");
//		}
//
//		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
//			throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
//		}
//
//		menuDao.delete(id, dtUpdate, em);

	}
	@Override
	public IMenuRow getRowById(long id) {
		return menuDao.readByRowId(id);
	}

}
