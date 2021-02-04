package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class TripleShotUpgrade extends GunUpgrade {
    private int _shotNum;

    public TripleShotUpgrade() {
        super();
        _shotNum = 0;
        _name = "Triple Stream Piss";
        _description = "The rarest kind.";
	try {
		_voiceLine = new AudioPlayer("/voice/triplestream.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public double getCooldown(double cooldown) {
        return cooldown * 2;
    }

    @Override
    public int getNumShots() {
        return 3;
    }

    @Override
    public double getAimAngle() {
        int direction = _shotNum - 1;
        _shotNum++;
        if (_shotNum > 2) _shotNum = 0;
        return direction * Math.PI/8;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/tripleshot";
    }

    @Override
    public Upgrade clone() {
        return new TripleShotUpgrade();
    }
}
