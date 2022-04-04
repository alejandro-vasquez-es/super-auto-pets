package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Ardilla extends Mascota {
	public Ardilla(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 5, new String[] { NombresTipos.domestico }, NombresMascotas.ardilla);
	}

	public void rebajas() {
	}
}