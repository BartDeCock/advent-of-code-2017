package adventofcode.day20;

import static java.lang.Math.abs;

public class Particle {
    private int id;
    private Position position;
    private Velocity velocity;
    private Acceleration acceleration;

    public Particle(int id, Position position, Velocity velocity, Acceleration acceleration) {
        this.id = id;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "id=" + id +
                ", position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                '}';
    }

    public Particle tick() {
        velocity.add(acceleration);
        position.add(velocity);
        return this;
    }


    public long distance() {
        return abs(position.x) + abs(position.y) + abs(position.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Particle particle = (Particle) o;

        return position.equals(particle.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
