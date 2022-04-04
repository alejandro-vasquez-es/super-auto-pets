package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Chompipe extends Mascota {
	public Chompipe(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 4, new String[] { NombresTipos.terrestre, NombresTipos.mamifero }, NombresMascotas.chompipe);
	}

	public void solidaridad() {
	}
}