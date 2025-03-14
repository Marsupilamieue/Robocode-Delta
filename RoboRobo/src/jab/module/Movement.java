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

		if (step % 3 == 0) {
			bot.setTurnRight(120);
		}

		step++;
	}

	private int step = 0;

}
