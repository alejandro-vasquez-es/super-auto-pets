package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Conejo extends Mascota {

	public Conejo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 2, new String[] {
				NombresTipos.mamifero
		}, NombresMascotas.conejo);
	}

	@Override
	public void comer(String _comida) {
		super.comer(_comida);
		carino();
	}

	public void carino() {
		setVida(getVida() + nivel);
	}

}
