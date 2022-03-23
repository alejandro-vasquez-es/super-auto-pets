package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Escarabajo extends Mascota {

	public Escarabajo() {
		setEstadisticas(2, 3, new String[] { NombresTipos.insecto }, NombresMascotas.escarabajo);
	}

}
