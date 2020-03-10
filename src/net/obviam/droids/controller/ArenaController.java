package net.obviam.droids.controller;

import net.obviam.droids.model.BattleField;
import net.obviam.droids.model.Hero;

public class ArenaController {

	private static final int unit = 32;
	private BattleField battleField;
	
	/** the target cell **/
	private float targetX, targetY;
	/** true if the droid moves **/
	private boolean moving = false;
	
	public ArenaController(BattleField battleField) {
		this.battleField = battleField;
	}
	
	public void update(float delta) {
		Hero hero = battleField.getHero();
		if (moving) {
			// move on X
			int bearing = 1;
			if (hero.getX() > targetX) {
				bearing = -1;
			} 
			if (hero.getX() != targetX) {
				hero.setX(hero.getX() + bearing * hero.getSpeed() * delta);
				// check if arrived
				if ((hero.getX() < targetX && bearing == -1)
						|| (hero.getX() > targetX && bearing == 1)) hero.setX(targetX);
			}
			// move on Y
			bearing = 1;
			if (hero.getY() > targetY) {
				bearing = -1;
			} 
			if (hero.getY() != targetY) {
				hero.setY(hero.getY() + bearing * hero.getSpeed() * delta);
				// check if arrived
				if ((hero.getY() < targetY && bearing == -1)
						|| (hero.getY() > targetY && bearing == 1)) hero.setY(targetY);
			}
			// check if arrived
			if (hero.getX() == targetX && hero.getY() == targetY)
				moving = false;
		}
	}
	
	// * Input events ----------
	
	/** triggered with the coordinates every click **/
	public boolean onClick(int x, int y) {
		targetX = x / unit;
		targetY = y / unit;
		if (battleField.getGrid()[(int) targetY][(int) targetX] == null) {
			// start moving the droid towards the target
			moving = true;
			return true;
		}
		return false;
	}
}
