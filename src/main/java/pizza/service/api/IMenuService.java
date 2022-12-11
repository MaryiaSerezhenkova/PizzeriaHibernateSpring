package pizza.service.api;

import pizza.api.IMenuRow;
import pizza.api.core.Menu;
import pizza.api.dto.MenuDTO;

public interface IMenuService extends IService<Menu, MenuDTO> {
	IMenuRow getRowById(long id);

}
