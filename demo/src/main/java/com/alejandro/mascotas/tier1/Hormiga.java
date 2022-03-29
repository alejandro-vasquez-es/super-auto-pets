package com.alejandro.mascotas.tier1;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Hormiga extends Mascota {

	public Hormiga(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 1, new String[] {
				NombresTipos.insecto, NombresTipos.terrestre
		}, NombresMascotas.hormiga);
	}

	public void morir() {
		companerismo();
	}

	public void companerismo() {

		int totalMascotas = HelperClass.totalMascotas(aliados);

		Mascota aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalMascotas);
		if (!(aliado.nombre == NombresMascotas.hormiga && totalMascotas == 1)) {
			while (aliado.equals(this)) {
				aliado = HelperClass.obtenerMascotaAleatoria(aliados, totalMascotas);
			}
			aliado.setAtaque(aliado.getAtaque() + 2 * nivel);
			aliado.setVida(aliado.getVida() + nivel);
		}
	}

}
