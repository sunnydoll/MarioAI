package ch.idsia.agents.controllers;

import java.util.List;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;

public class ZhichaoCaoSelector extends ZhichaoCaoComposite {
	
	protected ZhichaoCaoTask current;
	private int index;
	
	public ZhichaoCaoSelector(List<ZhichaoCaoTask> m_children) {
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
//		for(int i = 0; i < m_children.size(); i++) {
//			current = m_children.get(i);
//			if(!current.run(observation, mario)) {
//				return false;
//			}
//		}
//		return true;
		while(true) { 
		   if (current.run (observation, mario)) {
			   return true; 
		   }
		   index++;
		   current =  m_children.get(index);
		} 
	}
	
}
