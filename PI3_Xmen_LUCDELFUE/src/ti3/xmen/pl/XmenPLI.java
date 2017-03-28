package ti3.xmen.pl;

import java.util.List;

import ti3.xmen.Mutante;
import ti3.xmen.ProblemaXmen;
import us.lsi.pl.AlgoritmoPLI;

public class XmenPLI {

	// TODO

	public static String getConstraints() {

		ProblemaXmen.leeXmen("Mutantes.txt");
		List<Mutante> listaXMen = ProblemaXmen.listaXmen;
		List<Mutante> listaMutantes = ProblemaXmen.listaMutantes;
		Integer numXMen = listaXMen.size();
		Integer numMutantes = listaMutantes.size();

		/****** Función objetivo ******/

		String s = "max: ";

		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {
				if (i != 0 || j != 0) {
					s = s + "+";
				}
				s = s + AlgoritmoPLI.getVariable("x", i, j);

			}
		}
		s = s + ";\n\n";

		/****** RESTRICCIONES ******/

		// SOLO BATALLAS LIDER-LIDER Y NOLIDER-NOLIDER
		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {

				Boolean lider = listaXMen.get(i).isLider() == true && listaMutantes.get(j).isLider() == true;
				Boolean noLider = listaXMen.get(i).isLider() == false && listaMutantes.get(j).isLider() == false;
				if (lider == true || noLider == true) {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 1 + ";\n";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 0 + ";\n";
				}
			}
		}
		s = s + "\n";

		// PROHIBIDO ENFRENTAMIENTO HIELO - FUEGO

		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {

				Boolean esFuego = listaXMen.get(i).getFuego() > 4 || listaMutantes.get(j).getFuego() > 4;
				Boolean esHielo = listaXMen.get(j).getHielo() > 4 || listaMutantes.get(j).getHielo() > 4;

				if (esFuego == true && esHielo == true) {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 0 + ";\n";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 1 + ";\n";
				}
			}
		}
		s = s + "\n";

		// PROHIBIDO ENFRENTAMIENTO MATERIA - FUERZA
		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {

				Boolean esMateria = listaXMen.get(i).getMateria() > 4 || listaMutantes.get(j).getMateria() > 4;
				Boolean esFuerza = listaXMen.get(j).getFuerza() > 4 || listaMutantes.get(j).getFuerza() > 4;

				if (esMateria == true && esFuerza == true) {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 0 + ";\n";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + 1 + ";\n";
				}
			}
		}
		s = s + "\n";

		// TODO // MUTANTES SOLO UNA BATALLA

		for (int j = 0; j < numMutantes; j++) {
			for (int i = 0; i < numXMen; i++) {

				Integer numBatallasMutante = listaMutantes.get(j).getNumBatallas();

				if (i != 4) {
					s = s + AlgoritmoPLI.getVariable("x", i, j);
					s = s + "+";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "=" + numBatallasMutante + ";\n";

				}

			}

		}
		s = s + "\n";

		// Los X-Men pueden librar, como maximo, tantas batallas como limite
		// tengan establecido

		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {

				Integer numBatallasXMen = listaXMen.get(i).getNumBatallas();
				if (j != 4) {
					s = s + AlgoritmoPLI.getVariable("x", i, j);
					s = s + "+";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + "<=" + numBatallasXMen + ";\n";
				}
			}
		}
		s = s + "\n";

		// VARIABLES
		
		s = s + "int ";
		for (int i = 0; i < numXMen; i++) {
			for (int j = 0; j < numMutantes; j++) {

				if (i != 4) {
					s = s + AlgoritmoPLI.getVariable("x", i, j) + ",";
				} else {
					s = s + AlgoritmoPLI.getVariable("x", i, j);
				}
			}
		}
		
		s = s + ";\n\n";
		
		/*// EMPAREJAMIENTOS
		
		for (int i = 0; i < numXMen; i++){
			for (int j = 0; j < numMutantes; j++){
				
				
			s = s + listaXMen.get(i).getNombre() + "VS" + listaMutantes.get(j).getNombre() + ";\n";
				
					
			}
		}*/
		return s;
	}

}
