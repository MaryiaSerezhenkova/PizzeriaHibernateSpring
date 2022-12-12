package pizza.api.mapper;

import pizza.api.core.Menu;
import pizza.api.dto.MenuDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

public class MenuMapper {
	
    public MenuMapper() {
		super();
	}

	public static Menu menuInputMapping(MenuDTO menu) {
        return new Menu(menu.getName(), menu.isEnabled(), menu.getItems());
    }

    public static Menu menuOutputMapping(Menu menu) {
        return new Menu(menu.getId(), menu.getDtCreate(), menu.getDtUpdate(), menu.getName(), menu.isEnabled(), menu.getItems());
    }

}