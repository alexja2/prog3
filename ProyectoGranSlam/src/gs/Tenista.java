package gs;

import java.util.HashMap;
import java.util.List;

/*deportistas que ganan o son finalistas de GS*/

public class Tenista extends DatoTabular{

	private String nombre;
	private String nacionalidad;
	private int ranking;
	private int victorias;
	private HashMap<Torneo, Integer> victoriasPorTorneo;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getVictorias() {
		return victorias;
	}
	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}
	public HashMap<Torneo, Integer> getVictoriasPorTorneo() {
		return victoriasPorTorneo;
	}
	public void setVictoriasPorTorneo(HashMap<Torneo, Integer> victoriasPorTorneo) {
		this.victoriasPorTorneo = victoriasPorTorneo;
	}
	
	public Tenista(String nombre, String nacionalidad, int ranking, int victorias,
			HashMap<Torneo, Integer> victoriasPorTorneo, List<String> cabeceras) {
		super(cabeceras);
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.ranking = ranking;
		this.victorias = victorias;
		this.victoriasPorTorneo = victoriasPorTorneo;
		
		//añadir valores especificos de tenista a la lista valores (???)	
		valores.add(nombre);
		valores.add(nacionalidad);
		valores.add(ranking);
		valores.add(victorias);
		valores.add(victoriasPorTorneo);
	}
	
	public Tenista(String nombre, String nacionalidad, List<String> cabeceras) {
		super(cabeceras);
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	
	@Override
	public String toString() {
		return "Tenista [nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", ranking=" + ranking + ", victorias="
				+ victorias + ", victoriasPorTorneo=" + victoriasPorTorneo + "]";
	}
	
	
	
	
	
	
}
