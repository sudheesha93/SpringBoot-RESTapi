 package com.example.springcode.walmartcode.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.springcode.walmartcode.entity.OrderEntity;
import com.example.springcode.walmartcode.entity.OrderStatus;
import com.example.springcode.walmartcode.entity.OrderItemEntity;
import com.example.springcode.walmartcode.entity.Supplier;
import com.example.springcode.walmartcode.exception.DataNotFoundException;
import com.example.springcode.walmartcode.repository.OrderRepository;


@Repository
public class OrderDAO {
	
	
	@Autowired
	private OrderRepository orderRepo;
	
	private EntityManager em;
	 
	@Autowired
	public OrderDAO(EntityManager em) {
		this.em = em;
	}

	
	// ORDER LIST
	@Transactional
	public List<OrderEntity> getAllOrders(){
		
	Session currentSession =  em.unwrap(Session.class);
	
	Query theQuery= currentSession.createQuery("from OrderEntity", OrderEntity.class);
	List<OrderEntity> list=theQuery.getResultList();
		return list;
		
		
	}

	// SUPPLIER LIST
	@Transactional
	public List<Supplier> getAllSupplier(){
		
		Session currentSession =  em.unwrap(Session.class);
		List<Supplier> list= new ArrayList<>();
		
			Query theQuery= currentSession.createQuery("from Supplier", Supplier.class);
			list= theQuery.getResultList();
	
		
		return list;
	}

	// ITEMS  LIST
	@Transactional
	public List<OrderItemEntity> getAllItems(){
		
		Session currentSession =  em.unwrap(Session.class);
		List<OrderItemEntity> list= new ArrayList<>();
		
			Query<OrderItemEntity> theQuery= currentSession.createQuery("from OrderItemEntity", OrderItemEntity.class);
			list= theQuery.getResultList();

		return list;
		
	}

	
	// CREATING AN ORDER FOR A GIVEN SUPPLIER
	@Transactional
	public void createOrder(int suppId, OrderEntity order){
		
		Session currentSession =  em.unwrap(Session.class);
	
			OrderEntity oe=new OrderEntity();
			oe.setId(order.getId());
			oe.setOrderDate(order.getOrderDate());
			oe.setAmount(order.getAmount());
			oe.setSupplier(order.getSupplier());
			oe.setStatus(order.getStatus());
			currentSession.save(oe);
		
	}

	
	// UPDATING THE STATUS OF THE PARTICULAR ORDER
	@Transactional
	public void updateOrder(int ordId){
		
		Session currentSession =  em.unwrap(Session.class);
		OrderEntity oe=currentSession.load(OrderEntity.class,ordId);
		System.out.println("Sudheesha : "+ oe);
		oe.setStatus(OrderStatus.Open);
		currentSession.update(oe);
		
	}

	
	// ADD/MODIFY THE ITEM ORDER IF THE ORDER STATUS IS OPEN
	@Transactional
	public void saveOrUpdate(OrderItemEntity item){

		Session currentSession =  em.unwrap(Session.class);
		
		int orderId=item.getOrderId().getId();
		
		Query theQuery= currentSession.createQuery("select status from OrderEntity where order_id=: id");
		theQuery.setParameter("id",orderId);
		
		OrderStatus s= (OrderStatus) theQuery.uniqueResult();

		
		if(s.toString().equalsIgnoreCase("open")){
			currentSession.saveOrUpdate(item);
		}
		else {
			System.out.println("status is not open");
		}
		
			
	}

	@Transactional
	public void getOrderById(int id) throws DataNotFoundException{
		
		try {
			
		}
		catch(Exception e) {
			
		}
		
	}


	 
	
	

}
