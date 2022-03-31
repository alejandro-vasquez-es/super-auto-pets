package com.alejandro.mascotas.tier3;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Lobo extends Mascota {

	boolean yaAullo = false;

	public Lobo(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(3, 4, new String[] {
				NombresTipos.solitario, NombresTipos.terrestre
		}, NombresMascotas.lobo);
	}

	@Override
	public void atacar(Mascota _oponente) {
		aullido();
		super.atacar(_oponente);
	}

	public void aullido() {
		int totalAliados = HelperClass.totalMascotas(aliados);

		if (totalAliados == 1 && yaAullo == false) {
			setVida(getVida() + nivel * 2);
			setAtaque(getAtaque() + nivel * 2);
			yaAullo = true;
		}
	}

}
