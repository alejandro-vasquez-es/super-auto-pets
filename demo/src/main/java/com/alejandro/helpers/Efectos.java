package com.alejandro.helpers;

public class Efectos {

	final public static String debil = "debil";
	final public static String armaduraMelon = "armaduraMelon";
	final public static String armaduraAjo = "armaduraAjo";
	final public static String ataqueDeHueso = "ataqueDeHueso";
	final public static String ataqueDemoledor = "ataqueDemoledor";
	final public static String ataqueDeCarne = "ataqueDeCarne";
	final public static String mieldeAbeja = "mieldeAbeja";
	final public static String vidaExtra = "vidaExtra";
	final public static String escudoDeCoco = "escudoDeCoco";

	final private static String[] efectos = new String[] {
			debil, armaduraMelon
	};

	// public static boolean tieneEfecto(String _efecto) {
	// for (String efecto : efectos) {
	// if (_efecto == efecto) {
	// return true;
	// }
	// }
	// return false;
	// }

	public static boolean tieneEfecto(String[] _efectos, String _efecto) {
		int totalEfectos = 0;
		for (int i = 0; i < _efectos.length; i++) {
			if (_efectos[i] != null) {
				totalEfectos++;
			}
		}

		for (int i = 0; i < totalEfectos; i++) {
			if (_efecto == _efectos[i]) {
				return true;
			}
		}

		return false;
	}

}
