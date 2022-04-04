package com.alejandro.mascotas.tier5;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Cocodrilo extends Mascota {
	public Cocodrilo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(8, 4, new String[] { NombresTipos.reptil, NombresTipos.solitario }, NombresMascotas.cocodrilo);
	}

	public void mordida() {
	}
}