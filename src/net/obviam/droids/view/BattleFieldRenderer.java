package net.obviam.droids.view;

import java.awt.Color;
import java.awt.Graphics;

import net.obviam.droids.model.BattleField;
import net.obviam.droids.model.Hero;
import net.obviam.droids.model.Zombie;
import net.obviam.droids.model.Obstacle;

public class BattleFieldRenderer implements Renderer {

	private BattleField battleField;
	
	public BattleFieldRenderer(BattleField battleField) {
		this.battleField = battleField;
	}
	
	@Override
	public void render(Graphics g) {
		// render the grid
		int cellSize = 32; // hard coded
		g.setColor(new Color(0, 0.5f, 0, 0.75f));
		for (int i = 0; i <= BattleField.WIDTH; i++) {
			g.drawLine(i * cellSize, 0, i * cellSize, BattleField.HEIGHT * cellSize);
			if (i <= BattleField.WIDTH)
				g.drawLine(0, i * cellSize, BattleField.WIDTH * cellSize, i * cellSize);
		}
		
		// render the obstacles
		g.setColor(new Color(0, 0, 1f));
		for (Obstacle obs : battleField.getObstacles()) {
			int x = (int) (obs.getX() * cellSize) + 2;
			int y = (int) (obs.getY() * cellSize) + 2;
			g.fillRect(x, y, cellSize - 4, cellSize - 4);
		}
		
		// render the enemies
		g.setColor(new Color(1f, 0, 0));
		for (Zombie zombie : battleField.getEnemies()) {
			int x = (int) (zombie.getX() * cellSize);
			int y = (int) (zombie.getY() * cellSize);
			g.fillOval(x + 2, y + 2, cellSize - 4, cellSize - 4);
		}
		
		// render player droid
		g.setColor(new Color(0, 1f, 0));
		Hero hero = battleField.getHero();
		int x = (int) (hero.getX() * cellSize);
		int y = (int) (hero.getY() * cellSize);
		g.fillOval(x + 2, y + 2, cellSize - 4, cellSize - 4);
		// render square on droid
		g.setColor(new Color(0.7f, 0.5f, 0f));
		g.fillRect(x + 10, y + 10, cellSize - 20, cellSize - 20);
	}

}
