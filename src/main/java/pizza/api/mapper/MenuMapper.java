package pizza.api.mapper;

import pizza.api.IMenu;
import pizza.api.core.Menu;
import pizza.api.dto.MenuDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MenuMapper {
	
    public MenuMapper() {
		super();
	}

	public static IMenu menuInputMapping(MenuDTO menu) {
        return new Menu(menu.getName(), menu.isEnabled(), menu.getItems());
    }

    public static Menu menuOutputMapping(IMenu menu) {
        return new Menu(menu.getId(), menu.getDtCreate(), menu.getDtUpdate(), menu.getName(), menu.isEnabled(), menu.getItems());
    }

}