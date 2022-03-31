package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Buey extends Mascota {

	private boolean primerAtaqueRecibido = false;

	public Buey(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 4, new String[] {
				NombresTipos.mamifero
		}, NombresMascotas.buey);
	}

	@Override
	public void recibirAtaque(Mascota _oponente) {
		mejorMeProtejo();
		super.recibirAtaque(_oponente);
	}

	public void mejorMeProtejo() {
		if (!primerAtaqueRecibido) {
			this.efectoArmaduraMelon();
			setAtaque(getAtaque() + nivel * 2);
			primerAtaqueRecibido = true;
		}
	}

}
