package br.univel.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

@Entity
@Table(name = "cad_animal")
public class Animal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 50)
	private String nome;

	@Column(length = 50)
	private String especie;

	@Column(length = 50)
	private String proprietario;

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object arg0) {
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String Nome) {
		this.nome = Nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String Especie) {
		this.especie = Especie;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String Proprietario) {
		this.proprietario = Proprietario;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nome != null && !nome.trim().isEmpty())
			result += "Nome: " + nome;
		if (especie != null && !especie.trim().isEmpty())
			result += ", Especie: " + especie;
		if (proprietario != null && !proprietario.trim().isEmpty())
			result += ", Proprietario: " + proprietario;
		return result;
	}
}