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
		bot.setAhead(10000);
	}

	private int moveDirection;
	private int turnRightValue = 45;

	public void listen(robocode.Event e) {
		if (e instanceof robocode.HitWallEvent) {
			bot.setTurnRight(turnRightValue);
		}
	}

}
