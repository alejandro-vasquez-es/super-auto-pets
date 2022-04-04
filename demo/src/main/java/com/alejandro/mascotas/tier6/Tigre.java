package com.alejandro.mascotas.tier6;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Tigre extends Mascota {
	public Tigre(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 3, new String[] { NombresTipos.terrestre, NombresTipos.mamifero }, NombresMascotas.tigre);
	}

	public void repeticion() {
	}
}