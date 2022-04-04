package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Gorila extends Mascota {
	public Gorila(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(6, 9, new String[] { NombresTipos.mamifero, NombresTipos.terrestre }, NombresMascotas.gorila);
	}

	public void escudo() {
	}
}