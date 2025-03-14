package jab.module;

import robocode.Rules;
import robocode.Bullet;

/**
 * Gun
 * 
 * @author jab
 */

public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (bot.enemy != null) {
			double bulletPower;

			// Adjust bullet power based on bot's energy and enemy's energy
			if (bot.getEnergy() < 20) {
				bulletPower = Rules.MIN_BULLET_POWER; // Minimum power to conserve energy
			} else if (bot.enemy.energy < 20) {
				bulletPower = Rules.MAX_BULLET_POWER; // Maximum power to finish off the enemy
			} else {
				bulletPower = Math.min(Rules.MAX_BULLET_POWER, bot.getEnergy() / 10); // Adaptive power
			}

			// Ensure there is enough energy before firing
			bulletPower = Math.min(bulletPower, bot.getEnergy() - 0.1);

			// Add charge level to bullet power
			bulletPower = Math.min(Rules.MAX_BULLET_POWER, bulletPower + chargeLevel);

			bot.bulletPower = bulletPower;
			if (bot.getGunHeat() == 0) {
				Bullet b = bot.setFireBullet(bulletPower);
				bot.registerBullet(b);
				chargeLevel = 0; // Reset charge level after firing
			} else {
				chargeLevel += 0.1; // Increase charge level when not firing
			}
		}
	}

	private double chargeLevel = 0;

}
