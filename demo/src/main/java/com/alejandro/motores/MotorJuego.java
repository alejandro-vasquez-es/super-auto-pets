package com.alejandro.motores;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.alejandro.Batalla;
import com.alejandro.Tienda;
import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.Menu;
import com.alejandro.jugador.Jugador;
import com.alejandro.jugador.JugadorReal;
import com.alejandro.mascotas.Mascota;

public class MotorJuego {

	public String modo;
	public Jugador jugador;
	public Jugador oponente;
	public Tienda tienda;
	public Batalla batalla;
	public Menu menu = new Menu(new String[] {
			"1- Batallar",
			"2- Acciones entre batallas",
	});
	public boolean juegoTerminado = false;
	public FileWriter log;
	PrintWriter printWriter;

	public MotorJuego() {
		jugador = new JugadorReal(null);
		tienda = new Tienda();

	}

	public void iniciarJuego() {
		jugador.mascotas = new Mascota[5];
		try {
			log = new FileWriter("log-batallas.txt");
			printWriter = new PrintWriter(log);
			printWriter.printf("El juego ha iniciado en modo %s \n", modo);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}
		cicloJuego();
	}

	public void cicloJuego() {
		if (!juegoTerminado)
			HelperClass.imprimirTextoGuiones("¿Que deseas hacer ahora?");
		int opcion = menu.getOpcion();
		ejecutarOpcionMenu(opcion);
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

	public boolean empezarBatalla() {
		return false;

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

	public void imprimirModo() {
		String texto = getModo();
		HelperClass.imprimirTextoGuiones(texto);
	}

	public String getModo() {
		String texto = "Has empezado el juego en modo " + modo;
		return texto;
	}

}
