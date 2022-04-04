package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Venado extends Mascota {

	public Venado(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 1, new String[] {
				NombresTipos.mamifero
		}, NombresMascotas.venado);
	}

}
