package models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Campana extends Model{
	
	@Id
	public String codigo;
	public String descripcion;
	public String familia;
	public String proveedor;
	
	@ManyToMany(cascade = CascadeType.REMOVE)
	public List<Motivo> motivos = new ArrayList<Motivo>();
	
}
