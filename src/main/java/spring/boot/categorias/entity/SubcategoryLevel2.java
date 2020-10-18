package spring.boot.categorias.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="subcategorylevel2")
public class SubcategoryLevel2 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	private String name;	
	private Long relevance;	
	private String iconImageUrl;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  SubcategoryLevel3 subcategoryLevel3;
	
	
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
	public String getIconImageUrl() {
		return iconImageUrl;
	}
	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}
	public SubcategoryLevel3 getSubcategoryLevel3() {
		return subcategoryLevel3;
	}
	public void setSubcategoryLevel3(SubcategoryLevel3 subcategoryLevel3) {
		this.subcategoryLevel3 = subcategoryLevel3;
	}
	
	
	
	
}
