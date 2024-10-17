package org.trueFanBoutique.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordenes  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id", unique=true, nullable=false)
	private Long id;
	@Column (nullable=false)
	private Long userid;
	@Column (nullable=false)
	private Long productid;
	@Column (nullable=false)
	private String date;
	@Column (nullable=false)
	private Boolean orderStatus;
//	private static Long total = Long.valueOf(0);
	@Column (nullable=false)
	private String direccion;
	
	public Ordenes(String date, String direccion, Boolean orderStatus, Long userid, Long productid) {
	
		this.userid = userid;
		this.productid = productid;
		this.date = date;
		this.orderStatus = orderStatus;
		this.direccion = direccion;
		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Ordenes() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", productid=" + productid + ", date=" + date
				+ ", orderStatus=" + orderStatus + "]";
	}
	
	
	
	
	

}// class Order
