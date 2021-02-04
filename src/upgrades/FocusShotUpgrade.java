package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class FocusShotUpgrade extends GunUpgrade {

    private int _shotNum;

    public FocusShotUpgrade() {
        super();
        _name = "Crazy Piss";
        _description = "Now you can't piss straight!";
	_shotNum = 0;
	try {
		_voiceLine = new AudioPlayer("/voice/crazypiss.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public int getNumShots(){
	return 1;
    }

    @Override
    public double getAimAngle() {
        int direction = _shotNum;
	_shotNum++;
	if (_shotNum > 400) _shotNum = 0;
	return direction * Math.PI/200;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/doubleshot";
    }

    @Override
    public Upgrade clone() {
        return new FocusShotUpgrade();
    }
}
