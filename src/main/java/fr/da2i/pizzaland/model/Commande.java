package fr.da2i.pizzaland.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date dat;

	private String login;

	//bi-directional many-to-many association to Pizza
	@ManyToMany(mappedBy="commandes")
	private List<Pizza> pizzas;

	public Commande() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDat() {
		return this.dat;
	}

	public void setDat(Date dat) {
		this.dat = dat;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public List<Pizza> getPizzas() {
		return this.pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

}