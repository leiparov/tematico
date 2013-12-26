package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Motivo extends Model{

	@Id
	public Long id;					//1,2,3,4,...
	public String codigo;			//201, 202, ... depende del RESULTADO(1,2,3,4)
	public String descripcion;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	public List<Submotivo> submotivos = new ArrayList<Submotivo>();
	
}
