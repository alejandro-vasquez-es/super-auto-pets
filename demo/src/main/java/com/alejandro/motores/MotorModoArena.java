package com.alejandro.motores;

import java.io.IOException;
import java.io.PrintWriter;

import com.alejandro.Batalla;
import com.alejandro.helpers.HelperClass;
import com.alejandro.jugador.IA;

public class MotorModoArena extends MotorJuego {

	public MotorModoArena() {
		super();
		modo = "Arena";
		oponente = new IA(jugador);
		jugador.setOponente(oponente);
		batalla = new Batalla(jugador, oponente);

	}

	@Override
	public boolean empezarBatalla() {

		if (jugador.totalMascotas == 0) {
			System.out.println("No puedes batallar sin mascotas, ve a la tienda a comprar");
			return true;
		}

		printWriter.printf("Empieza el turno de batalla # %d \n", batalla.numeroRonda);

		jugador.agregarMascotasUsadas();
		oponente.agregarMascotasUsadas();
		inicializarIA();
		batalla.iniciarBatalla(printWriter);
		tienda.siguienteRonda();
		jugador.actualizarAtaque(tienda.ronda);
		oponente.actualizarAtaque(tienda.ronda);
		jugador.anadirOro();
		oponente.anadirOro();
		batalla.actualizarRonda();
		if (verificarJuegoTerminado()) {
			imprimirReportes();
			printWriter.close();
			return false;
		}
		return true;
	}

	public boolean verificarJuegoTerminado() {
		if (jugador.vida <= 0) {
			HelperClass.imprimirTextoGuiones(
					"El oponente ha ganado la partida con " + oponente.vida + " puntos de vida, intentalo de nuevo :(");
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

}
