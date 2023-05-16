package fr.da2i.pizzaland.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the ingredient database table.
 * 
 */
@Entity
@NamedQuery(name="Ingredient.findAll", query="SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nom;

	private Integer prix;

	//bi-directional many-to-many association to Pizza
	@ManyToMany(mappedBy="ingredients")
	private List<Pizza> pizzas;

	public Ingredient() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPrix() {
		return this.prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	@JsonIgnore
	public List<Pizza> getPizzas() {
		return this.pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}