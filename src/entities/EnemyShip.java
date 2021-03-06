package edu.stuy.starlorn.entities;

import java.awt.Graphics2D;
import java.awt.Color;

import edu.stuy.starlorn.world.Path;
import edu.stuy.starlorn.util.Preferences;
import edu.stuy.starlorn.sound.AudioPlayer;

public class EnemyShip extends Ship {

    protected Path path;
    protected int pathIndex; // Index of our location on the path

    private boolean killedByPlayer, killedByCollision;
    private AudioPlayer ap;

    public EnemyShip() {
        super("enemy/straight");
        shootRequested = true; // shoot as often as possible
        baseAim = 3 * Math.PI / 2; // Aim down
        path = null;
        pathIndex = 0;
        killedByPlayer = killedByCollision = false;
	try {
	    ap = new AudioPlayer("/voice/enemydie.wav", false);
	}catch (Exception e){
	    System.out.println(e.getMessage());
	    System.exit(0);
	}
    }

    public EnemyShip(Path p) {
        this();
        path = p;
        rect.x = path.getCoords(0)[0];
        rect.y = path.getCoords(0)[1];
        if (rect.x <= rect.width)  // Hack to force spawning offscreen
            rect.x -= rect.width;
    }

    public EnemyShip clone() {
        EnemyShip e = new EnemyShip(path);
        clone(e);
        return e;
    }

    @Override
    public boolean isHit(Bullet b) {
        if (b.wasFiredByPlayer() && super.isHit(b)) {
            killedByPlayer = true;
	    ap.play();
            return true;
        }
        return false;
    }

    @Override
    public void step() {
        if (path != null) {
            double relativeX = path.getCoords(pathIndex)[0] - rect.x,
                   relativeY = path.getCoords(pathIndex)[1] - rect.y,
                   theta = Math.atan2(relativeY, relativeX),
                   dist = Math.sqrt(Math.pow(relativeX, 2) + Math.pow(relativeY, 2));

            double targetxvel = maxSpeed * Math.cos(theta);
            double targetyvel = maxSpeed * Math.sin(theta);

            updateSprite("enemy/straight");

            if (targetxvel < 0 && xvel > targetxvel) {
                xvel -= .3;
                updateSprite("enemy/left");
            } else if (targetxvel > 0 && xvel < targetxvel) {
                xvel += .3;
                updateSprite("enemy/right");
            }
            if (targetyvel < 0 && yvel > targetyvel) {
                yvel -= .3;
            } else if (targetyvel > 0 && yvel < targetyvel) {
                yvel += .3;
            }

            if (dist <= maxSpeed)
                pathIndex++;
            if (pathIndex >= path.getPathLength()) {
                kill();
                return;
            }
        }
        super.step();
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);
        if (Preferences.getValue("devMode") == 1) {
            graphics.setColor(Color.GREEN);
            graphics.drawLine((int) getRect().x + (int) getRect().width/2, (int) getRect().y + (int) getRect().height/2, getPath().getCoords(pathIndex)[0], getPath().getCoords(pathIndex)[1]);
        }
    }

    public long getScoreValue() {
        long score = 100;
        if (killedByCollision)
            score -= 50;
        score += getNumUpgrades() * 25;
        return score;
    }

    @Override
    public Ship getNearestTarget() {
        return world.getPlayer();
    }

    public void setPath(Path p) {
        path = p;
    }

    public Path getPath() {
        return path;
    }

    public int getPathIndex() {
        return pathIndex;
    }

    public boolean wasKilledByPlayer() {
        return killedByPlayer;
    }

    public void setKilledByPlayer(boolean value) {
        killedByPlayer = value;
    }

    public boolean wasKilledByCollision() {
        return killedByCollision;
    }

    public void setKilledByCollision(boolean value) {
        killedByCollision = value;
    }
}
