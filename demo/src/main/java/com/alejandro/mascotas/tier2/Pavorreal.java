package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Pavorreal extends Mascota {
	public Pavorreal(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 5, new String[] {
				NombresTipos.domestico, NombresTipos.volador
		}, NombresMascotas.pavorreal);
	}

	@Override
	public void recibirAtaque(Mascota _oponente) {
		super.recibirAtaque(_oponente);
		potenciacion();
	}

	public void potenciacion() {
		double ataqueExtra = 0.5 * nivel;
		setAtaque(getAtaque() + getAtaque() * ataqueExtra);

	}
}
