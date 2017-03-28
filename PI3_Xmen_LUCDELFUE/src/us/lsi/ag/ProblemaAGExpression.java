package us.lsi.ag;

import java.util.List;

import us.lsi.ag.agchromosomes.IExpressionChromosome;
import us.lsi.common.Exp;
import us.lsi.common.NaryExp;

/**
 * @author Miguel Toro
 *
 * @param <S> Tipo de la soluci�n
 * @param <T> Tipo del resultado de la expresi�n buscada
 * 
 * <p> Tipo adecuado para modelar problemas d�nde queremos encontrar una expresi�n, 
 * formada por un conjunto de operadores dados, un conjunto de variables y un conjunto de constantes, tal que su valor se ajuste 
 * a algunos requisitos dados </p>
 */
public interface ProblemaAGExpression<S,T> extends ProblemaAG {

	/**
	 * @return N�mero de operadores
	 */
	Integer getNumOperators();
	
	/**
	 * @return N�mero de variables
	 */
	Integer getNumVariables();
	
	/**
	 * @return Numero de constantes
	 */
	Integer getNumConstants();
	
	/**
	 * @return El rango m�ximo del valor de cada constante. Cada constante tendr� un valor en el rango 0..getMaxValueConstant()-1
	 */
	Integer getMaxValueConstant();
	
	/**
	 * @return N�mero de operadores
	 */
	List<Exp<T>> getOperators();	
	
	/**
	 * @return Expresi�n n-aria, de aridad varaible, que combinar� las expresiones asociadas a cada uno de los genes del cromosoma
	 */
	NaryExp<T> getNaryExp();
	
	/**
	 * @param e Un n�mero entero
	 * @return Un valor de tipo T resultado de la conversi�n del entero e.
	 */
	T convert(Integer e);
	
	
	/**
	 * @param chromosome Un cromosoma 
	 * @return La funci�n de fitness del cromosoma
	 */
	Double fitnessFunction(IExpressionChromosome<T> chromosome);
	
	/**
	 * @param chromosome Es un cromosoma
	 * @return La soluci�n definida por el cromosoma
	 */
	S getSolucion(IExpressionChromosome<T> chromosome);
}
