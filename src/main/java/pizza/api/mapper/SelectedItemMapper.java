package pizza.api.mapper;

import pizza.api.ISelectedItem;
import pizza.api.core.SelectedItem;

public class SelectedItemMapper {
	
//	public static ISelectedItem selectedItemInputMapping(SelectedItemDTO selectedItemDTO) {
//		return new SelectedItem(selectedItemDTO.getRowId(), selectedItemDTO.getCount(), selectedItemDTO.getOrderId());
//	}

	public static SelectedItem selectedItemOutputMapping(ISelectedItem selectedItem) {
		return new SelectedItem(selectedItem.getRow(), selectedItem.getCount());
	}

}
