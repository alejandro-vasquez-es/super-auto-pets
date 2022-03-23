package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Nutria extends Mascota {

	public Nutria() {
		setEstadisticas(1, 2, new String[] { NombresTipos.mamifero }, NombresMascotas.nutria);
	}

}
