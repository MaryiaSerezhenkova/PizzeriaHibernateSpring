package pizza.api.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class MenuDTO {
	@Column
	private String name;
	@Column (name="enable")
	private boolean enabled;
	private List<Row> items;

	public MenuDTO() {
		super();
	}

	public MenuDTO(String name, boolean enabled) {

		this.name = name;
		this.enabled = enabled;
	}

	public MenuDTO(String name, boolean enabled, List<Row> items) {
		super();
		this.name = name;
		this.enabled = enabled;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public List<Row> getItems() {
		return items;
	}

	public void setItems(List<Row> items) {
		this.items = items;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static class Row {
		private long pizzaInfo;
		private double price;

		public long getPizzaInfo() {
			return pizzaInfo;
		}

		public void setPizzaInfo(long pizzaInfo) {
			this.pizzaInfo = pizzaInfo;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
	}
}
