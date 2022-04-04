package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Puma extends Mascota {
	public Puma(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 7, new String[] { NombresTipos.mamifero, NombresTipos.terrestre }, NombresMascotas.puma);
	}

	public void sigilo() {
	}
}