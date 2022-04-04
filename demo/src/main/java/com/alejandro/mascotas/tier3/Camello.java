package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Camello extends Mascota {

	public Camello(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 5, new String[] {
				NombresTipos.mamifero, NombresTipos.desertico
		}, NombresMascotas.camello);
	}

	@Override
	public void iniciarBatalla() {
		super.iniciarBatalla();
		joroba();
	}

	public void joroba() {
		int indiceCamello = HelperClass.obtenerIndiceMascota(this, aliados);
		if (indiceCamello < 4 && aliados[indiceCamello + 1] != null) {
			aliados[indiceCamello + 1].setAtaque(aliados[indiceCamello + 1].getAtaque() + nivel);
			aliados[indiceCamello + 1].setVida(aliados[indiceCamello + 1].getVida() + nivel * 2);
		}
	}

}
