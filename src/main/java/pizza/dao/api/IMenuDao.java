package pizza.dao.api;


import pizza.api.core.Menu;
import pizza.api.core.MenuRow;

public interface IMenuDao extends IDao<Menu> {

	MenuRow readByRowId(long id);

}
