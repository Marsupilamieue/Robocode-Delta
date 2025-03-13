package jab.module;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import robocode.util.Utils;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {
		double angle = Utils.normalAbsoluteAngle(Math.atan2(aimX - bot.getX(), aimY - bot.getY()));
		bot.setTurnGunRightRadians(Utils.normalRelativeAngle(angle - bot.getGunHeadingRadians()));
	}

	private int aimX;
	private int aimY;

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			aimX = ((MouseEvent) e).getX();
			aimY = ((MouseEvent) e).getY();
		}
	}

	public void onPaint(java.awt.Graphics2D g) {
		g.setColor(Color.RED);
		g.drawOval(aimX - 15, aimY - 15, 30, 30);
		g.drawLine(aimX, aimY - 4, aimX, aimY + 4);
		g.drawLine(aimX - 4, aimY, aimX + 4, aimY);
	}

}
