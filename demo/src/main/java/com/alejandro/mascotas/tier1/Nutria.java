package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Nutria extends Mascota {

	public Nutria(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(1, 2, new String[] { NombresTipos.mamifero }, NombresMascotas.nutria);
	}

	@Override
	public void comprarse() {
		ventajaEconomica();
	}

	public void ventajaEconomica() {
		int totalAliados = HelperClass.totalMascotas(aliados);

		Mascota aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalAliados);
		if (totalAliados != 1) {
			while (aliado.equals(this)) {
				aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalAliados);
			}
			aliado.setAtaque(aliado.getAtaque() + nivel);
			aliado.setVida(aliado.getVida() + nivel);
		}
	}

}
