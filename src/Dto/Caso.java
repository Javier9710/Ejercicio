package Dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caso")
public class Caso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tipoCaso;
	private String info;
	private String importancia;
	private String fecha;

	// abogado
	@ManyToOne
	@JoinColumn(name="abogado")
	private Abogado abogado;

	// info cliente
	private String nombreCaso;
	private String nombreC;
	private String cedulaC;
	private String correoC;
	private String telC;

	public Caso() {

	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(String tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}

	public Abogado getAbogado() {
		return abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public String getNombreCaso() {
		return nombreCaso;
	}

	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getCedulaC() {
		return cedulaC;
	}

	public void setCedulaC(String cedulaC) {
		this.cedulaC = cedulaC;
	}

	public String getCorreoC() {
		return correoC;
	}

	public void setCorreoC(String correoC) {
		this.correoC = correoC;
	}

	public String getTelC() {
		return telC;
	}

	public void setTelC(String telC) {
		this.telC = telC;
	}

}
