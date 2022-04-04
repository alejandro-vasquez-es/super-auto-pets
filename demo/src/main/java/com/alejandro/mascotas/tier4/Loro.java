package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Loro extends Mascota {
	public Loro(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(5, 3, new String[] {
				NombresTipos.volador
		}, NombresMascotas.loro);
	}
}
