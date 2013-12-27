package models.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Submotivo extends Model {

	@Id
	public Long id;
	public String codigo;
	public String descripcion;
	public boolean residencial;
	public boolean negocios;
}
