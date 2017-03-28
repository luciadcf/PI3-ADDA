package us.lsi.ag.agchromosomes;

import java.util.List;

import org.apache.commons.math3.genetics.AbstractListChromosome;
import org.apache.commons.math3.genetics.Chromosome;
import org.apache.commons.math3.genetics.InvalidRepresentationException;
import org.apache.commons.math3.genetics.RandomKey;

import us.lsi.ag.ProblemaAG;
import us.lsi.ag.ProblemaAGIndex;

import com.google.common.base.Preconditions;

/**
 * @author Miguel Toro
 * 
 * <p> Una implementaci�n del tipo IndexChromosome. Toma como informaci�n la definici�n de un problema que implementa el interfaz ProblemaAGIndex.
 * A partir de esa informaci�n construye una secuencia normal. Asumimos que el n�mero de objetos es n y el tama�o de la secuencia normal r. 
 *  
 * <p> La lista decodificada est� formada por una lista de  tama�o r, cuyos valores son 
 * �ndices en el rango [0,n-1], y cada �ndice i se  repite un n�mero de veces dado por la multiplicidad m�xima del objeto i
 * definida en el problema. </p>
 * 
 * <p> La implementaci�n usa un cromosoma de clave aleatoria de tama�o r.
 * Es un cromosoma adecuado para codificar problemas de permutaciones </p>
 *
 */
public class IndexPermutationChromosome extends RandomKey<Integer> implements IndexChromosome {

	public static List<Integer> normalSequence = null;
	public static ProblemaAGIndex<?> problema;
	
	/**
	 * Dimensi�n del cromosoma
	 */
	
	public static int DIMENSION;
	
	public static void iniValues(ProblemaAG problema){
		IndexPermutationChromosome.problema = (ProblemaAGIndex<?>) problema; 
		IndexPermutationChromosome.normalSequence = IndexPermutationChromosome.problema.getNormalSequence();
		IndexPermutationChromosome.DIMENSION = IndexPermutationChromosome.normalSequence.size();
	}

	
	public IndexPermutationChromosome(List<Double> representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	public IndexPermutationChromosome(Double[] representation)
			throws InvalidRepresentationException {
		super(representation);
		this.ft = this.calculateFt();
	}

	@Override
	public AbstractListChromosome<Double> newFixedLengthChromosome(List<Double> ls) {
		return new IndexPermutationChromosome(ls);
		
	}

	@Override
	public List<Integer> decode() {
		Preconditions.checkArgument(IndexPermutationChromosome.normalSequence!=null);
		return this.decode(IndexPermutationChromosome.normalSequence);
	}
	
	
	public static IndexPermutationChromosome getInitialChromosome() {
		List<Double> ls = RandomKey.randomPermutation(IndexPermutationChromosome.DIMENSION);
		return new IndexPermutationChromosome(ls);
	}

	
	@Override
	public double fitness() {
		return ft;
	}
	
	private double ft;
	
	private double calculateFt(){
		return IndexPermutationChromosome.problema.fitnessFunction(this);
	}

	@Override
	public ProblemaAGIndex<?> getProblem() {
		return IndexPermutationChromosome.problema;
	}

	public Integer getObjectsNumber() {
		return IndexPermutationChromosome.problema.getObjectsNumber();
	}

	public Integer getMax(int i) {
		return IndexPermutationChromosome.problema.getMax(i);
	}
	
	@Override
	public Chromosome asChromosome() {
		return this;
	}
	
}