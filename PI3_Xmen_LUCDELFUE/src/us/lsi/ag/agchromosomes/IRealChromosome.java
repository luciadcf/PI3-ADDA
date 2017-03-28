package us.lsi.ag.agchromosomes;

import java.util.List;

import us.lsi.ag.ProblemaAGReal;

/**
 * @author Miguel Toro
 * 
 * <p> Tipo que modela una lista de valores reales en un dominio </p>
 *
 */
public interface IRealChromosome extends IChromosome<List<Double>> {

	/**
	 * @return N�mero de variables
	 */
	Integer getNum();

	/**
	 * @pre i est� en el intervalo 0..getNum()-1
	 * @param i Un �ndice de una variable 
	 * @return El l�mite superior de los valores de esa variable
	 */
	Double getSup(int i);
	/**
	 * @pre i est� en el intervalo 0..getNum()-1
	 * @param i Un �ndice de una variable 
	 * @return El l�mite inferior de los valores de esa variable
	 */
	Double getInf(int i);
	
	/**
	 * @return El problema a resolver
	 */
	ProblemaAGReal<?> getProblema();
}