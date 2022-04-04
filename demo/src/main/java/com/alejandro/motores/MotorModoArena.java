package com.alejandro.motores;

import java.util.Arrays;

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
		if (!juegoTerminado)
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
			return true;
		}

		jugador.agregarMascotasUsadas();
		oponente.agregarMascotasUsadas();
		inicializarIA();
		batalla.iniciarBatalla();
		tienda.siguienteRonda();
		jugador.actualizarAtaque(tienda.ronda);
		oponente.actualizarAtaque(tienda.ronda);
		jugador.anadirOro();
		oponente.anadirOro();
		batalla.actualizarRonda();
		if (verificarJuegoTerminado()) {
			imprimirReportes();
			return false;
		}
		return true;
	}

	public void imprimirReportes() {
		HelperClass.imprimirTextoGuiones("REPORTES FINALIZACION DE PARTIDA");
		HelperClass.imprimirTextoGuiones("REPORTES ANIMALES USADOS EN PARTIDA POR JUGADOR");
		HelperClass.imprimirTextoGuiones("El total de mascotas utilizadas por el jugador es de: ");
		HelperClass.imprimirMascotas(jugador.mascotasUsadas);
		HelperClass.imprimirTextoGuiones("El total de mascotas utilizadas por el oponente es de: ");
		HelperClass.imprimirMascotas(oponente.mascotasUsadas);
		HelperClass.imprimirTextoGuiones("REPORTE GENERAL DE LA PARTIDA");
		System.out.println("El total de peleas realizadas es de: " + batalla.numeroRonda);
		System.out.println("El total de dano realizado por el jugador es de: " + jugador.totalDanoCausado);
		System.out.println("El total de dano recibido por el jugador es de: " + jugador.totalDanoRecibido);
		System.out.println(
				"El total de animales usados por el jugador es de: "
						+ HelperClass.totalMascotas(jugador.mascotasUsadas));
		HelperClass.imprimirTextoGuiones("REPORTE ORO GASTADO");
		System.out.println("El oro gastado por el jugador es de: " + jugador.oroUsado);
		System.out.println("El oro gastado por el oponente es de: " + oponente.oroUsado);
	}

	public boolean verificarJuegoTerminado() {
		if (jugador.vida <= 0) {
			HelperClass.imprimirTextoGuiones(
					"El bot ha ganado la partida con " + oponente.vida + " puntos de vida, intentalo de nuevo :(");
			juegoTerminado = true;
			return true;
		}
		if (oponente.vida <= 0) {
			HelperClass
					.imprimirTextoGuiones(
							"Felicidades!!! Has ganado el juego con " + jugador.vida + " puntos de vida :D");
			juegoTerminado = true;
			return true;
		}
		return false;
	}

	public void inicializarIA() {
		((IA) oponente).comprarMascotas(tienda.tier);
		batalla.setOponente(oponente);
	}

	public void ejecutarOpcionMenu(int opcion) {
		switch (opcion) {
			case 1:
				menu.estaMenuAbierto = empezarBatalla();
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
		if (opcion != 6 || juegoTerminado) {
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
