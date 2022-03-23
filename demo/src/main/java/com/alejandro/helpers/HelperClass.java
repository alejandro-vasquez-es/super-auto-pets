package com.alejandro.helpers;

import com.alejandro.mascotas.Mascota;
import com.alejandro.mascotas.tier1.Caballo;
import com.alejandro.mascotas.tier1.Castor;
import com.alejandro.mascotas.tier1.Escarabajo;
import com.alejandro.mascotas.tier1.Grillo;
import com.alejandro.mascotas.tier1.Hormiga;
import com.alejandro.mascotas.tier1.Mosquito;
import com.alejandro.mascotas.tier1.Nutria;
import com.alejandro.mascotas.tier1.Pescado;

public class HelperClass {

	public static void imprimirTextoGuiones(String texto) {

		String guiones = "";
		String[] letras = texto.split("");

		for (int i = 0; i < letras.length; i++) {
			guiones += "-";

		}

		System.out.println(guiones);
		System.out.println(texto);

	}

	public static void imprimirOpciones(String[] opciones) {
		for (String opcion : opciones) {
			System.out.println(opcion);
		}

		System.out.println("Escoge una de las siguientes opciones: ");
	}

	public static Mascota instanciarTipoNombre(String _nombre) {
		switch (_nombre) {
			// TIER 1
			case NombresMascotas.hormiga:
				return new Hormiga();
			case NombresMascotas.pescado:
				return new Pescado();
			case NombresMascotas.mosquito:
				return new Mosquito();
			case NombresMascotas.grillo:
				return new Grillo();
			case NombresMascotas.castor:
				return new Castor();
			case NombresMascotas.caballo:
				return new Caballo();
			case NombresMascotas.nutria:
				return new Nutria();
			case NombresMascotas.escarabajo:
				return new Escarabajo();

			default:
				return new Mascota();
		}
	}

}
