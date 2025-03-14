package jab.module;

import java.util.Iterator;
import jab.module.BotInfo;

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
		Iterator<BotInfo> iterator = bot.botsInfo.values().iterator();
		double maxEnergy = Double.MIN_VALUE;
		BotInfo selected = null;
		while (iterator.hasNext()) {
			BotInfo e = iterator.next();
			if (maxEnergy < e.energy) {
				selected = e;
				maxEnergy = e.energy;
			}
		}
		bot.enemy = selected;
	}

}
