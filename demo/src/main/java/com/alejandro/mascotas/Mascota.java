package com.alejandro.mascotas;

import com.alejandro.helpers.Comidas;
import com.alejandro.helpers.Efectos;
import com.alejandro.helpers.HelperClass;
import com.alejandro.helpers.NombresMascotas;
import com.alejandro.mascotas.tier3.Canguro;

public class Mascota {

	private double ataque;
	private double vida;
	public int experiencia = 0;
	public String[] tipos;
	public int nivel = 1;
	public String[] efectos = new String[30];
	public int indiceEfectos = 0;
	public String nombre;
	public int tier = 1;
	protected Mascota[] aliados;
	protected Mascota[] enemigos;
	protected int danosEfectoArmaduraMelon = 0;

	// public Mascota(String _nombre) {
	// nombre = _nombre;
	// System.out.println(nombre);
	// }
	public Mascota(Mascota[] _aliados, Mascota[] _enemigos) {
		this.aliados = _aliados;
		this.enemigos = _enemigos;
	}

	public void setEstadisticas(double _ataque, double _vida, String[] _tipos, String _nombre) {
		setAtaque(_ataque);
		setVida(_vida);
		tipos = _tipos;
		nombre = _nombre;
	}

	public void setAtaque(double _ataque) {
		ataque = _ataque;
	}

	public void setVida(double _vida) {
		vida = _vida;

	}

	public double getAtaque() {
		return ataque;
	}

	public double getVida() {
		return vida;
	}

	public void comer(String _comida) {
		Comidas.ejecutarComida(_comida, this);
	}

	public void fusionar() {
		experiencia++;
		if (experiencia == 1) {
			subirNivel();
			System.out.println("Tu mascota " + nombre + " ha subido de nivel");
		} else if (experiencia == 4) {
			subirNivel();
			System.out.println("Tu mascota " + nombre + " ha subido de nivel");
		} else {
			System.out.println("Tu mascota " + nombre + " ha aumentado su experiencia");
		}
	}

	public void subirNivel() {
		nivel++;
		setAtaque(ataque + 1);
		setVida(vida + 1);
	}

	public void atacar(Mascota _oponente) {
		// Habilidad canguro
		int totalMascotas = HelperClass.totalMascotas(aliados);
		int indiceMascota = HelperClass.obtenerIndiceMascota(this, aliados);
		if (totalMascotas < 4 && aliados[indiceMascota + 1] != null
				&& aliados[indiceMascota + 1].nombre == NombresMascotas.canguro) {
			((Canguro) aliados[indiceMascota + 1]).yaQuieroPelear();
		}
		_oponente.recibirAtaque(this);
		danosEfectoArmaduraMelon = 0;
	}

	public void recibirAtaque(Mascota _oponente) {
		// Armadura de melon
		if (danosEfectoArmaduraMelon > 0 && Efectos.tieneEfecto(efectos, Efectos.armaduraMelon)) {
			danosEfectoArmaduraMelon -= _oponente.ataque;
		} else {
			setVida(vida - _oponente.ataque);
		}
	}

	public boolean estaVivo() {

		if (vida <= 0) {
			return false;
		}

		return true;
	}

	public void morir() {
	}

	public void venderse() {

	}

	public void iniciarBatalla() {

	}

	public void comprarse() {

	}

	public void aumentarEstadisticas(double _vidaExtra, double _ataqueExtra) {
		vida += _vidaExtra;
		ataque += _ataqueExtra;
	}

	// EFECTOS

	public void efectoDebil() {
		setVida(getVida() - 3);
	}

	public void efectoArmaduraMelon() {
		danosEfectoArmaduraMelon = 20;
		efectos[indiceEfectos] = Efectos.armaduraMelon;
		indiceEfectos++;
	}

}
