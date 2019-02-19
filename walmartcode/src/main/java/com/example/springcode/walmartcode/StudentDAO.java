package com.example.springcode.walmartcode;


import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;




@Repository
public class StudentDAO {
	
	private EntityManager em;
	
	
	@Autowired
	public StudentDAO(EntityManager em) {
		this.em = em;
	}

	// STUDENT LIST
	@Transactional
	public List<Student> getAllStudents() {
		
		Session currentSession =  em.unwrap(Session.class);
		Query<Student> theQuery= currentSession.createQuery("from Student", Student.class);
		List<Student> list= theQuery.getResultList();
		return list;
	}

	// ORDER LIST
	@Transactional
	public List<OrderEntity> getAllOrders() {
		Session currentSession =  em.unwrap(Session.class);
		Query<OrderEntity> theQuery= currentSession.createQuery("from OrderEntity", OrderEntity.class);
		List<OrderEntity> list= theQuery.getResultList();
		return list;
	}

	// SUPPLIER LIST
	@Transactional
	public List<Supplier> getAllSupplier() {
		Session currentSession =  em.unwrap(Session.class);
		Query<Supplier> theQuery= currentSession.createQuery("from Supplier", Supplier.class);
		List<Supplier> list= theQuery.getResultList();
		return list;
	}

	// ITEMS  LIST
	@Transactional
	public List<OrderItemEntity> getAllItems() {
		Session currentSession =  em.unwrap(Session.class);
		Query<OrderItemEntity> theQuery= currentSession.createQuery("from OrderItemEntity", OrderItemEntity.class);
		List<OrderItemEntity> list= theQuery.getResultList();
		return list;
	}

	

	@Transactional
	public void createOrder(int suppId, OrderEntity order) {
		
		Session currentSession =  em.unwrap(Session.class);
		
			OrderEntity oe=new OrderEntity();
			
			oe.setId(order.getId());
			oe.setOrderDate(order.getOrderDate());
			oe.setAmount(order.getAmount());
			oe.setSupplier(order.getSupplier());
			oe.setStatus(order.getStatus());
			
			currentSession.save(oe);
		
		
	}

	@Transactional
	public int updateOrder(int ordId) {
		
		Session currentSession =  em.unwrap(Session.class);
		Query<OrderEntity> theQuery= currentSession.createQuery("update OrderEntity set status =:st where order_id=:id", 
									OrderEntity.class);
		theQuery.setParameter("st", "Close");
		theQuery.setParameter("id",ordId);
		int result=theQuery.executeUpdate();
		return result;
		
	
	}

	@Transactional
	public void saveOrUpdate(OrderItemEntity item) {
		
		Session currentSession =  em.unwrap(Session.class);
		int orderId=item.getItemid();
		
		Query theQuery= currentSession.createQuery("select oe.status from OrderEntity as oe where oe.order_id=: id", OrderEntity.class);
		
		theQuery.setParameter("id",orderId);
		
		String status= (String) theQuery.uniqueResult();
		
		if(status.equalsIgnoreCase("open")) {
			
			currentSession.saveOrUpdate(item);
			
		}
		
		
		
		
	}


	 
	
	

}
