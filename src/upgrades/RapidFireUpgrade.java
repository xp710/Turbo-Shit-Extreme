package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class RapidFireUpgrade extends GunUpgrade {

    public RapidFireUpgrade() {
        super();
        _name = "Super Piss";
        _description = "Pissing this fast hurts just a little";
	try {
		_voiceLine = new AudioPlayer("/voice/superpiss.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public double getCooldown(double cooldown) {
        return cooldown/2;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/rapidfire";
    }

    @Override
    public Upgrade clone() {
        return new RapidFireUpgrade();
    }

}
