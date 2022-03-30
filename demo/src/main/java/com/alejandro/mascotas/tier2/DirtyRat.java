package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.mascotas.Mascota;

public class DirtyRat extends Mascota {

	public DirtyRat(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 1, new String[] {}, NombresMascotas.dirtyRat);
	}

}
