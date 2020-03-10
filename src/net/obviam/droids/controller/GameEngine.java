package net.obviam.droids.controller;

import java.awt.Event;
import java.awt.Graphics;

import net.obviam.droids.model.BattleField;
import net.obviam.droids.model.Hero;
import net.obviam.droids.view.Renderer;
import net.obviam.droids.view.BattleFieldRenderer;

public class GameEngine {

	private BattleField battleField;
	private Hero hero;
	private Renderer renderer;
	private ArenaController controller;
	
	public GameEngine() {
		hero = new Hero();
		// position droid in the middle
		hero.setX(BattleField.WIDTH / 2);
		hero.setY(BattleField.HEIGHT / 2);
		battleField = new BattleField(hero);
		
		// setup renderer (view)
		renderer = new BattleFieldRenderer(battleField);
		// setup controller
		controller = new ArenaController(battleField);
	}
	
	/** handle the Event passed from the main applet **/
	public boolean handleEvent(Event e) {
		switch (e.id) {
		case Event.KEY_PRESS:
		case Event.KEY_ACTION:
			// key pressed
			break;
		case Event.KEY_RELEASE:
			// key released
			break;
		case Event.MOUSE_DOWN:
			// mouse button pressed
			break;
		case Event.MOUSE_UP:
			// mouse button released
			controller.onClick(e.x, e.y);
			break;
		case Event.MOUSE_MOVE:
			// mouse is being moved
			break;
		case Event.MOUSE_DRAG:
			// mouse is being dragged (button pressed)
			break;
		}
		return false;
	}
	
	/** the update method with the deltaTime in seconds **/
	public void update(float deltaTime) {
		controller.update(deltaTime);
	}
	
	/** this will render the whole world **/
	public void render(Graphics g) {
		renderer.render(g);
	}
}
