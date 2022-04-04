package com.alejandro.mascotas.tier4;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Llama extends Mascota {
	public Llama(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 6, new String[] { NombresTipos.terrestre }, NombresMascotas.llama);
	}

	public void fortalezaIndividual() {
	}
}