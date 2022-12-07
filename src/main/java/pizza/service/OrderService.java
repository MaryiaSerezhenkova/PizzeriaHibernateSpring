package pizza.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import pizza.api.IOrder;
import pizza.api.core.SelectedItem;
import pizza.api.dto.OrderDTO;
import pizza.api.mapper.OrderMapper;
import pizza.dao.api.IOrderDao;
import pizza.service.api.IMenuService;
import pizza.service.api.IOrderService;

public class OrderService implements IOrderService {
	private final EntityManager em;
	private final IOrderDao orderDao;
	private final IMenuService menuService;


	public OrderService(EntityManager em, IOrderDao orderDao, IMenuService menuService) {
		super();
		this.em = em;
		this.orderDao = orderDao;
		this.menuService = menuService;
	}


	@Override
	public IOrder create(OrderDTO dto) {
		em.getTransaction().begin();
		IOrder order = this.orderDao.create(OrderMapper.orderInputMapping(dto), this.em);
		order.setDtCreate(LocalDateTime.now());
		order.setDtUpdate(order.getDtCreate());
//		order.setItems(dto.getSelectedItems().stream()
//				.map(i -> {
//					return new SelectedItem(this.menuService.read(i.getMenuRow(), i.getCount()));})
//				.collect(Collectors.toList()));
		em.getTransaction().commit();
		return OrderMapper.orderOutputMapping(this.orderDao.create(order, em));
	}



	@Override
	public IOrder read(long id) {
		return  orderDao.read(id);
	}


	@Override
	public List<IOrder> get() {
		return orderDao.get();
	}


	@Override
	public IOrder update(long id, LocalDateTime dtUpdate, OrderDTO dto) {
		IOrder readed = orderDao.read(id);
		
				if (readed == null) {
					throw new IllegalArgumentException("Позиция не найдена");
				}
		
				if (!readed.getDtUpdate().isEqual(dtUpdate)) {
					throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
				}
		
				readed.setDtUpdate(LocalDateTime.now());
			//	readed.setItems(dto.getSelectedItems());
		
				return orderDao.update(id, dtUpdate, readed, em);
			}


	@Override
	public void delete(long id, LocalDateTime dtUpdate) {
		IOrder readed = orderDao.read(id);
		
		if (readed == null) {
			throw new IllegalArgumentException("Позиция не найдена");
		}

		if (!readed.getDtUpdate().isEqual(dtUpdate)) {
			throw new IllegalArgumentException("К сожалению позиция уже была отредактирована кем-то другим");
		}

		orderDao.delete(id, dtUpdate, em);
	}

//
}
