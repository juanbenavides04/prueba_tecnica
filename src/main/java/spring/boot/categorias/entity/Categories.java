package spring.boot.categorias.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categories")
public class Categories implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	

	private String name;
	
	private Long relevance;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  SubcategoryLevel2 subcategorylevel2;

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRelevance() {
		return relevance;
	}
	public void setRelevance(Long relevance) {
		this.relevance = relevance;
	}
	public SubcategoryLevel2 getSubcategorylevel2() {
		return subcategorylevel2;
	}
	public void setSubcategorylevel2(SubcategoryLevel2 subcategorylevel2) {
		this.subcategorylevel2 = subcategorylevel2;
	}
	
	
	

}
