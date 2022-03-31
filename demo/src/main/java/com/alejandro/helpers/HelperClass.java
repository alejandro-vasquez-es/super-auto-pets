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
import com.alejandro.mascotas.tier2.Arana;
import com.alejandro.mascotas.tier2.Dodo;
import com.alejandro.mascotas.tier2.Elefante;
import com.alejandro.mascotas.tier2.Pavorreal;
import com.alejandro.mascotas.tier2.Puercoespin;
import com.alejandro.mascotas.tier2.Rata;
import com.alejandro.mascotas.tier2.Sapo;
import com.alejandro.mascotas.tier2.Zorro;
import com.alejandro.mascotas.tier3.Buey;
import com.alejandro.mascotas.tier3.Buho;
import com.alejandro.mascotas.tier3.Camello;
import com.alejandro.mascotas.tier3.Canguro;
import com.alejandro.mascotas.tier3.Caracol;
import com.alejandro.mascotas.tier3.Conejo;
import com.alejandro.mascotas.tier3.Jirafa;
import com.alejandro.mascotas.tier3.Lobo;
import com.alejandro.mascotas.tier3.Mapache;
import com.alejandro.mascotas.tier3.Oveja;
import com.alejandro.mascotas.tier3.Tortuga;

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

	public static Mascota instanciarTipoNombre(String _nombre, Mascota[] _aliados, Mascota[] _enemigos) {
		switch (_nombre) {
			// TIER 1
			case NombresMascotas.hormiga:
				return new Hormiga(_aliados, _enemigos);
			case NombresMascotas.pescado:
				return new Pescado(_aliados, _enemigos);
			case NombresMascotas.mosquito:
				return new Mosquito(_aliados, _enemigos);
			case NombresMascotas.grillo:
				return new Grillo(_aliados, _enemigos);
			case NombresMascotas.castor:
				return new Castor(_aliados, _enemigos);
			case NombresMascotas.caballo:
				return new Caballo(_aliados, _enemigos);
			case NombresMascotas.nutria:
				return new Nutria(_aliados, _enemigos);
			case NombresMascotas.escarabajo:
				return new Escarabajo(_aliados, _enemigos);

			// TIER 2
			case NombresMascotas.sapo:
				return new Sapo(_aliados, _enemigos);
			case NombresMascotas.dodo:
				return new Dodo(_aliados, _enemigos);
			case NombresMascotas.elefante:
				return new Elefante(_aliados, _enemigos);
			case NombresMascotas.puercoespin:
				return new Puercoespin(_aliados, _enemigos);
			case NombresMascotas.pavorreal:
				return new Pavorreal(_aliados, _enemigos);
			case NombresMascotas.rata:
				return new Rata(_aliados, _enemigos);
			case NombresMascotas.zorro:
				return new Zorro(_aliados, _enemigos);
			case NombresMascotas.arana:
				return new Arana(_aliados, _enemigos);

			// TIER 3
			case NombresMascotas.camello:
				return new Camello(_aliados, _enemigos);
			case NombresMascotas.mapache:
				return new Mapache(_aliados, _enemigos);
			case NombresMascotas.jirafa:
				return new Jirafa(_aliados, _enemigos);
			case NombresMascotas.tortuga:
				return new Tortuga(_aliados, _enemigos);
			case NombresMascotas.caracol:
				return new Caracol(_aliados, _enemigos);
			case NombresMascotas.oveja:
				return new Oveja(_aliados, _enemigos);
			case NombresMascotas.conejo:
				return new Conejo(_aliados, _enemigos);
			case NombresMascotas.lobo:
				return new Lobo(_aliados, _enemigos);
			case NombresMascotas.buey:
				return new Buey(_aliados, _enemigos);
			case NombresMascotas.canguro:
				return new Canguro(_aliados, _enemigos);
			case NombresMascotas.buho:
				return new Buho(_aliados, _enemigos);

			default:
				return new Mascota(_aliados, _enemigos);
		}
	}

	public static void imprimirMascotas(Mascota[] mascotas) {
		for (Mascota mascota : mascotas) {
			System.out.println(mascota);
		}
	}

	public static int totalMascotas(Mascota[] mascotas) {
		int totalMascotas = 0;
		for (int i = 0; i < mascotas.length; i++) {
			if (mascotas[i] != null) {
				totalMascotas++;
			}
		}
		return totalMascotas;
	}

	public static int obtenerIndiceMascota(Mascota _mascota, Mascota[] _aliados) {
		int totalMascotas = totalMascotas(_aliados);
		for (int i = 0; i < totalMascotas; i++) {
			Mascota mascota = _aliados[i];
			if (mascota.equals(_mascota)) {
				return i;
			}
		}
		return -1;
	}

	public static Mascota obtenerMascotaAleatoria(Mascota[] mascotas, int totalMascotas) {
		int randomNumber = (int) Math.floor(Math.random() * (totalMascotas - 1 + 1) + 1);
		return mascotas[randomNumber - 1];
	}

	public static boolean mascotaExiste(Mascota _mascota, Mascota[] _mascotas) {

		int totalMascotas = totalMascotas(_mascotas);

		for (int i = 0; i < totalMascotas; i++) {
			Mascota mascota = _mascotas[i];
			if (mascota.equals(_mascota)) {
				return true;
			}
		}

		return false;
	}

}
