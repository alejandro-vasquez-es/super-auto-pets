package com.alejandro.jugador;

import com.alejandro.helpers.HelperClass;
import com.alejandro.mascotas.Mascota;

public class Jugador {

	public int vida = 10;
	public int daño = 1;
	public int victorias = 0;
	public int oro = 10;
	public Mascota[] mascotas;
	public Mascota[] mascotasAlFrente;
	public int indice = 0;
	public int totalMascotas = 0;

	public boolean comprarMascota(String _nombre) {

		if (totalMascotas < 5) {
			mascotas[indice] = HelperClass.instanciarTipoNombre(_nombre);
			oro -= 3;
			totalMascotas++;
			indice++;
			return true;
		} else {
			System.out.println("ya no tienes espacio para más mascotas, intenta vender algunas");
			return false;
		}

	}

	public Mascota buscarMascota(String _nombre) {
		for (int i = 0; i < totalMascotas; i++) {
			if (mascotas[i].nombre == _nombre) {
				return mascotas[i];
			}

		}

		return null;
	}

}
