package com.alejandro.helpers;

import java.util.Scanner;

public class Menu {

	public boolean estaMenuAbierto = true;
	String[] opciones;

	public Menu(String[] _opciones) {

		this.opciones = _opciones;

	}

	public int getOpcion() {

		if (!estaMenuAbierto) {
			return -1;
		}

		HelperClass.imprimirOpciones(opciones);

		Scanner scanner = new Scanner(System.in);
		int opcion;

		try {
			opcion = scanner.nextInt();
			if (!esOpcionValida(opcion)) {
				HelperClass.imprimirTextoGuiones("El numero no corresponde a ninguna opcion, vuelve a intentar");
			} else {
				estaMenuAbierto = false;
				return opcion;
			}
			;
		} catch (Exception e) {
			HelperClass.imprimirTextoGuiones("Debes ingresar un valor numerico entero, vuelve a intentar");
		}
		return getOpcion();

	}

	public boolean esOpcionValida(int opcion) {
		for (int i = 1; i <= opciones.length; i++) {
			if (opcion == i) {
				return true;
			}
		}
		return false;
	}

}
