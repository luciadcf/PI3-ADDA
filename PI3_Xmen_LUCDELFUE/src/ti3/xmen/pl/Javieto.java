package ti3.xmen.pl;

import ti3.xmen.Mutante;
import ti3.xmen.ProblemaXmen;

public class Javieto {

	// TODO

	public static String getConstraints() {
		String s = "";
		// TODO

		// Funcion objetivo

		s = s + "max: ";

		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {
				if (i == 0 && j == 0) {
					s = s + getValor(i, j) + "x" + i + j;
				} else {
					s = s + " + ";
					s = s + getValor(i, j) + "x" + i + j;
				}
			}
		}
		s = s + ";\n\n";

		// Los mutantes solo pueden batallar una vez
		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {
				if (i == 0) {
					s = s + "x" + i + j;
				} else {
					s = s + " + ";
					s = s + "x" + i + j;
				}

			}
			s = s + " = " + ProblemaXmen.listaMutantes.get(j).getNumBatallas() + ";\n";
		}
		s = s + "\n\n";

		// Cada X-Men tiene un numero máximo de batallas

		for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {
			for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {

				if (j == 0) {
					s = s + "x" + i + j;
				} else {
					s = s + " + ";
					s = s + "x" + i + j;
				}
			}
			Mutante xMen = ProblemaXmen.listaXmen.get(i);
			s = s + "<=" + xMen.getNumBatallas() + ";\n";

		}
		s = s + "\n\n";

		// Un lider solo puede luchar contra otro lider

		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {

				Mutante xMen = ProblemaXmen.listaXmen.get(i);
				Mutante mutEnemigo = ProblemaXmen.listaMutantes.get(j);

				if (mutEnemigo.isLider() && !xMen.isLider()) {
					s = s + "x" + i + j + "=0;\n";
				} else if (!mutEnemigo.isLider() && xMen.isLider()) {
					s = s + "x" + i + j + "=0;\n";
				}
			}

		}
		s = s + "\n\n";

		// Materia no puede contra fuerza y viceversa

		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {

				Mutante xMen = ProblemaXmen.listaXmen.get(i);
				Mutante mutEnemigo = ProblemaXmen.listaMutantes.get(j);

				if (mutEnemigo.getMateria() > 4 && xMen.getFuerza() > 4) {
					s = s + "x" + i + "=0;\n";
				}
				if (mutEnemigo.getFuerza() > 4 && xMen.getMateria() > 4) {
					s = s + "x" + i + "=0;\n";
				}
			}
		}
		s = s + "\n\n";

		// Hielo no puede contra fuego y viceversa
		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {

				Mutante xMen = ProblemaXmen.listaXmen.get(i);
				Mutante mutEnemigo = ProblemaXmen.listaMutantes.get(j);

				if (mutEnemigo.getFuego() > 4 && xMen.getHielo() > 4) {
					s = s + "x" + i + j + "=0;\n";
				}
				if (mutEnemigo.getHielo() > 4 && xMen.getFuego() > 4) {
					s = s + "x" + i + j + "=0;\n";
				}
			}
		}
		s = s + "\n\n";

		// tipo de variables

		s = s + "int ";
		for (int j = 0; j < ProblemaXmen.listaMutantes.size(); j++) {
			for (int i = 0; i < ProblemaXmen.listaXmen.size(); i++) {
				if (j == 0 && i == 0) {
					s = s + "x00";
				} else {
					s = s + ",x" + i + j;
				}

			}
		}
		s = s + ";\n";

		return s;
	}

	private static Integer getValor(int i, int j) {

		int res = 0;
		Mutante xMen = ProblemaXmen.listaXmen.get(i);
		Mutante mutEnemigo = ProblemaXmen.listaMutantes.get(j);

		if (xMen.getSumaCaracteristicas() > mutEnemigo.getSumaCaracteristicas()) {
			res = 1;
		}
		return res;
	}

}