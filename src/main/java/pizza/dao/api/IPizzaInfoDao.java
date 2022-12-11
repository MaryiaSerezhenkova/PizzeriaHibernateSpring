package pizza.dao.api;

import org.springframework.data.jpa.repository.JpaRepository;

import pizza.api.core.PizzaInfo;

public interface IPizzaInfoDao extends JpaRepository<PizzaInfo, Long>  {


}
