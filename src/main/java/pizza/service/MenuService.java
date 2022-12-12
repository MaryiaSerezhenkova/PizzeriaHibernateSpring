package pizza.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pizza.api.core.Menu;
import pizza.api.core.MenuRow;
import pizza.api.dto.MenuDTO;
import pizza.api.mapper.MenuMapper;
import pizza.dao.MenuDao;
import pizza.dao.api.IMenuDao;
import pizza.service.api.IMenuService;
import pizza.service.api.IPizzaInfoService;
@Service
public class MenuService implements IMenuService {

	private final EntityManager entityManager;
	private final IMenuDao menuDao;
	private final IPizzaInfoService pizzaInfoService;

	@Autowired
	public MenuService(EntityManager entityManager, MenuDao menuDao, PizzaInfoService pizzaInfoService) {
		super();
		this.entityManager = entityManager;
		this.menuDao = menuDao;
		this.pizzaInfoService = pizzaInfoService;
	}

	@Override
	public Menu create(MenuDTO dto) {
		entityManager.getTransaction().begin();
		Menu menu = this.menuDao.create(MenuMapper.menuInputMapping(dto), this.entityManager);
		menu.setDtCreate(LocalDateTime.now());
		menu.setDtUpdate(menu.getDtCreate());
		menu.setName(dto.getName());
		menu.setEnabled(dto.isEnabled());
		menu.setItems(dto.getItems().stream()
				.map(i -> new MenuRow(this.pizzaInfoService.read(i.getPizzaInfo()), i.getPrice()))
				.collect(Collectors.toList()));
		entityManager.getTransaction().commit();
		return MenuMapper.menuOutputMapping(this.menuDao.create(menu, entityManager));
	}

	@Override
	public Menu read(long id) {
		return menuDao.read(id);
	}

	@Override
	public List<Menu> get() {
		return menuDao.get();
	}

	@Override
	public Menu update(long id, LocalDateTime dtUpdate, MenuDTO dto) {
		Menu readed = menuDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		readed.setDtUpdate(LocalDateTime.now());
		readed.setName(dto.getName());
		readed.setEnabled(dto.isEnabled());

		return menuDao.update(id, dtUpdate, readed, entityManager);
	}

	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		Menu readed = menuDao.read(id);

		if (readed == null) {
			throw new IllegalArgumentException("Меню не найдено");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению меню уже было отредактировано кем-то другим");
		}

		menuDao.delete(id, dtUpdate, entityManager);

	}

	@Override
	public MenuRow getRowById(long id) {
		return menuDao.readByRowId(id);
	}

}
