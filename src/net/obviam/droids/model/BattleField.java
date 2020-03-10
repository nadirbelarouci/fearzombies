package net.obviam.droids.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleField {
	
	public static final int WIDTH = 480 / 32;
	public static final int HEIGHT = 320 / 32;
	
	private static Random random = new Random(System.currentTimeMillis());

	private Object[][] grid;
	private List<Obstacle>	obstacles = new ArrayList<Obstacle>();
	private List<Zombie>		enemies = new ArrayList<Zombie>();
	private Hero hero;
	
	public BattleField(Hero hero) {
		this.hero = hero;

		grid = new Object[HEIGHT][WIDTH];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				grid[j][i] = null;
			}
		}
		// add the droid
		grid[(int) hero.getY()][(int) hero.getX()] = hero;
		
		// add 5 obstacles and 5 enemies at random positions
		for (int i = 0; i < 5; i++) {
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			while (grid[y][x] != null) {
				x = random.nextInt(WIDTH);
				y = random.nextInt(HEIGHT);
			}
			grid[y][x] = new Obstacle(x, y);
			obstacles.add((Obstacle) grid[y][x]);
			while (grid[y][x] != null) {
				x = random.nextInt(WIDTH);
				y = random.nextInt(HEIGHT);
			}
			grid[y][x] = new Zombie(x, y);
			enemies.add((Zombie) grid[y][x]);
		}
	}
	
	public List<Obstacle> getObstacles() {
		return obstacles;
	}
	public List<Zombie> getEnemies() {
		return enemies;
	}
	public Hero getHero() {
		return hero;
	}

	public Object[][] getGrid() {
		return grid;
	}
	
}
