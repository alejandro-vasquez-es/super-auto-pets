package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Mamut extends Mascota {
	public Mamut(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 10, new String[] { NombresTipos.mamifero, NombresTipos.terrestre, NombresTipos.solitario },
				NombresMascotas.mamut);
	}

	public void fuerzaCompaneros() {
	}
}