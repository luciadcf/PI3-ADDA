package us.lsi.ag.agchromosomes;

import us.lsi.ag.ProblemaAGExpression;
import us.lsi.common.ConstantExp;
import us.lsi.common.Exp;
import us.lsi.common.VariableExp;

/**
 * @author Miguel Toro
 *
 * @param <T> El tipo del resultado de la expresi�n
 * 
 * <p> Representa un cromosoma cuyo valor decodificado es
 * una expresi�n formada por un conjunto de operadores dados, un conjunto de variables y un conjunto de constantes </p>
 */
public interface IExpressionChromosome<T> extends IChromosome<Exp<T>> {
	
	/**
	 * @return El problema que se va a resolver
	 */
	ProblemaAGExpression<?,T> getProblem();
	
	/**
	 * @return Numero de operadores
	 */
	Integer getNumOperators();
	
	/**
	 * @return N�mero de variables
	 */
	Integer getNumVariables();
	
	/**
	 * @return N�mero de constantes
	 */
	Integer getNumConstants();
	
	/**
	 * @param i Un indice en el rango <code> 0..getNumOperators()-1 </code>
	 * @return El operador de �ndice i
	 */
	Exp<T> getOperator(int i);
	
	/**
	 * @param i Un �ndice en el rango <code> 0..getNumVariables()-1 </code>
	 * @return La vraible de �ndice i
	 */
	VariableExp<T> getVariable(int i);
	
	/**
	 * @param i Un �ndice en el rango <code> 0..getNumConstants()-1 </code>
	 * @return la constante de �ndice i
	 */
	ConstantExp<T> getConstant(int i);
	
	/**
	 * @return la expresi�n asociada al cromosoma
	 */
	Exp<T> getExp();	

}
