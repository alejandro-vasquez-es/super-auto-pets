package com.alejandro.helpers;

public class NombresMascotas {
	final public static String hormiga = "hormiga";
	final public static String pescado = "pescado";
	final public static String mosquito = "mosquito";
	final public static String grillo = "grillo";
	final public static String castor = "castor";
	final public static String caballo = "caballo";
	final public static String nutria = "nutria";
	final public static String escarabajo = "escarabajo";
	final public static String sapo = "sapo";
	final public static String dodo = "dodo";
	final public static String elefante = "elefante";
	final public static String puercoespin = "puercoespin";
	final public static String pavorreal = "pavorreal";
	final public static String rata = "rata";
	final public static String zorro = "zorro";
	final public static String arana = "arana";
	final public static String dirtyRat = "dirtyRat";
	final public static String camello = "camello";
	final public static String mapache = "mapache";
	final public static String jirafa = "jirafa";
	final public static String tortuga = "tortuga";
	final public static String caracol = "caracol";
	final public static String oveja = "oveja";
	final public static String conejo = "conejo";
	final public static String lobo = "lobo";
	final public static String buey = "Buey";
	final public static String canguro = "canguro";
	final public static String buho = "buho";

	public static String[] tier1 = {
			hormiga, pescado, mosquito, grillo, castor, caballo, nutria, escarabajo
	};
	public static String[] tier2 = {
			hormiga, pescado, mosquito, grillo, castor, caballo, nutria, escarabajo,
			sapo, dodo, elefante, puercoespin, pavorreal, rata, zorro, arana,
	};
	public static String[] tier3 = {
			// hormiga, pescado, mosquito, grillo, castor, caballo, nutria, escarabajo,
			// sapo, dodo, elefante, puercoespin, pavorreal, rata, zorro, arana,
			// camello,
			// mapache,
			// jirafa,
			// tortuga,
			// caracol,
			// oveja,
			// conejo,
			lobo,
			buey,
			canguro,
			buho,
	};

	public static String[] tierSolo3 = {
			camello,
			mapache,
			jirafa,
			tortuga,
			caracol,
			oveja,
			conejo,
			lobo,
			buey,
			canguro,
			buho,

	};

	public static String obtenerMascotaAleatoria(int _tier) {

		if (_tier == 1) {
			int randomNumber = (int) Math.floor(Math.random() * (tier1.length - 1 + 1) + 1);
			return tier1[randomNumber - 1];
		}
		if (_tier == 2) {
			int randomNumber = (int) Math.floor(Math.random() * (tier2.length - 1 + 1) + 1);
			return tier2[randomNumber - 1];
		}
		if (_tier == 3) {
			int randomNumber = (int) Math.floor(Math.random() * (tier3.length - 1 + 1) + 1);
			return tier3[randomNumber - 1];
		}
		if (_tier == 100) {
			int randomNumber = (int) Math.floor(Math.random() * (tierSolo3.length - 1 + 1) + 1);
			return tierSolo3[randomNumber - 1];
		}
		return "";

	}

}
