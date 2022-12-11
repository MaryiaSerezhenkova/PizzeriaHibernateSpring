package pizza.api;


import pizza.api.core.PizzaInfo;

public interface IMenuRow {
	PizzaInfo getInfo();

	void setPizzaInfo(PizzaInfo pizzaInfo);

	double getPrice();

	void setPrice(double price);

//	LocalDateTime getDtCreate();
//
//	void setDtCreate(LocalDateTime dtCreate);
//
//	LocalDateTime getDtUpdate();
//
//	void setDtUpdate(LocalDateTime dtUpdate);
//
//	IMenu getMenu();
//
//	void setMenu(IMenu menu);
//
//	void setId(long id);
//
//	long getPizzaInfoId();
//
//	void setPizzaInfoId(long id);
//
//	long getMenuId();
//
//	void setMenuId(long id);
//
	long getId();
}