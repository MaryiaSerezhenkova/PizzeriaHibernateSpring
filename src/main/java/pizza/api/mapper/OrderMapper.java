package pizza.api.mapper;

import pizza.api.IOrder;
import pizza.api.core.Order;
import pizza.api.dto.OrderDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;


public class OrderMapper {
	
	 public OrderMapper() {
		super();
	}

	public static IOrder orderInputMapping(OrderDTO order) {
	        return new Order(order.getSelectedItems());
	    }

	    public static Order orderOutputMapping(IOrder order) {
	        return new Order(order.getId(), order.getDtCreate(), order.getDtUpdate(), order.getSelected());
	    }

}
