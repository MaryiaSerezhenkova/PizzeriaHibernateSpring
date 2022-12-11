package pizza.dao.api;


import org.springframework.data.jpa.repository.JpaRepository;

import pizza.api.IMenuRow;
import pizza.api.core.PizzaInfo;

public interface IMenuDao extends JpaRepository<PizzaInfo, Long> {

	IMenuRow readByRowId(long id);

}
