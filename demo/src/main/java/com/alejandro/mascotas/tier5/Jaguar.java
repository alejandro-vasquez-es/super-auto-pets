package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Jaguar extends Mascota {
	public Jaguar(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(7, 4, new String[] { NombresTipos.mamifero, NombresTipos.terrestre }, NombresMascotas.jaguar);
	}

	public void venganza() {
	}
}