package pizza.api.mapper;

import pizza.api.core.PizzaInfo;
import pizza.api.dto.PizzaInfoDto;



public class PizzaInfoMapper {
	public PizzaInfoMapper() {
	}

	public static PizzaInfo pizzaInfoInputMapping(PizzaInfoDto pizzaInfoDto) {
		return new PizzaInfo(pizzaInfoDto.getName(), pizzaInfoDto.getDescription(), pizzaInfoDto.getSize());
	}

	public static PizzaInfo pizzaInfoOutputMapping(PizzaInfo pizzaInfo) {
		return new PizzaInfo(pizzaInfo.getId(), pizzaInfo.getDtCreate(), pizzaInfo.getDtUpdate(), pizzaInfo.getName(),
				pizzaInfo.getDescription(), pizzaInfo.getSize());
	}
}