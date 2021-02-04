package edu.stuy.starlorn.upgrades;

import edu.stuy.starlorn.sound.AudioPlayer;

/*
 * A generic upgrade. Modifies aspects of a ship
 */
public class Upgrade {
    protected String _name, _description;
    protected boolean _ownedByPlayer;
    protected AudioPlayer _voiceLine;

    public Upgrade() {
        _name = "Unnamed Upgrade";
        _description = "Upgrade!";
        _ownedByPlayer = false;
	try {
		_voiceLine = new AudioPlayer("/voice/turbopiss.wav", false);
	}catch (Exception e){
		System.out.println("Problem with upgrade voiceline.");
		System.out.println(e.getMessage());
		System.exit(0);
	}
    }

    /*
     * Get the name of the upgrade
     */
    public String getName() {
        return _name;
    }
    /*
     * Get a description to pop up when the upgrade is gathered.
     * Should be quick, and maybe funny
     * If this is an empty string, don't show anything at all
     */
    public String getDescription() {
        return _description;
    }

    public boolean getOwnedByPlayer() {
        return _ownedByPlayer;
    }

    public void setOwnedByPlayer(boolean owned) {
        _ownedByPlayer = owned;
    }

    public String getSpriteName() {
        return "upgrade/generic";
    }

    public void playVoiceLine(){
	try {
		_voiceLine.play();
	}catch (Exception e){
		System.exit(0);
	}
    }

    public void closeVoiceLine(){
	try {
		_voiceLine.close();
	}catch (Exception e){
		System.out.println("voiceline didn't close.");
	}
    }

    public Upgrade clone() {
        return new Upgrade();
    }

}
