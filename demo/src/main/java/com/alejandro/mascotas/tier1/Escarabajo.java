package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Escarabajo extends Mascota {

	public Escarabajo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 3, new String[] { NombresTipos.insecto }, NombresMascotas.escarabajo);
	}

	public void apetito() {
		System.out.println("Realizando apetito");
	}

}
