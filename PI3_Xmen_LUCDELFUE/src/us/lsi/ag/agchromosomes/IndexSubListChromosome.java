package us.lsi.ag.agchromosomes;

import java.util.List;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.BinaryChromosome;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;

import us.lsi.ag.ProblemaAG;
import us.lsi.ag.ProblemaAGIndex;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

/**
 * @author Miguel Toro
 * 
 * 
 * <p> Una implementaci�n del tipo Cromosoma&lt;Integer&gt;. Toma como informaci�n la definici�n de un problema que implementa el interfaz ProblemaAGIndex.
 * A partir de esa informaci�n construye una secuencia normal. Asumimos que el n�mero de objetos es <code> n </code> 
 * y el tama�o de la secuencia normal <code> r </code>. </p>
 *  
 * <p> La lista decodificada est� formada por una lista de  tama�o menor o igual a <code> r </code> cuyos valores son 
 * �ndices en el rango <code> 0..n-1 </code>, y cada �ndice <code> i </code> se puede repetir un m�ximo n�mero de veces dado por la multiplicidad m�xima del objeto i
 * definida en el problema. La lista decodificada es, por lo tanto, un subconjunto de la secuencia normal definida en el problema. </p>
 * 
 * <p> La implementaci�n usa un cromosoma binario del tama�o de la secuencia normal. </p>
 * 
 * <p> Es un cromosoma adecuado para codificar problemas de subconjuntos de multiconjuntos</p>
 *
 */
public class IndexSubListChromosome extends BinaryChromosome implements IndexChromosome {

	public static ProblemaAGIndex<?> problema;
	
	public static List<Integer> normalSequence;
	
	/**
	 * Dimensi�n del cromosoma
	 */
	
	public static int DIMENSION;
	
	public static void iniValues(ProblemaAG problema){
		IndexSubListChromosome.problema = (ProblemaAGIndex<?>) problema; 
		IndexSubListChromosome.normalSequence = IndexSubListChromosome.problema.getNormalSequence();
		IndexSubListChromosome.DIMENSION = IndexSubListChromosome.normalSequence.size();
	}
	
	public IndexSubListChromosome(List<Integer> representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	public IndexSubListChromosome(Integer[] representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	@Override
	public AbstractListChromosome<Integer> newFixedLengthChromosome(List<Integer> ls) {
		return new IndexSubListChromosome(ls);
	}

	/**
	 * @return Una lista de enteros obtenida filtrando la secuencia normal para incluir 
	 * s�lo los seleccionados por el cromosoma binario 
	 */
	@Override
	public List<Integer> decode() {	
		List<Integer> r = Lists.newArrayList();
		List<Integer> bn = this.getRepresentation();
		Preconditions.checkArgument(normalSequence.size() == bn.size(),normalSequence.size()+","+bn.size());
		for (int i = 0; i < normalSequence.size(); i++) {
			if (bn.get(i) == 1) {
				r.add(normalSequence.get(i));
			}
		}
		return r;
	}
	
	public static IndexSubListChromosome getInitialChromosome() {
		List<Integer> ls = BinaryChromosome.randomBinaryRepresentation(IndexSubListChromosome.DIMENSION);
		return new IndexSubListChromosome(ls);
	}

	@Override
	public double fitness() {
		return ft;
	}
	
	private Double ft = null;
	
	private double calculateFt(){
		return IndexSubListChromosome.problema.fitnessFunction(this);
	}

	@Override
	public ProblemaAGIndex<?> getProblem() {
		return IndexSubListChromosome.problema;
	}

	public Integer getObjectsNumber() {
		return IndexSubListChromosome.problema.getObjectsNumber();
	}

	public Integer getMax(int i) {
		return IndexSubListChromosome.problema.getMax(i);
	}

	@Override
	public Chromosome asChromosome() {
		return this;
	}

	
	
	
}