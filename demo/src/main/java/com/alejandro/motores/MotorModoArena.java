package com.alejandro.motores;

import com.alejandro.Batalla;
import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.jugador.IA;
import com.alejandro.jugador.JugadorReal;
import com.alejandro.mascotas.Mascota;

public class MotorModoArena extends MotorJuego {

	public MotorModoArena() {
		super();
		modo = "Arena";
		oponente = new IA(jugador);
		jugador.setOponente(oponente);
		batalla = new Batalla(jugador, oponente);

	}

	public void cicloJuego() {
		HelperClass.imprimirTextoGuiones("¿Que deseas hacer ahora?");
		int opcion = menu.getOpcion();
		ejecutarOpcionMenu(opcion);
	}

	public void iniciarJuego() {
		jugador.mascotas = new Mascota[5];
		cicloJuego();
	}

	public boolean empezarBatalla() {

		if (jugador.totalMascotas == 0) {
			System.out.println("No puedes batallar sin mascotas, ve a la tienda a comprar");
			return false;
		}

		inicializarIA();
		batalla.iniciarBatalla();
		tienda.siguienteRonda();
		jugador.actualizarAtaque(tienda.ronda);
		oponente.actualizarAtaque(tienda.ronda);
		jugador.anadirOro();
		oponente.anadirOro();
		return true;
	}

	public void inicializarIA() {
		((IA) oponente).comprarMascotas(tienda.tier);
		batalla.setOponente(oponente);
	}

	public void ejecutarOpcionMenu(int opcion) {
		switch (opcion) {
			case 1:
				empezarBatalla();
				menu.estaMenuAbierto = true;
				cicloJuego();
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
				((JugadorReal) jugador).accionVenderMascota();
				break;

			default:
				break;
		}
	}

}
