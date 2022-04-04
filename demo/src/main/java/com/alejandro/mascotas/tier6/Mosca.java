package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mosca extends Mascota {
	public Mosca(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 5, new String[] { NombresTipos.volador, NombresTipos.insecto }, NombresMascotas.mosca);
	}

	public void invocacion() {
	}
}