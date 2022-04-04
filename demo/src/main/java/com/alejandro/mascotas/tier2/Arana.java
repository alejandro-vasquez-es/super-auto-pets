package com.alejandro.mascotas.tier2;

import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.helpers.NombresTipos;
import com.alejandro.mascotas.Mascota;

public class Arana extends Mascota {

	public Arana(Mascota[] _aliados, Mascota[] _enemigos) {
		super(_aliados, _enemigos);
		setEstadisticas(2, 2, new String[] {
				NombresTipos.insecto
		}, NombresMascotas.arana);
	}

	@Override
	public void morir() {
		super.morir();
		libearcion();
	}

	public void libearcion() {
		int indiceArana = HelperClass.obtenerIndiceMascota(this, aliados);
		String nombreMascota = NombresMascotas.obtenerMascotaAleatoria(300);
		Mascota mascotaInvocada = HelperClass.instanciarTipoNombre(nombreMascota, aliados, enemigos);
		mascotaInvocada.nivel = nivel;
		mascotaInvocada.setVida(2);
		mascotaInvocada.setAtaque(2);
		aliados[indiceArana] = mascotaInvocada;

	}

}
