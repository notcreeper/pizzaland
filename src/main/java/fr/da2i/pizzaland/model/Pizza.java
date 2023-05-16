package fr.da2i.pizzaland.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the pizza database table.
 * 
 */
@Entity
@NamedQuery(name="Pizza.findAll", query="SELECT p FROM Pizza p")
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nom;

	private Integer prix;


	//bi-directional many-to-many association to Ingredient
	@ManyToMany
	@JoinTable(
		name="contient"
		, joinColumns={
			@JoinColumn(name="idpizza")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idingredient")
			}
		)
	private List<Ingredient> ingredients;

	//bi-directional many-to-many association to Commande
	@ManyToMany
	@JoinTable(
		name="livre"
		, joinColumns={
			@JoinColumn(name="idpizza")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcommande")
			}
		)
	private List<Commande> commandes;

	public Pizza() {
	}

	public Pizza(Integer id, String nom, Integer prix) {
		this.id=id;
		this.nom=nom;
		this.prix=prix;
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

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@JsonIgnore
	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

}