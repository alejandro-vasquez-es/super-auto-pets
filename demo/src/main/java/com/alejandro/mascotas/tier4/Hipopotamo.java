package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Hipopotamo extends Mascota {

	public Hipopotamo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 7, new String[] {
				NombresTipos.acuatico, NombresTipos.terrestre
		}, NombresMascotas.hipopotamo);
	}

}
