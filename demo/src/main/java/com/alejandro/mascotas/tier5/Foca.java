package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Foca extends Mascota {
	public Foca(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 8, new String[] { NombresTipos.acuatico, NombresTipos.mamifero }, NombresMascotas.foca);
	}

	public void compartirPoder() {
	}
}
