package jab.module;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */

public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		java.util.Iterator<jab.module.BotInfo> iterator = bot.botsInfo.values().iterator();
		double minDistance = Double.MAX_VALUE;
		jab.module.BotInfo selected = null;

		while (iterator.hasNext()) {
			jab.module.BotInfo botInfo = iterator.next();
			if ((!botInfo.teammate) && minDistance > botInfo.distance) {
				selected = botInfo;
				minDistance = botInfo.distance;
			}
		}

		bot.enemy = selected;
	}

}
