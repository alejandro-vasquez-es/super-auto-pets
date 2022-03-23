package com.alejandro.mascotas;

import com.alejandro.helpers.Comidas;

public class Mascota {

	private double ataque;
	private double vida;
	public int experiencia = 0;
	public String[] tipos;
	public int nivel = 1;
	public String efecto;
	public String nombre;
	public int tier = 1;

	// public Mascota(String _nombre) {
	// nombre = _nombre;
	// System.out.println(nombre);
	// }
	public Mascota() {

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

	public void subirNivel(boolean _mensaje) {
		experiencia++;
		if (experiencia == 1) {
			nivel++;
			setAtaque(ataque + 1);
			setVida(vida + 1);
			if (_mensaje)
				System.out.println("Tu mascota " + nombre + " ha subido de nivel");
		} else if (experiencia == 4) {
			nivel++;
			setAtaque(ataque + 1);
			setVida(vida + 1);
			if (_mensaje)
				System.out.println("Tu mascota " + nombre + " ha subido de nivel");
		} else if (_mensaje) {
			System.out.println("Tu mascota " + nombre + " ha aumentado su experiencia");
		}
	}

}
