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
	final public static String puerco = "puerco";
	final public static String pavorreal = "pavorreal";
	final public static String rata = "rata";
	final public static String zorro = "zorro";
	final public static String arana = "arana";

	public static String[] tier1 = {
			hormiga, pescado, mosquito, grillo, castor, caballo, nutria, escarabajo
	};
	public static String[] tier2 = {
			hormiga, pescado, mosquito, grillo, castor, caballo, nutria, escarabajo, sapo, dodo, elefante, puerco,
			puerco, pavorreal, rata, zorro, arana
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
		return "";

	}

}
