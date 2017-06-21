package ao.co.framework.framwork.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cliente {
	@Id 
	@GeneratedValue
	private Long id;
	
	private String nome;
	@Column(nullable=false, length=50)
	private String email;
	
	@JoinColumn
	@ManyToOne
	private Provincia provincia;
	
public Cliente(){

}

public Cliente(String nome, String email){
	this.nome = nome;
	this.email = email;
}
	
}
