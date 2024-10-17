package org.trueFanBoutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trueFanBoutique.model.Ordenes;
import org.trueFanBoutique.service.OrderService;

@RestController
@RequestMapping(path="/truefan/order/")
public class OrderController {
	private final OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}//constructor
	
	@GetMapping
	public List<Ordenes> getOrder(){
		return orderService.getAllOrder();
	}//getOrder

	@GetMapping(path="{orderId}")// http://localhost:8080/truefan/order/1
	public Ordenes getOrder(@PathVariable("orderId")Long orderId) {
		return orderService.getOrder(orderId);
	}//getOrder
	
	@PostMapping  // http://localhost:8080/truefan/order/
	public Ordenes addOrder(@RequestBody Ordenes order) {
		 return orderService.addOrder(order);
	}//addOrder
	
	@DeleteMapping(path="{orderId}")// http://localhost:8080/truefan/order/1
	public Ordenes deleteOrder (@PathVariable("orderId")Long orderid) {
		return orderService.deleteOrder(orderid);
	}//deleteOrder
	
	@PutMapping(path="{orderId}")
	public Ordenes updateOrder(@PathVariable("orderId") Long orderId) {
		return orderService.updateOrder(orderId);
	}//updateOrder
	

}//class OrderController
