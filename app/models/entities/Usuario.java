package models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import play.data.validation.Constraints;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("USUARIO")
public class Usuario {

	@Id
	private int dni;
	@Constraints.Required
	private String email;
	@SuppressWarnings("unused")
	private String password;
	private boolean inhabilitado = false;
	private boolean foto = false;
	private String nombre;
	private String apellido;
	private Sexo sexo;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isInhabilitado() {
		return inhabilitado;
	}

	public void setInhabilitado(boolean inhabilitado) {
		this.inhabilitado = inhabilitado;
	}

	public boolean isFoto() {
		return foto;
	}

	public void setFoto(boolean foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
