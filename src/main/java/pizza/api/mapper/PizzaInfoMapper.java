package pizza.api.mapper;

import pizza.api.IPizzaInfo;
import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PizzaInfoMapper {
	public PizzaInfoMapper() {
	}

	public static IPizzaInfo pizzaInfoInputMapping(PizzaInfoDto pizzaInfoDto) {
		return new PizzaInfo(pizzaInfoDto.getName(), pizzaInfoDto.getDescription(), pizzaInfoDto.getSize());
	}

	public static PizzaInfo pizzaInfoOutputMapping(IPizzaInfo pizzaInfo) {
		return new PizzaInfo(pizzaInfo.getId(), pizzaInfo.getDtCreate(), pizzaInfo.getDtUpdate(), pizzaInfo.getName(),
				pizzaInfo.getDescription(), pizzaInfo.getSize());
	}
}