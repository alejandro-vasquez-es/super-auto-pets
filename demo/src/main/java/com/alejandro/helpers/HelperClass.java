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

}
