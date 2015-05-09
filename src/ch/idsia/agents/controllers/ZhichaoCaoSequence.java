package ch.idsia.agents.controllers;

import java.util.List;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;

public class ZhichaoCaoSequence extends ZhichaoCaoComposite {	

	protected ZhichaoCaoTask current;
	private int index;
	
	public ZhichaoCaoSequence(List<ZhichaoCaoTask> m_children) {
		 index = 0;
		 current = m_children.get(index); 
	} 	 

	@Override
	public void Composite(List<ZhichaoCaoTask> m_children) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean run(Environment observation, Mario mario) {
		// TODO Auto-generated method stub
//		if (current ==  m_children.get(m_children.size() - 1)) {
		if(index == m_children.size()) {
			return true; 
		}
		if (current.run(observation, mario)) { 
			index++; 
			return true; 
		} 
		else { 
			return false; 
		}
	}

}
