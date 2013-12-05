package com.senac.Listas;

public class ListaEncadeada {
	
	private NodoLista primeiro;
	private NodoLista ultimo;
	int tamanho;
	
	
	public ListaEncadeada() {
		primeiro = null; 
		ultimo = null;
		tamanho = 0;
	}

	public void add(ListadeCelulas lista)
	{
		NodoLista novoLista = new NodoLista();
		
		novoLista.setLista(lista);	
					
		if (primeiro == null)
		{
			primeiro = novoLista;
			ultimo = novoLista;
		}
		else
		{
			ultimo.setProximoLista(novoLista);
			ultimo = novoLista;
		}
		tamanho++;
	}
	
	public ListadeCelulas get(int posicao)
	{
		NodoLista aux = primeiro;
		for (int i = 0; i < posicao; i++)
		{
			aux = aux.getProximoLista();
			
			if (aux == null)
				return null;
		}
		
		return aux.getLista();
	}
	
	public void remove(int posicao)
	{
		if (posicao == 0)
		{
			primeiro = primeiro.getProximoLista();
		}
		else
		{
			NodoLista aux;
			int contPosicao = 1;
			
			for (aux = primeiro; aux != null; aux = aux.getProximoLista())
			{
				if (contPosicao == posicao)
				{
					aux.setProximoLista(aux.getProximoLista().getProximoLista());
				}
				else
					contPosicao++;
			}
		}
	}
	
	public int size()
	{
		return this.tamanho;
	}
}
