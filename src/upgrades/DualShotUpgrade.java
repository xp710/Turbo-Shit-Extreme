package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

public class DualShotUpgrade extends GunUpgrade {
    private boolean _right;

    public DualShotUpgrade() {
        super();
        _right = true;
        _name = "Extra Urethra";
        _description = "Twice the piss!";
	try {
		_voiceLine = new AudioPlayer("/voice/extraurethra.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    @Override
    public int getNumShots() {
        return 2;
    }

    @Override
    public double getXOffset() {
        int direction = 0;
        if (_right) {
            _right = !_right;
            direction = 1;
        } else if (!_right) {
            _right = !_right;
            direction = -1;
        }
        return direction * 20;
    }

    @Override
    public String getSpriteName() {
        return "upgrade/dualshot";
    }

    @Override
    public Upgrade clone() {
        return new DualShotUpgrade();
    }
}
