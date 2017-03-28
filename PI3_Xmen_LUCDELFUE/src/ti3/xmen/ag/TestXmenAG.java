package ti3.xmen.ag;

import ti3.xmen.ProblemaXmen;
import us.lsi.ag.*;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class TestXmenAG {

	public static void main(String[] args){
		
		AlgoritmoAG.ELITISM_RATE  = 0.30;
		AlgoritmoAG.CROSSOVER_RATE = 0.8;
		AlgoritmoAG.MUTATION_RATE = 0.7;
		AlgoritmoAG.POPULATION_SIZE = 200;
		StoppingConditionFactory.NUM_GENERATIONS = 500;
		StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 10;
		StoppingConditionFactory.FITNESS_MIN = 100.0;
		StoppingConditionFactory.stoppingConditionType = StoppingConditionType.GenerationCount;

		ProblemaXmen.create("Mutantes.txt");
		System.out.println("------");
		System.out.println("Listado X-Men: " + ProblemaXmen.listaXmen);
		System.out.println("------");
		System.out.println("Listado Mutantes: " + ProblemaXmen.listaMutantes);
		System.out.println("------");
		System.out.println("Solución:");
		ProblemaXmenAG p = new ProblemaXmenAG();
		// TODO
		System.out.println("Emparejamientos: TODO Mutante VS Xmen");
		// TODO
		System.out.println("Fitness de la mejor solución: TODO");
		System.out.println("------");
	}	

}
