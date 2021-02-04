package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

import edu.stuy.starlorn.entities.Ship;

public class GuidedMissileUpgrade extends GunUpgrade {
    public GuidedMissileUpgrade() {
        super();
        _name = "Guided Pissile";
        _description = "Since you suck at aiming.";
	try {
		_voiceLine = new AudioPlayer("/voice/guidedpissle.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public String[] getSprites(String[] sprites) {
        String color = _ownedByPlayer ? "blue" : "purple";
        return new String[]{
            "bullet/missile/"+color+"/1", "bullet/missile/"+color+"/2", "bullet/missile/"+color+"/3",
            "bullet/missile/"+color+"/4", "bullet/missile/"+color+"/5"};
    }

    @Override
    public double getCooldown(double cooldown) {
        return cooldown * 3;
    }

    @Override
    public double getShotSpeed(double shotspeed) {
        return shotspeed * 0.9;
    }

    @Override
    public boolean getSeeking(boolean seeking) {
        return true;
    }

    @Override
    public double getAgility(double agility) {
        return agility + (0.02 / (1 + 3 * agility));
    }

    @Override
    public String getSpriteName() {
        return "upgrade/guidedmissile";
    }

    @Override
    public Upgrade clone() {
        return new GuidedMissileUpgrade();
    }

}
