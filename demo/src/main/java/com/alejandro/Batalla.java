package com.alejandro;

import java.io.PrintWriter;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.jugador.Jugador;
import com.alejandro.mascotas.Mascota;

public class Batalla {

	public int numeroRonda = 1;
	// private int numeroRonda = 4; // pruebas
	private Jugador jugador;
	private Jugador oponente;

	public Batalla(Jugador _jugador, Jugador _oponente) {
		jugador = _jugador;
		oponente = _oponente;
	}

	public void actualizarRonda() {
		numeroRonda++;
		if (numeroRonda == 4) {
			jugador.ataque = 2;
			oponente.ataque = 2;
		}
		if (numeroRonda == 7) {
			jugador.ataque = 3;
			oponente.ataque = 3;
		}
	}

	public void verificarTotalMascotas() {
		jugador.totalMascotas = HelperClass.totalMascotas(jugador.mascotas);
		oponente.totalMascotas = HelperClass.totalMascotas(oponente.mascotas);
	}

	public void iniciarBatalla(PrintWriter printWriter) {
		Campos.seleccionarCampo(jugador, oponente);
		aplicarHabilidadesInicioBatalla();

		jugador.setMascotaPeleadora();
		oponente.setMascotaPeleadora();

		while (jugador.totalMascotas != 0 && oponente.totalMascotas != 0) {
			batallaIndividual(printWriter);
			verificarTotalMascotas();
		}

		aplicarEfectosFinal();

		verificarMascotasMuertas(jugador);
		verificarMascotasMuertas(oponente);

		if (jugador.totalMascotas == 0 && oponente.totalMascotas == 0) {
			HelperClass.imprimirTextoGuiones("Hubo un empate, ambos jugador se quedan sin mascotas");
		} else if (jugador.totalMascotas == 0) {
			ganarBatalla(oponente, "oponente");
		} else if (oponente.totalMascotas == 0) {
			ganarBatalla(jugador, "jugador");
		}

	}

	public void aplicarEfectosFinal() {

		for (int i = 0; i < oponente.totalMascotas; i++) {
			Mascota mascota = oponente.mascotas[i];
			mascota.terminarBatalla();

		}

		for (int i = 0; i < jugador.totalMascotas; i++) {
			Mascota mascota = jugador.mascotas[i];
			mascota.terminarBatalla();
		}

	}

	public void aplicarHabilidadesInicioBatalla() {

		for (int i = 0; i < oponente.totalMascotas; i++) {
			Mascota mascota = oponente.mascotas[i];
			mascota.iniciarBatalla();

		}

		for (int i = 0; i < jugador.totalMascotas; i++) {
			Mascota mascota = jugador.mascotas[i];
			mascota.iniciarBatalla();
		}

		verificarMascotasMuertas(oponente);
		verificarMascotasMuertas(jugador);

	}

	public void verificarMascotasMuertas(Jugador _jugador) {
		for (int i = 0; i < _jugador.totalMascotas; i++) {
			if (intentarMatarMascota(_jugador.mascotas[i], _jugador)) {
				i--;
			}
			;
		}
	}

	public boolean intentarMatarMascota(Mascota _mascota, Jugador _jugador) {
		if (!_mascota.estaVivo()) {
			_mascota.morir();
			_jugador.eliminarMascota(_mascota); // 0 porque la mascota peleadora siempre es la primera
			_jugador.totalMascotas--;
			_jugador.indice--;
			return true;
		}
		return false;

	}

	public void ganarBatalla(Jugador _jugador, String nombre) {
		HelperClass.imprimirTextoGuiones("El " + nombre + " ha ganado la batalla");
		System.out.println("Con un total de " + _jugador.totalMascotas + " mascotas vivas");
		System.out.println("Las mascotas que quedaron vivas son: ");
		_jugador.imprimirEstaidiscticasMascotas();
		_jugador.victorias++;
		_jugador.danarOponente();

	}

	public void setOponente(Jugador _oponente) {
		oponente = _oponente;
	}

	public void batallaIndividual(PrintWriter printWriter) {
		jugador.setMascotaPeleadora();
		oponente.setMascotaPeleadora();
		printWriter.printf("Pelea individual: %s vs %s \n", jugador.mascotaPeleadora.nombre,
				oponente.mascotaPeleadora.nombre);

		double vidaInicialMascotaJugador = jugador.mascotaPeleadora.getVida();
		double vidaInicialMascotaOponente = oponente.mascotaPeleadora.getVida();

		printWriter.print("la mascota " + jugador.mascotaPeleadora.nombre + " realizo "
				+ jugador.mascotaPeleadora.getAtaque() + " de dano \n");
		printWriter.print("la mascota " + oponente.mascotaPeleadora.nombre + " realizo "
				+ oponente.mascotaPeleadora.getAtaque() + " de dano \n");

		jugador.mascotaPeleadora.atacar(oponente.mascotaPeleadora);
		oponente.mascotaPeleadora.atacar(jugador.mascotaPeleadora);

		printWriter.print("la mascota " + jugador.mascotaPeleadora.nombre + " recibio "
				+ (vidaInicialMascotaJugador - jugador.mascotaPeleadora.getVida()) + " de dano y tenia "
				+ vidaInicialMascotaJugador + " de vida, posee " + jugador.mascotaPeleadora.getVida()
				+ " de vida actualmente \n");
		printWriter.print("la mascota " + oponente.mascotaPeleadora.nombre + " recibio "
				+ (vidaInicialMascotaOponente - oponente.mascotaPeleadora.getVida()) + " de dano y tenia "
				+ vidaInicialMascotaOponente + " de vida, posee " + oponente.mascotaPeleadora.getVida()
				+ " de vida actualmente \n");
		printWriter.print("la mascota " + jugador.mascotaPeleadora.nombre + " realizo su habilidad exitosamente \n");
		printWriter.print("la mascota " + oponente.mascotaPeleadora.nombre + " realizo su habilidad exitosamente \n");

		intentarMatarMascota(jugador.mascotaPeleadora, jugador);
		jugador.setMascotaPeleadora();

		intentarMatarMascota(oponente.mascotaPeleadora, oponente);
		oponente.setMascotaPeleadora();
	}

	public void aplicarEfectosCambio() {
		// TODO: No sé por qué agregué esta función
	}

}
