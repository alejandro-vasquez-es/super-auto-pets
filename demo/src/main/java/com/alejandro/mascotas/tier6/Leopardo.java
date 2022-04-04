package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Leopardo extends Mascota {
	public Leopardo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(10, 4, new String[] { NombresTipos.mamifero, NombresTipos.terrestre },
				NombresMascotas.leopardo);
	}

	public void zarpazo() {
	}
}