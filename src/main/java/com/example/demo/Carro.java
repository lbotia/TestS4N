package com.example.demo;

public class Carro {
	
	private int modelo;
	private String marca;
	private String color;
	private String colorRines;
	
	

	
	
	public Carro(int modelo, String marca, String color) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
	}
	public Carro(String marca, String color) {
		super();
		this.marca = marca;
		this.color = color;
	}
	public int getModelo() {
		return modelo;
	}
	public void setModelo(int modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColorRines() {
		return colorRines;
	}
	public void setColorRines(String colorRines) {
		this.colorRines = colorRines;
	}
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", marca=" + marca + ", color=" + color + ", colorRines=" + colorRines + "]";
	}
	
	

	
	

	
}
