package tn.poste.client.data.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Entity
@Data
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 45)
	private String ordersCol;
	
	@Min(0)
	@Max(9)
	private int status;
	
	private double price;
	
	private LocalDateTime creationTime;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private OrderType orderType;
	
	

}
