package models.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("USUARIO")
public class Usuario extends Model {

	@Id
	public String email;
	public String password;
	public boolean inhabilitado = false;
	public int dni;
	public String nombre;
	public String apellido;
	public Sexo sexo;

	public static Finder<String, Usuario> find = new Finder<String, Usuario>(
			String.class, Usuario.class);

	public static Usuario authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password)
				.findUnique();
	}	

}
