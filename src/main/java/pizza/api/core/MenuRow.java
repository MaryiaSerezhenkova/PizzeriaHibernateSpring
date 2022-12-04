package pizza.api.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import pizza.api.IMenuRow;
import pizza.api.IPizzaInfo;
@Entity
public class MenuRow implements IMenuRow, Serializable {

	private static final long serialVersionUID = 1L;
	@OneToOne
    @JoinColumn(name = "info", referencedColumnName = "id")
	private IPizzaInfo pizzaInfo;
	@Column
	private double price;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public MenuRow() {
		super();
	}

	public MenuRow(IPizzaInfo pizzaInfo, double price) {
		super();
		this.pizzaInfo = pizzaInfo;
		this.price = price;
	}

	public IPizzaInfo getInfo() {
		return pizzaInfo;
	}

	public void setPizzaInfo(IPizzaInfo pizzaInfo) {
		this.pizzaInfo = pizzaInfo;

	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

}