package com.senac.Listas;

public class NodoLista {

	private ListadeCelulas lista;
	private NodoLista proximaLista;
		
	public NodoLista() {
		lista = null;
		proximaLista = null;
	}
	
	public ListadeCelulas getLista() {
		return lista;
	}
	public void setLista(ListadeCelulas lista) {
		this.lista = lista;
	}
	public NodoLista getProximoLista() {
		return proximaLista;
	}
	public void setProximoLista(NodoLista proximaLista) {
		this.proximaLista = proximaLista;
	}
	
}


