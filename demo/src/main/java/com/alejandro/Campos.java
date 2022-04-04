package com.alejandro;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.jugador.Jugador;
import com.alejandro.mascotas.Mascota;

public class Campos {

	final public static String pantano = "pantano";
	final public static String nubes = "nubes";
	final public static String mar = "mar";
	final public static String bosque = "bosque";
	final public static String granja = "granja";
	final public static String sabana = "sabana";
	final public static String sinCampo = "sin campo";

	final public static String[] campos = new String[] {
			pantano,
			nubes,
			mar,
			bosque,
			granja,
			sabana,
			sinCampo,
	};

	public static void seleccionarCampo(Jugador _jugador, Jugador _oponente) {
		String[] opciones = new String[campos.length];
		for (int i = 0; i < campos.length; i++) {
			opciones[i] = (i + 1) + "- " + campos[i];
		}
		HelperClass.imprimirTextoGuiones("Antes de la batalla, por favor elige un campo en el cual batallar.");

		Menu menu = new Menu(opciones);
		int opcion = menu.getOpcion();

		efectoCampo(campos[opcion - 1], _jugador, _oponente);

	}

	public static void ejecutarBuff(Jugador _jugador, Jugador _oponente, String _tipo, int _vidaExtra,
			int _ataqueExtra) {

		Mascota[] mascotasTipo = obtenerMascotasTipo(_jugador, _oponente, _tipo);

		// Aumentar stats
		for (Mascota mascota : mascotasTipo) {
			mascota.aumentarEstadisticas(mascotasTipo.length * _vidaExtra, mascotasTipo.length * _ataqueExtra);
		}

	}

	public static Mascota[] obtenerMascotasTipo(Jugador _jugador, Jugador _oponente, String _tipo) {
		// obtener los animales con tipo reptil
		int totalMascotasTipo = 0;

		// Encuentra el total de mascotas tipo reptil
		for (Mascota mascota : _jugador.mascotas) {
			if (mascota != null) {
				for (String tipo : mascota.tipos) {
					if (tipo == _tipo) {
						totalMascotasTipo++;
						break;
					}
				}
			}
		}
		for (Mascota mascota : _oponente.mascotas) {
			if (mascota != null) {
				for (String tipo : mascota.tipos) {
					if (tipo == _tipo) {
						totalMascotasTipo++;
						break;
					}
				}
			}
		}

		int indiceMascotasTipo = 0;
		Mascota[] mascotasTipo = new Mascota[totalMascotasTipo];
		// Añadir esas mascotas al array
		for (Mascota mascota : _jugador.mascotas) {
			if (mascota != null) {
				for (String tipo : mascota.tipos) {
					if (tipo == _tipo) {
						mascotasTipo[indiceMascotasTipo] = mascota;
						indiceMascotasTipo++;
						break;
					}
				}
			}
		}
		for (Mascota mascota : _oponente.mascotas) {
			if (mascota != null) {
				for (String tipo : mascota.tipos) {
					if (tipo == _tipo) {
						mascotasTipo[indiceMascotasTipo] = mascota;
						indiceMascotasTipo++;
						break;
					}
				}
			}
		}
		return mascotasTipo;
	}

	public static void nerfearSolitario(Jugador _jugador, Jugador _oponente) {

		Mascota[] mascotasSolitarias = obtenerMascotasTipo(_jugador, _oponente, NombresTipos.solitario);

		for (Mascota mascota : mascotasSolitarias) {
			mascota.setAtaque(mascota.getAtaque() - mascota.getAtaque() * .2);
		}

	}

	public static void buffDesertico(Jugador _jugador, Jugador _oponente) {
		Mascota[] mascotasDeserticas = obtenerMascotasTipo(_jugador, _oponente, NombresTipos.desertico);

		for (Mascota mascota : mascotasDeserticas) {
			mascota.aumentarEstadisticas((mascota.indiceComidas) * 1, (mascota.indiceComidas) * 0);
		}

	}

	public static void efectoCampo(String _campo, Jugador _jugador, Jugador _oponente) {
		switch (_campo) {
			case pantano:
				ejecutarBuff(_jugador, _oponente, NombresTipos.reptil, 1, 1);
				break;
			case nubes:
				ejecutarBuff(_jugador, _oponente, NombresTipos.volador, 1, 1);
				break;
			case mar:
				ejecutarBuff(_jugador, _oponente, NombresTipos.acuatico, 1, 1);
				break;

			case bosque:
				ejecutarBuff(_jugador, _oponente, NombresTipos.terrestre, 0, 2);
				ejecutarBuff(_jugador, _oponente, NombresTipos.mamifero, 2, 0);
				nerfearSolitario(_jugador, _oponente);
				break;

			case granja:
				ejecutarBuff(_jugador, _oponente, NombresTipos.domestico, 1, 1);
				nerfearSolitario(_jugador, _oponente);
				break;

			case sinCampo:
				if (obtenerMascotasTipo(_jugador, _oponente, NombresTipos.solitario).length == 1)
					ejecutarBuff(_jugador, _oponente, NombresTipos.solitario, 3, 3);
				break;

			case sabana:
				buffDesertico(_jugador, _oponente);
				break;

			default:
				break;
		}
	}

}
