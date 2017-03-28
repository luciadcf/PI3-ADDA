package us.lsi.ag;

import us.lsi.ag.agchromosomes.BinaryChromosome2;


/**
 * @author Miguel Toro
 *
 * @param <S> El tipo de la soluci�n del problema
 * 
 * 
 * <p> Un problema cuya soluci�n puede ser modelada con variables binarias. Usa un cromomosoma de tipo BinaryChromosome2</p>
 */
public interface ProblemaAGBinary<S> extends ProblemaAG {
	
	/**
	 * @return Dimensi�n del cromosoma. Es el n�mero de variables binarias del problema
	 */
	int getDimensionDelChromosoma();
	
	/**
	 * @param cr Un cromosoma
	 * @return La funci�n de fitness del cromosoma
	 */
	
	Double fitnessFunction(BinaryChromosome2 cr);
	
	/**
	 * @param cr Un cromosoma
	 * @return La soluci�n definida por el cromosoma
	 */
	S getSolucion(BinaryChromosome2 cr);
}
