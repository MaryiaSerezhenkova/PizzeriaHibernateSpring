package pizza.api.mapper;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import pizza.api.IOrderStatus;
import pizza.api.core.OrderStatus;

public class OrderStatusMapper {
	
		public OrderStatus orderOutputMapping(OrderStatus order) {
			return new OrderStatus(order.getTicket(), order.getHistory(), order.isDone());
		}

	}

