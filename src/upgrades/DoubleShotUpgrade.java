package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class DoubleShotUpgrade extends GunUpgrade {
    private boolean _right;

    public DoubleShotUpgrade() {
        super();
        _right = true;
        _name = "Double Stream";
        _description = "Why's it doing that?!";
	try {
		_voiceLine = new AudioPlayer("/voice/doublestream.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public double getCooldown(double cooldown) {
        return cooldown * 1.5;
    }

    @Override
    public int getNumShots() {
        return 2;
    }

    @Override
    public double getAimAngle() {
        int direction = 0;
        if (_right) {
            _right = !_right;
            direction = 1;
        } else if (!_right) {
            _right = !_right;
            direction = -1;
        }
        return direction * Math.PI/8;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/doubleshot";
    }

    @Override
    public Upgrade clone() {
        return new DoubleShotUpgrade();
    }
}
