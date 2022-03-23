package com.alejandro;

import java.util.Arrays;

import com.alejandro.helpers.Comidas;
import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.jugador.Jugador;
import com.alejandro.jugador.JugadorReal;
import com.alejandro.mascotas.Mascota;

public class Tienda {

	public String[] mascotas;
	public String[] comidas;
	public int tier = 0;

	public Tienda() {
		mascotas = new String[NombresMascotas.tier1.length];
		actualizarTier();
		rellenarMascotas();

	}

	public void actualizarTier() {
		tier++;
		actualizarComidas();
	}

	public void rellenarMascotas() {
		for (int i = 0; i < mascotas.length; i++) {
			String nuevoNombre = NombresMascotas.obtenerMascotaAleatoria(tier);
			while (existeMascota(nuevoNombre)) {
				nuevoNombre = NombresMascotas.obtenerMascotaAleatoria(tier);
			}
			mascotas[i] = nuevoNombre;
		}
	}

	public void actualizarComidas() {
		switch (tier) {
			case 1:
				comidas = Comidas.tier1.clone();
				break;
			case 2:
				comidas = Comidas.tier2.clone();
				break;
			case 3:
				comidas = Comidas.tier3.clone();
				break;
			case 4:
				comidas = Comidas.tier4.clone();
				break;
			case 5:
				comidas = Comidas.tier5.clone();
				break;
			case 6:
				comidas = Comidas.tier6.clone();
				break;
			case 7:
				comidas = Comidas.tier7.clone();
				break;

			default:
				break;
		}
	}

	public boolean existeMascota(String _mascota) {
		for (String mascota : mascotas) {
			if (mascota == _mascota) {
				return true;
			}
		}
		return false;
	}

	public void setTier(int _tier) {

		tier = _tier;

	}

	public boolean serEvolucionada(int _tier) {
		return true;
	}

	public void evolucionar(int _tier) {

	}

	public void comprarMascotas(Jugador _jugador) {
		HelperClass.imprimirTextoGuiones("Bienvenido a la tienda de Super Auto Pets");
		System.out.println("Estas en la sección de comprar mascotas");

		String[] opciones = new String[mascotas.length + 1];
		for (int i = 0; i < mascotas.length; i++) {
			opciones[i] = (i + 1) + "- " + mascotas[i];
		}
		opciones[opciones.length - 1] = (mascotas.length + 1) + "- regresar";

		Menu menuComprarMascota = new Menu(opciones);
		int opcion = menuComprarMascota.getOpcion();
		if (_jugador.oro < 3) {
			System.out.println("No tienes el oro suficiente para comprar una mascota");
		} else if (opcion != opciones.length) {
			((JugadorReal) _jugador).comprarMascota(mascotas[opcion - 1]);
		}

	}

	public void comprarComida(Jugador _jugador) {

		HelperClass.imprimirTextoGuiones("Bienvenido a la tienda de Super Auto Pets");
		System.out.println("Estas en la sección de comprar comida");

		String[] opciones = new String[comidas.length + 1];
		for (int i = 0; i < comidas.length; i++) {
			opciones[i] = (i + 1) + "- " + comidas[i];
		}
		opciones[opciones.length - 1] = (comidas.length + 1) + "- regresar";

		Menu menu = new Menu(opciones);
		int opcion = menu.getOpcion();
		if (opcion != opciones.length) {
			if (_jugador.oro < 3) {
				System.out.println("No tienes el oro suficiente para comprar comida");
			} else {

				if (_jugador.totalMascotas != 0) {
					String[] opcionesMascotas = new String[_jugador.totalMascotas + 1];
					for (int i = 0; i < (opcionesMascotas.length - 1); i++) {
						opcionesMascotas[i] = (i + 1) + "- " + _jugador.mascotas[i].nombre;
					}
					opcionesMascotas[opcionesMascotas.length - 1] = (opcionesMascotas.length) + "- cancelar compra";

					System.out.println("¿A cual de tus mascotas deseas dar la comida?");
					Menu menuMascotas = new Menu(opcionesMascotas);
					int opcionMascota = menuMascotas.getOpcion();

					if (opcionMascota != opcionesMascotas.length) {
						_jugador.oro -= 3; // le resta al _jugador el precio de la comida
						_jugador.mascotas[opcionMascota - 1].comer(comidas[opcion - 1]);
						System.out.println("Ahora pasas a tener " + _jugador.oro + " de oro");
					}

				} else {
					System.out.println(
							"Aun no tienes mascotas para alimentar, puedes comprar en las acciones entre batallas.");
				}

			}
		}

	}

	public void fusionarMascota(Jugador _jugador) {

		// Encuentra cuantas mascotas del jugador tienen nivel para evolucionar
		int totalNombresMascotasJugador = 0;
		for (int i = 0; i < _jugador.totalMascotas; i++) {
			if (_jugador.mascotas[i].nivel < 3) {
				totalNombresMascotasJugador++;
			}
		}

		// Rellena los nombres de las mascotas que pueden ser evolucionadas
		int indiceNombresMascotasJugador = 0;
		String[] nombresMascotasJugador = new String[totalNombresMascotasJugador];
		for (int i = 0; i < _jugador.totalMascotas; i++) {
			if (_jugador.mascotas[i].nivel < 3) {
				nombresMascotasJugador[indiceNombresMascotasJugador] = _jugador.mascotas[i].nombre;
				indiceNombresMascotasJugador++;
			}
		}

		int totalMascotasFusionables = 0;
		for (int i = 0; i < nombresMascotasJugador.length; i++) {
			boolean seIncluye = false;
			for (int j = 0; j < mascotas.length; j++) {
				if (nombresMascotasJugador[i] == mascotas[j]) {
					seIncluye = true;
					break;
				}
			}
			if (seIncluye)
				totalMascotasFusionables++;
		}

		int indiceMascotasFusionables = 0;
		String[] mascotasFusionables = new String[totalMascotasFusionables];
		for (int i = 0; i < nombresMascotasJugador.length; i++) {
			for (int j = 0; j < mascotas.length; j++) {
				if (nombresMascotasJugador[i] == mascotas[j]) {
					mascotasFusionables[indiceMascotasFusionables] = mascotas[j];
					indiceMascotasFusionables++;
					break;
				}
			}
		}

		String[] opcionesMascotasFusionadas = new String[mascotasFusionables.length + 1];
		for (int i = 0; i < mascotasFusionables.length; i++) {
			opcionesMascotasFusionadas[i] = (i + 1) + "- " + mascotasFusionables[i];
		}
		opcionesMascotasFusionadas[opcionesMascotasFusionadas.length - 1] = opcionesMascotasFusionadas.length
				+ "- regresar";

		HelperClass.imprimirTextoGuiones("Menu para la fusion de mascotas");
		System.out.println("Se ha encontrado que de tus mascotas, estas pueden ser");
		System.out.println("fusionadas, ya que estan disponibles en la tienda");
		Menu menuFusionarMascotas = new Menu(opcionesMascotasFusionadas);
		int opcion = menuFusionarMascotas.getOpcion();

		if (opcion != opcionesMascotasFusionadas.length) {
			String nombre = mascotasFusionables[opcion - 1];
			if (_jugador.oro >= 3) {
				_jugador.buscarMascota(nombre).subirNivel(true);
				_jugador.oro -= 3;
				System.out.println("Ahora tienes un total de " + _jugador.oro + " de oro");
			} else {
				System.out.println("No tienes el oro suficiente para comprar una mascota y fusionarla");
			}
		}

	}

}
