package entities;

import org.lwjgl.util.vector.Vector3f;

/**
 * Created by xiaoweiwu on 5/14/16.
 */
public class Light {
    private Vector3f position;

    public Light(Vector3f colour, Vector3f position) {
        this.colour = colour;
        this.position = position;
    }

    private Vector3f colour;

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }

    public Vector3f getColour() {
        return colour;
    }

    public void setColour(Vector3f colour) {
        this.colour = colour;
    }
}
