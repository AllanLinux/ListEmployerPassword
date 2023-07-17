package br.com.allanlf.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Colaborador")
public class Colaborador implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
	
	@Column(name = "Nome")
	@NotBlank(message = "Campo nome não pode ser vazio")
	private String nome;
	
	@Column(name = "Senha")
	@NotBlank(message = "Campo senha não pode ser vazio")
	private String senha;
	
	@Column(name = "Score")
	private int score;
	
	@ManyToOne
	@JoinColumn(name = "Id_Chefe")
	private Colaborador chefe;
	
	@Transient // Este campo não será persistido
    private Long chefeId;
	
	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Colaborador getChefe() {
		return chefe;
	}

	public void setChefe(Colaborador chefe) {
		this.chefe = chefe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Long getChefeId() {
		return chefeId;
	}
	
	public void setChefeId(Long chefeId) {
		this.chefeId = chefeId;
	}
	
}
