package ch.idsia.agents.controllers;

import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;

public abstract class ZhichaoCaoTask {
	protected boolean action[] = new boolean[Environment.numberOfKeys];
	protected String name = "Instance_of_BasicAIAgent._Change_this_name";

	/*final*/
	protected byte[][] levelScene;
	/*final */
	protected byte[][] enemies;
	protected byte[][] mergedObservation;

	protected float[] marioFloatPos = null;
	protected float[] enemiesFloatPos = null;

	protected int[] marioState = null;

	protected int marioStatus;
	protected int marioMode;
	protected boolean isMarioOnGround;
	protected boolean isMarioAbleToJump;
	protected boolean isMarioAbleToShoot;
	protected boolean isMarioCarrying;
	protected int getKillsTotal;
	protected int getKillsByFire;
	protected int getKillsByStomp;
	protected int getKillsByShell;

	protected int receptiveFieldWidth;
	protected int receptiveFieldHeight;
	protected int marioEgoRow;
	protected int marioEgoCol;
	
	int zLevelScene = 1;
	int zLevelEnemies = 0;
	
	public void integrateObservation(Environment environment)
	{
	    levelScene = environment.getLevelSceneObservationZ(zLevelScene);
	    enemies = environment.getEnemiesObservationZ(zLevelEnemies);
	    mergedObservation = environment.getMergedObservationZZ(1, 0);

	    this.marioFloatPos = environment.getMarioFloatPos();
	    this.enemiesFloatPos = environment.getEnemiesFloatPos();
	    this.marioState = environment.getMarioState();

	    receptiveFieldWidth = environment.getReceptiveFieldWidth();
	    receptiveFieldHeight = environment.getReceptiveFieldHeight();

	    // It also possible to use direct methods from Environment interface.
	    //
	    marioStatus = marioState[0];
	    marioMode = marioState[1];
	    isMarioOnGround = marioState[2] == 1;
	    isMarioAbleToJump = marioState[3] == 1;
	    isMarioAbleToShoot = marioState[4] == 1;
	    isMarioCarrying = marioState[5] == 1;
	    getKillsTotal = marioState[6];
	    getKillsByFire = marioState[7];
	    getKillsByStomp = marioState[8];
	    getKillsByShell = marioState[9];
	}
	
	public int getEnemiesCellValue(int x, int y)
	{
	    if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
	        return 0;

	    return enemies[x][y];
	}

	public int getReceptiveFieldCellValue(int x, int y)
	{
	    if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
	        return 0;

	    return levelScene[x][y];
	}

	public abstract boolean run(Environment observation, Mario mario);
	
}
