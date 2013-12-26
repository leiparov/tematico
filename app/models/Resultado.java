package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Resultado extends Model {

	@Id
	public Long id;				//1=CEF 2=CNE 3=NOC 4=NOG
	public String codigo;		//CEF, CNE, NOC, NOG
	public String descripcion;	//contacto efectivo, ...
	
	@OneToMany(cascade = CascadeType.PERSIST)
	public List<Motivo> motivos = new ArrayList<Motivo>();

}
