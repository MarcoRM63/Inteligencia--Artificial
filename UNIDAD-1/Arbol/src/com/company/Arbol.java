package com.company;
/* Clase arbol
(Ahora adaptado para la materia de IA)

 * NOTA: eliminar package com.company al momento de compilar, se coloca por el IDE usado.
 * */
public class Arbol {
	Nodo raiz;
	public Arbol() {
		raiz = null;
	}
	public boolean estaVacio(){
		if(this.raiz ==null){
			return true;
		}
		return false;
	}

//mostrar la estructura desde n nodo en un cierto nivel
	public void mostrar(Nodo n, int Cont) {
		if (n != null) {
			mostrar(n.ld,Cont+1);
			for(int i = 0; i < Cont ; i++) {
				System.out.print("   ");
			}
			System.out.println(n.claveart);
			mostrar(n.li,Cont+1);
		}
	}


	public void insertar(int cvl) {
		Nodo n = new Nodo(cvl);
		if (raiz == null) {
			raiz = n;
		} else {
			Nodo aux = raiz;

			while (aux != null) {
				n.Padre = aux;
				if (n.claveart >= aux.claveart) {
					aux = aux.ld;
				}else {
					aux = aux.li;
				}
			}
			if (n.claveart < n.Padre.claveart) {
				n.Padre.li = n;
			} else {
				n.Padre.ld = n;
			}
		}
	}



	public void InOrder(Nodo n) {
		int c = 0;
		if (n != null) {
			InOrder(n.li);
			System.out.println("Indice: " + n.claveart);
			InOrder(n.ld);
			c++;
		}
	}
	/**/
	public void PosOrder(Nodo n) {
		if (n != null) {
			PosOrder(n.li);
			PosOrder(n.ld);
			System.out.println("Indice: " + n.claveart);
		}
	}

	public void PreOrder(Nodo n) {
		if (n != null) {
			System.out.println("Indice: " + n.claveart);
			PreOrder(n.li);
			PreOrder(n.ld);
		}
	}






	

}//arbol