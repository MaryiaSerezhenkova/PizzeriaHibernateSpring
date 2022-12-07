package pizza.api.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import pizza.api.IMenuRow;
import pizza.api.IOrder;
import pizza.api.ISelectedItem;
@Entity
public class SelectedItem implements ISelectedItem, Serializable {
	private static final long serialVersionUID = 1L;
	@OneToOne
    @JoinColumn(name = "row", referencedColumnName = "id")
	private IMenuRow row;
    @Column
	private int count;
    
	@ManyToOne
    @JoinColumn(name = "order", referencedColumnName = "id")
	private IOrder order;

	public SelectedItem() {
		super();
	}

	public SelectedItem(IMenuRow row, int count, IOrder order) {
		super();
		this.row = row;
		this.count = count;
		this.order = order;
	}

	public SelectedItem(IMenuRow row, int count) {
		this.row = row;
		this.count = count;
	}

	public void setSelectedItem(IMenuRow row) {
		this.row = row;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public IMenuRow getRow() {
		return row;
	}

	public int getCount() {
		return count;
	}

	public IOrder getOrder() {
		return order;
	}

	public void setOrder(IOrder order) {
		this.order = order;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelectedItem [row=");
		builder.append(row);
		builder.append(", count=");
		builder.append(count);
		builder.append(", order=");
		builder.append(order);
		builder.append("]");
		return builder.toString();
	}

}