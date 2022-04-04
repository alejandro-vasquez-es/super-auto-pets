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
import com.alejandro.mascotas.tier4.Ardilla;
import com.alejandro.mascotas.tier4.Ballena;
import com.alejandro.mascotas.tier4.Delfin;
import com.alejandro.mascotas.tier4.Hipopotamo;
import com.alejandro.mascotas.tier4.Llama;
import com.alejandro.mascotas.tier4.Loro;
import com.alejandro.mascotas.tier4.Puma;
import com.alejandro.mascotas.tier4.Venado;
import com.alejandro.mascotas.tier5.Chompipe;
import com.alejandro.mascotas.tier5.Cocodrilo;
import com.alejandro.mascotas.tier5.Escorpion;
import com.alejandro.mascotas.tier5.Foca;
import com.alejandro.mascotas.tier5.Jaguar;
import com.alejandro.mascotas.tier5.Mono;
import com.alejandro.mascotas.tier5.Rinoceronte;
import com.alejandro.mascotas.tier5.Vaca;
import com.alejandro.mascotas.tier6.Gato;
import com.alejandro.mascotas.tier6.Gorila;
import com.alejandro.mascotas.tier6.Leopardo;
import com.alejandro.mascotas.tier6.Mamut;
import com.alejandro.mascotas.tier6.Mosca;
import com.alejandro.mascotas.tier6.Panda;
import com.alejandro.mascotas.tier6.Pulpo;
import com.alejandro.mascotas.tier6.Serpiente;
import com.alejandro.mascotas.tier6.Tigre;
import com.alejandro.mascotas.tier7.Camaleon;
import com.alejandro.mascotas.tier7.Quetzal;

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

			// TIER 4
			case NombresMascotas.venado:
				return new Venado(_aliados, _enemigos);
			case NombresMascotas.loro:
				return new Loro(_aliados, _enemigos);
			case NombresMascotas.hipopotamo:
				return new Hipopotamo(_aliados, _enemigos);
			case NombresMascotas.delfin:
				return new Delfin(_aliados, _enemigos);
			case NombresMascotas.puma:
				return new Puma(_aliados, _enemigos);
			case NombresMascotas.ballena:
				return new Ballena(_aliados, _enemigos);
			case NombresMascotas.ardilla:
				return new Ardilla(_aliados, _enemigos);
			case NombresMascotas.llama:
				return new Llama(_aliados, _enemigos);

			// TIER 5
			case NombresMascotas.foca:
				return new Foca(_aliados, _enemigos);
			case NombresMascotas.jaguar:
				return new Jaguar(_aliados, _enemigos);
			case NombresMascotas.escorpion:
				return new Escorpion(_aliados, _enemigos);
			case NombresMascotas.rinoceronte:
				return new Rinoceronte(_aliados, _enemigos);
			case NombresMascotas.mono:
				return new Mono(_aliados, _enemigos);
			case NombresMascotas.cocodrilo:
				return new Cocodrilo(_aliados, _enemigos);
			case NombresMascotas.vaca:
				return new Vaca(_aliados, _enemigos);
			case NombresMascotas.chompipe:
				return new Chompipe(_aliados, _enemigos);

			// TIER 6
			case NombresMascotas.panda:
				return new Panda(_aliados, _enemigos);
			case NombresMascotas.gato:
				return new Gato(_aliados, _enemigos);
			case NombresMascotas.tigre:
				return new Tigre(_aliados, _enemigos);
			case NombresMascotas.serpiente:
				return new Serpiente(_aliados, _enemigos);
			case NombresMascotas.mamut:
				return new Mamut(_aliados, _enemigos);
			case NombresMascotas.leopardo:
				return new Leopardo(_aliados, _enemigos);
			case NombresMascotas.gorila:
				return new Gorila(_aliados, _enemigos);
			case NombresMascotas.pulpo:
				return new Pulpo(_aliados, _enemigos);
			case NombresMascotas.mosca:
				return new Mosca(_aliados, _enemigos);

			// TIER 7
			case NombresMascotas.quetzal:
				return new Quetzal(_aliados, _enemigos);
			case NombresMascotas.camaleon:
				return new Camaleon(_aliados, _enemigos);

			default:
				return new Mascota(_aliados, _enemigos);

		}
	}

	public static void imprimirMascotas(Mascota[] mascotas) {
		for (int i = 0; i < totalMascotas(mascotas); i++) {
			System.out.println(
					"mascota de la clase " + mascotas[i].nombre + " con un total de " + mascotas[i].totalDanoCausado
							+ " de dano causado y un total de  " + mascotas[i].totalDanoRecibido + " de dano recibido");
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
