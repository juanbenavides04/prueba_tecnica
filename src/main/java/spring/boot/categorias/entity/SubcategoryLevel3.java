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
@Table(name="subcategorylevel3")
public class SubcategoryLevel3 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	private String name;
	private Long relevance;
	private String largeImageUrl;	
	private String mediumImageUrl;	
	private String smallImageUrl;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  SubcategoryLevel4 subcategoryLevel4;
	
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
	public String getLargeImageUrl() {
		return largeImageUrl;
	}
	public void setLargeImageUrl(String largeImageUrl) {
		this.largeImageUrl = largeImageUrl;
	}
	public String getMediumImageUrl() {
		return mediumImageUrl;
	}
	public void setMediumImageUrl(String mediumImageUrl) {
		this.mediumImageUrl = mediumImageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public SubcategoryLevel4 getSubcategoryLevel4() {
		return subcategoryLevel4;
	}
	public void setSubcategoryLevel4(SubcategoryLevel4 subcategoryLevel4) {
		this.subcategoryLevel4 = subcategoryLevel4;
	}
	
	

}
