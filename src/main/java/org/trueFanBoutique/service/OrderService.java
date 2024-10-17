package org.trueFanBoutique.service;

import java.util.List;

import org.trueFanBoutique.model.Ordenes;
import org.trueFanBoutique.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
   public final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {

	this.orderRepository = orderRepository;
}

	public List<Ordenes> getAllOrder() {
		return orderRepository.findAll();
		
	}//getAllOrders

	public Ordenes getOrder(Long orderId) {
		
		return orderRepository.findById(orderId).orElseThrow(
				()->new IllegalArgumentException("La orden con el id [" + orderId
						+ "] no existe.")
				);
	}//getOrder
	
	public Ordenes addOrder(Ordenes order) {
		orderRepository.save(order);
		return order;
	}//addOrder
	
	public Ordenes deleteOrder(Long orderId) {
		Ordenes ord = null;
			if ( orderRepository.existsById(orderId) ) {
				ord= orderRepository.findById(orderId).get();
				orderRepository.deleteById(orderId);
			}//if
		return ord;
	}//deleteOrder

	public Ordenes updateOrder(Long orderId) {
		Ordenes ord = null;
	        if (orderRepository.existsById(orderId)) { 
	           ord= orderRepository.findById(orderId).get();;
	            ord.setOrderStatus(!ord.getOrderStatus()); ;
	          orderRepository.save(ord);
	        }
	    
	    return ord;
	}//updateOrder
	
}//class OrderService 
