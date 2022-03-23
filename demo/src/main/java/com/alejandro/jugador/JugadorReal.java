package com.alejandro.jugador;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.mascotas.Mascota;

public class JugadorReal extends Jugador {

	public JugadorReal() {
		this.oro = 200;
	}

	public boolean comprarMascota(String _nombre) {

		boolean hayEspacios = super.comprarMascota(_nombre);
		if (hayEspacios) {
			System.out.println("Has comprado una mascota de la clase " + _nombre);
			System.out.println("Ahora tienes un total de " + oro + " de oro");

		}

		return true;

	}

	public void ordernarMascotas() {
		HelperClass.imprimirTextoGuiones("¿Cual de las siguientes mascotas deseas reubicar?");
		String[] opcionesMascotas = new String[totalMascotas + 1];
		for (int i = 0; i < (opcionesMascotas.length - 1); i++) {
			opcionesMascotas[i] = (i + 1) + "- " + mascotas[i].nombre;
		}
		opcionesMascotas[opcionesMascotas.length - 1] = (opcionesMascotas.length) + "- regresar";
		System.out.println("Recuerda que las primeras dos mascotas son las primeras en pelear");

		Menu menu = new Menu(opcionesMascotas);
		int opcion = menu.getOpcion();
		if (opcion != opcionesMascotas.length) {
			HelperClass.imprimirTextoGuiones(
					"¿En que posicion deseas colocar a tu mascota " + mascotas[opcion - 1].nombre);
			String[] opcionesUbicacion = new String[] {
					"1- Primera posicion",
					"2- Ultima posicion",
					"3- no quiero reubicarla",
			};

			Menu menuUbicaciones = new Menu(opcionesUbicacion);
			int opcionUbicacion = menuUbicaciones.getOpcion();
			switch (opcionUbicacion) {
				case 1:
					reubicarMascota(opcion - 1, true);
					break;
				case 2:
					reubicarMascota(opcion - 1, false);
					break;

				default:
					break;
			}
			ordernarMascotas();

		}
	}

	public void reubicarMascota(int _indice, boolean primera) {
		int indiceTemporal = (primera) ? 0 : totalMascotas - 1;

		Mascota temporal = mascotas[indiceTemporal];
		mascotas[indiceTemporal] = mascotas[_indice];
		mascotas[_indice] = temporal;

		System.out.println("Se ha reubicado a tu mascota");
	}

}
