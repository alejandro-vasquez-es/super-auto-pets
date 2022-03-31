package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Canguro extends Mascota {

	public Canguro(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 2, new String[] {
				NombresTipos.mamifero, NombresTipos.terrestre
		}, NombresMascotas.canguro);
	}

	public void yaQuieroPelear() {
		setAtaque(getAtaque() + nivel * 2);
		setVida(getVida() + nivel * 2);
	}

}
