package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Ballena extends Mascota {
	public Ballena(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 8, new String[] { NombresTipos.acuatico }, NombresMascotas.ballena);
	}

	public void succion() {
	}
}