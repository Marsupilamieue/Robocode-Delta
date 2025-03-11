package jab; 

import jab.module.*; 
import jab.module.Module; 
import java.awt.Color; 

public   class  ModuleBot  extends Module {
	

	protected void initialize() {
		// TODO Customize the colors here
		setBodyColor(Color.BLACK);
		setGunColor(Color.BLACK);
		setRadarColor(Color.BLACK);
		setScanColor(Color.BLUE);
		setBulletColor(Color.RED);
	}

	

	protected void selectBehavior() {
		radar = getSelectedRadar();
		movement = getSelectedMovement();
		targeting = getSelectedTargeting();
		selectEnemy = getSelectedSelectEnemy();
		gun = getSelectedGun();
	}

	
	protected Radar getSelectedRadar() {		
		return new Radar(this);
	}

	
	protected Targeting getSelectedTargeting() {		
		return new Targeting(this);
	}

	
	protected Movement getSelectedMovement() {		
		return new Movement(this);
	}

	
	protected SelectEnemy getSelectedSelectEnemy() {
		return new SelectEnemy(this); 
	}

	
	protected Gun getSelectedGun() {		
		return new Gun(this);
	}


}
