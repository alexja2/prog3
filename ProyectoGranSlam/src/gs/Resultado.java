package gs;

import java.util.List;

public class Resultado extends DatoTabular{

	private int año;
	private String torneo;
	private String campeon;
	private int rankingCampeon;
	private String nacionalidadCampeon;
	private String subCampeon;
	private int rankingSubcampeon;
	private String nacionalidadSubcampeon;
	private String resultado;
	
	public Resultado(int año, String torneo, String campeon, int rankingCampeon,
			String nacionalidadCampeon, String subCampeon, int rankingSubcampeon, String nacionalidadSubcampeon,
			String resultado, List<String> cabeceras) {
		
		super(cabeceras);
		this.año = año;
		this.torneo = torneo;
		this.campeon = campeon;
		this.rankingCampeon = rankingCampeon;
		this.nacionalidadCampeon = nacionalidadCampeon;
		this.subCampeon = subCampeon;
		this.rankingSubcampeon = rankingSubcampeon;
		this.nacionalidadSubcampeon = nacionalidadSubcampeon;
		this.resultado = resultado;
		
		valores.add(año);
		valores.add(torneo);
		valores.add(campeon);
		valores.add(rankingCampeon);
		valores.add(nacionalidadCampeon);
		valores.add(subCampeon);
		valores.add(rankingSubcampeon);
		valores.add(nacionalidadSubcampeon);
		valores.add(resultado);
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getTorneo() {
		return torneo;
	}

	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	public String getCampeon() {
		return campeon;
	}

	public void setCampeon(String campeon) {
		this.campeon = campeon;
	}

	public int getRankingCampeon() {
		return rankingCampeon;
	}

	public void setRankingCampeon(int rankingCampeon) {
		this.rankingCampeon = rankingCampeon;
	}

	public String getNacionalidadCampeon() {
		return nacionalidadCampeon;
	}

	public void setNacionalidadCampeon(String nacionalidadCampeon) {
		this.nacionalidadCampeon = nacionalidadCampeon;
	}

	public String getSubCampeon() {
		return subCampeon;
	}

	public void setSubCampeon(String subCampeon) {
		this.subCampeon = subCampeon;
	}

	public int getRankingSubcampeon() {
		return rankingSubcampeon;
	}

	public void setRankingSubcampeon(int rankingSubcampeon) {
		this.rankingSubcampeon = rankingSubcampeon;
	}

	public String getNacionalidadSubcampeon() {
		return nacionalidadSubcampeon;
	}

	public void setNacionalidadSubcampeon(String nacionalidadSubcampeon) {
		this.nacionalidadSubcampeon = nacionalidadSubcampeon;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


	@Override
	public String toString() {
		return "Resultado [año=" + año + ", torneo=" + torneo + ", campeon=" + campeon + ", rankingCampeon="
				+ rankingCampeon + ", nacionalidadCampeon=" + nacionalidadCampeon + ", subCampeon=" + subCampeon
				+ ", rankingSubcampeon=" + rankingSubcampeon + ", nacionalidadSubcampeon=" + nacionalidadSubcampeon
				+ ", resultado=" + resultado + "]";
	}
	
	
	
	
}
