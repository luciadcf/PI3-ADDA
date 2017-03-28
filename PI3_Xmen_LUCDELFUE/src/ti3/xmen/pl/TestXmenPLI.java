package ti3.xmen.pl;

import ti3.xmen.ProblemaXmen;

public class TestXmenPLI {

	public static void main(String[] args) {
		ProblemaXmen.create("Mutantes.txt");
		System.out.println("------");
		System.out.println("X-Men: " + ProblemaXmen.listaXmen);
		System.out.println("------");
		System.out.println("Mutantes: " + ProblemaXmen.listaMutantes);
		System.out.println("------");

		String r = XmenPLI.getConstraints();
		System.out.println("Especificación LPSolve:");
		System.out.println(r);
		System.out.println("------\n");
		// TODO
		System.out.println("Objetivo Solución = TODO");
		/*AlgoritmoPLI a = AlgoritmoPLI.create(r);
		a.getObjetivo();
		a.getSolucion();
		a.setConstraints(r);
		a.ejecuta();*/
		System.out.println("Emparejamientos: Mutante TODO VS Xmen TODO");
	}
}
