package com.alejandro.jugador;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.mascotas.Mascota;

public class JugadorReal extends Jugador {

	public JugadorReal(Jugador _oponente) {
		super(_oponente);
		// oro = 100; // pruebas
	}

	public boolean comprarMascota(String _nombre) {

		boolean hayEspacios = super.comprarMascota(_nombre);
		if (hayEspacios) {
			System.out.println("Has comprado una mascota de la clase " + _nombre);
			System.out.println("Ahora tienes un total de " + oro + " de oro");

		} else {
			System.out.println("ya no tienes espacio para más mascotas, intenta vender algunas");
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

	public void accionVenderMascota() {

		HelperClass.imprimirTextoGuiones("Estas a punto de vender una mascota");
		System.out.println("obtendras oro equivalente a su nivel");
		System.out.println("¿Cual deseas vender?");
		String[] opciones = new String[totalMascotas + 1];
		for (int i = 0; i < totalMascotas; i++) {
			opciones[i] = (i + 1) + "- " + mascotas[i].nombre;
		}
		opciones[totalMascotas] = (totalMascotas + 1) + "- cancelar";

		Menu menu = new Menu(opciones);
		int opcion = menu.getOpcion();
		if (opcion != totalMascotas + 1) {
			System.out.println("Tu " + mascotas[opcion - 1].nombre + " se ha vendido extosamente");
			System.out.println(
					"Como el nivel de tu " + mascotas[opcion - 1].nombre + " es de " + mascotas[opcion - 1].nivel);
			int oroGanado = venderMascota(mascotas[opcion - 1]);
			System.out.println("recibes un total de " + oroGanado + " de oro");
			oro += oroGanado;
		}
	}

}
