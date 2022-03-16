package com.productservice.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="productservice")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class ProductService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@Column(name="productname")
	private String productname; 

	@Column(name="productdescription")
	private String productdescription; 

	@Column(name="productprice")
	private int productprice ;

	@Column(name ="productcompany")
	private String productcompany;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductcompany() {
		return productcompany;
	}

	public void setProductcompany(String productcompany) {
		this.productcompany = productcompany;
	}

}
