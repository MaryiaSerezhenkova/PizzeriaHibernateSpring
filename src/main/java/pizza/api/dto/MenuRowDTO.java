package pizza.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class MenuRowDTO {
	@Column
	private long pizzaInfoId;
	@Column
	private double price;
	@Column
	private long menuId;

	public MenuRowDTO() {
		super();
	}

	public MenuRowDTO(long pizzaInfoId, double price, long menuId) {
		super();
		this.pizzaInfoId = pizzaInfoId;
		this.price = price;
		this.menuId = menuId;
	}

	public long getPizzaInfoId() {
		return pizzaInfoId;
	}

	public void setPizzaInfoId(long pizzaInfoId) {
		this.pizzaInfoId = pizzaInfoId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getMenuId() {
		return menuId;
	}

	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuRowDTO [pizzaInfoId=");
		builder.append(pizzaInfoId);
		builder.append(", price=");
		builder.append(price);
		builder.append(", menuId=");
		builder.append(menuId);
		builder.append("]");
		return builder.toString();
	}

}