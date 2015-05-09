package ch.idsia.agents.controllers;

import java.util.List;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;

public abstract class ZhichaoCaoComposite extends ZhichaoCaoTask {
	
	public abstract void Composite(List<ZhichaoCaoTask> m_children);
		 
	protected List<ZhichaoCaoTask>  m_children ;
	
}
