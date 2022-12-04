package pizza.api.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PizzaInfoDto {
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int size;

	public PizzaInfoDto() {
		super();
		
	}
	public PizzaInfoDto(String name, String description, int size) {
		super();
		this.name = name;
		this.description = description;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PizzaInfoDto [name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", size=");
		builder.append(size);
		builder.append("]");
		return builder.toString();
	}

}