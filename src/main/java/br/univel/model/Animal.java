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
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 50)
	private String Nome;

	@Column(length = 50)
	private String Especie;

	@Column(length = 50)
	private String Proprietario;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Animal)) {
			return false;
		}
		Animal other = (Animal) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getEspecie() {
		return Especie;
	}

	public void setEspecie(String Especie) {
		this.Especie = Especie;
	}

	public String getProprietario() {
		return Proprietario;
	}

	public void setProprietario(String Proprietario) {
		this.Proprietario = Proprietario;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (Nome != null && !Nome.trim().isEmpty())
			result += "Nome: " + Nome;
		if (Especie != null && !Especie.trim().isEmpty())
			result += ", Especie: " + Especie;
		if (Proprietario != null && !Proprietario.trim().isEmpty())
			result += ", Proprietario: " + Proprietario;
		return result;
	}
}