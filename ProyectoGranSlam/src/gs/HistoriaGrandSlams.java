package gs;

import java.util.HashMap;
import java.util.List;

public class HistoriaGrandSlams {

	private List<Resultado> resultados;
	private HashMap<String, Torneo> torneosPorNombre;
	private HashMap<String, Torneo> torneosPorCodigo;
	private HashMap<String, Tenista> tenistasPorNombre;
	
	public HistoriaGrandSlams(List<Tenista> tenistas, List<Torneo> torneos, List<Resultado> resultados) {
		super();
		this.resultados = resultados;
		this.torneosPorNombre = new HashMap<>();
		this.torneosPorCodigo = new HashMap<>();
		this.tenistasPorNombre = new HashMap<>();
		
		
		//Logica para rellenar los hashmaps con la info de las listas
		for(Torneo t : torneos) {
			this.torneosPorNombre.put(t.getNombre(), t);
			this.torneosPorCodigo.put(t.getCodigo(), t);
		}
		for(Tenista t: tenistas) {
			this.tenistasPorNombre.put(t.getNombre(), t);
		}
	
	}
	
	//CALCULA NUMERO DE VICTORIAS (Tiene que ser el ganador)
	public int calculaClasificacion(String nombreJugador, int añoInicial, int añoFinal) {
		int nVictorias = 0;
		
		for(Resultado resultado : resultados) {
			int año = resultado.getAño();
			if(año>=añoInicial && año<=añoFinal && resultado.getCampeon().equals(nombreJugador)) {
				nVictorias++;
			}
		}
		
		return nVictorias;
	}
	
	
	
}
