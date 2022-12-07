package pizza.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import pizza.api.ITicket;
import pizza.api.core.Order;
import pizza.api.core.Ticket;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TicketMapper {
    private final OrderMapper orderMapper;
    @Autowired
    public TicketMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public ITicket inputMapping(ITicket ticket) {
        Order order = orderMapper.orderOutputMapping(ticket.getOrder());
        return new Ticket (ticket.getNumber(), ticket.getOrder().getId());
                
    }

    public ITicket outputMapping(ITicket ticket) {
        Order order = orderMapper.orderOutputMapping(ticket.getOrder());
        return new Ticket (ticket.getId(), ticket.getCreatAt(), ticket.getNumber(), ticket.getOrder());
                
    }
}