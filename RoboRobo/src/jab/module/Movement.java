package jab.module;

/**
 * Movement
 * 
 * @author jab
 */
public class Movement extends Part {

	public Module bot;

	public Movement(Module bot) {
		this.bot = bot;
	}

	public void move() {
		bot.setMaxVelocity(8);
		bot.setAhead(100);

		if (toggleDirection) {
			bot.setTurnRight(45);
		} else {
			bot.setTurnLeft(45);
		}
		toggleDirection = !toggleDirection;
	}

	private boolean toggleDirection = true;

}
