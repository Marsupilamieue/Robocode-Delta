package jab.module;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
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
		double enemyX, enemyY;
		if (bot.enemy != null) {
			enemyX = bot.enemy.x;
			enemyY = bot.enemy.y;
			lastSeenTime = System.currentTimeMillis();
			lastKnownX = enemyX;
			lastKnownY = enemyY;
			enemyVelocity = bot.enemy.velocity; // Simpan kecepatan musuh
		} else if (System.currentTimeMillis() - lastSeenTime < 3000) {
			enemyX = lastKnownX + (random.nextDouble() - 0.5) * 40;
			enemyY = lastKnownY + (random.nextDouble() - 0.5) * 40;
		} else {
			return; // No target available
		}

		double randomOffsetX = calculateOffset();
		double randomOffsetY = calculateOffset();

		double targetX = enemyX + randomOffsetX;
		double targetY = enemyY + randomOffsetY;

		targetX = Math.min(Math.max(18.0, targetX), bot.getBattleFieldWidth() - 18.0);
		targetY = Math.min(Math.max(18.0, targetY), bot.getBattleFieldHeight() - 18.0);

		double theta = Utils.normalAbsoluteAngle(Math.atan2(targetX - bot.getX(), targetY - bot.getY()));
		bot.setTurnGunRightRadians(Utils.normalRelativeAngle(theta - bot.getGunHeadingRadians()));

		toPaintX = (int) targetX;
		toPaintY = (int) targetY;
	}

	private Random random = new Random();
	private long lastSeenTime = 0;
	private double lastKnownX = 0;
	private double lastKnownY = 0;
	private double enemyVelocity = 0;

	private double calculateOffset() {
		double speedFactor = Math.min(1, enemyVelocity / 8.0);
		return (random.nextDouble() - 0.5) * (30 + speedFactor * 50);
	}

	int toPaintX = 0;
	int toPaintY = 0;

	public void onPaint(Graphics2D g) {
		if (bot.enemy != null) {
			g.setColor(Color.BLUE);
			g.drawOval(toPaintX - 4, toPaintY - 4, 8, 8);
			g.drawLine(toPaintX - 6, toPaintY, toPaintX + 6, toPaintY);
			g.drawLine(toPaintX, toPaintY - 6, toPaintX, toPaintY + 6);
			g.drawLine((int) bot.getX(), (int) bot.getY(), toPaintX, toPaintY);
		}
	}

}
