package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "params", catalog = "projet_ecommerce_db")
public class Params implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@NotNull
	@Column(name = "cle_cryptage", nullable = false)
	private byte[] cleCryptage;
	
	public Params() {
	}

	public Params(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getCleCryptage() {
		return cleCryptage;
	}

	public void setCleCryptage(byte[] cleCryptage) {
		this.cleCryptage = cleCryptage;
	}

	@Override
	public String toString() {
		return "Params [id=" + id + ", cleCryptage=" + Arrays.toString(cleCryptage) + "]";
	}
}
