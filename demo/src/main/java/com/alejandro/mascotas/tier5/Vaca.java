package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Vaca extends Mascota {
	public Vaca(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(4, 6, new String[] { NombresTipos.mamifero, NombresTipos.terrestre }, NombresMascotas.vaca);
	}

	public void lechePotenciadora() {
	}
}