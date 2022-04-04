package com.alejandro.mascotas.tier7;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Quetzal extends Mascota {
	public Quetzal(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(10, 10, new String[] { NombresTipos.volador, NombresTipos.solitario }, NombresMascotas.quetzal);
	}
}