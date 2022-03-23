package com.alejandro.motores;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.jugador.JugadorReal;
import com.alejandro.mascotas.Mascota;

public class MotorModoArena extends MotorJuego {

	public MotorModoArena() {
		super();
		modo = "Arena";
		jugador = new JugadorReal();

	}

	public void cicloJuego() {
		System.out.println("¿Que deseas hacer ahora?");
		int opcion = menu.getOpcion();
		ejecutarOpcionMenu(opcion);
	}

	public void iniciarJuego() {
		jugador.mascotas = new Mascota[5];
		cicloJuego();
	}

	public void ejecutarOpcionMenu(int opcion) {
		switch (opcion) {
			case 1:
				System.out.println("Empezando batalla...");
				break;
			case 2:
				accionesBatalla();
				menu.estaMenuAbierto = true;
				cicloJuego();
				break;

			default:
				break;
		}
	}

	public void accionesBatalla() {

		HelperClass.imprimirTextoGuiones("----Menu-acciones-entre-batallas----");

		Menu menuAccionesBatalla = new Menu(new String[] {
				"1- Comprar mascotas",
				"2- Comprar comida",
				"3- Ordenar mascotas",
				"4- Fusionar mascotas",
				"5- Vender mascota",
				"6- Regresar"
		});

		int opcion = menuAccionesBatalla.getOpcion();
		if (opcion != 6) {
			ejecutarAccionesEntreBatallas(opcion);
			accionesBatalla();
		}

	}

	public void ejecutarAccionesEntreBatallas(int _opcion) {
		switch (_opcion) {
			case 1:
				tienda.comprarMascotas(jugador);
				break;
			case 2:
				tienda.comprarComida(jugador);
				break;
			case 3:
				((JugadorReal) jugador).ordernarMascotas();
				break;
			case 4:
				tienda.fusionarMascota(jugador);
				break;
			case 5:
				System.out.println("Vendiendo una mascota...");
				break;

			default:
				break;
		}
	}

}
