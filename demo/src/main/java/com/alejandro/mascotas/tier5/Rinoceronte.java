package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Rinoceronte extends Mascota {
	public Rinoceronte(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 8, new String[] { NombresTipos.desertico, NombresTipos.terrestre },
				NombresMascotas.rinoceronte);
	}

	public void estampida() {
	}
}