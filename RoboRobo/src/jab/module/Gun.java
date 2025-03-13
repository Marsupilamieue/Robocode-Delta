package jab.module;

import robocode.Bullet;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

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
		if (bot.bulletPower > 0 && bot.getGunHeat() == 0) {
			Bullet b = bot.setFireBullet(bot.bulletPower);
			bot.registerBullet(b);
		}
	}

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			MouseEvent me = (MouseEvent) e;

			if (me.getID() == MouseEvent.MOUSE_PRESSED) {
				switch (me.getButton()) {
				case MouseEvent.BUTTON3:
					bot.bulletPower = 3;
					break;
				case MouseEvent.BUTTON2:
					bot.bulletPower = 2;
					break;
				case MouseEvent.BUTTON1:
					bot.bulletPower = 1;
					break;
				}
			} else if (me.getID() == MouseEvent.MOUSE_RELEASED) {
				bot.bulletPower = 0;
			}
		}
	}

}
