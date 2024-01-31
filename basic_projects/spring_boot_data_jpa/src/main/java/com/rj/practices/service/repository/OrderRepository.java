package com.rj.practices.service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rj.practices.service.entity.PizzaOrderEntity;
import com.rj.practices.service.proyection.OrderSummary;

@Repository
public interface OrderRepository extends ListCrudRepository<PizzaOrderEntity, Integer> {

	List<PizzaOrderEntity> findAllByDateAfter(LocalDateTime date);

	List<PizzaOrderEntity> findAllByMethodIn(List<String> methods);

	@Query(nativeQuery = true, value = "select * from pizza_order where id_customer = :id")
	List<PizzaOrderEntity> findCustomerOrders(@Param("id") String idCustomer);

	/*
	 * select po.id_order as idOrder, c.name as customerName,po.`date` as orderDate,
	 * po.total as orderTotal, GROUP_CONCAT(p.name) as pizzasNames from
	 * pizzeria.pizza_order po inner join pizzeria.customer c on po.id_customer =
	 * c.id_customer inner join pizzeria.order_item oi on po.id_order = oi.id_order
	 * inner join pizzeria.pizza p on oi.id_pizza = p.id_pizza where po.id_order = 1
	 * GROUP by po.id_order, c.name, po.`date`, po.total
	 */

	@Query(nativeQuery = true, value = "select po.id_order as idOrder, c.name as customerName, po.`date` as orderDate, po.total as orderTotal, GROUP_CONCAT(p.name) as pizzasNames from pizzeria.pizza_order po inner join pizzeria.customer c on po.id_customer = c.id_customer inner join pizzeria.order_item oi on po.id_order = oi.id_order inner join pizzeria.pizza p on oi.id_pizza = p.id_pizza where po.id_order = :id GROUP by po.id_order, c.name, po.`date`, po.total")
	OrderSummary findSummary(@Param("id") int orderId);

	@Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
	boolean saveRandomOrder(@Param("id_customer") String id_customer, @Param("method") String method);

}
