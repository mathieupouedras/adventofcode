package domain;

final class Particule {
    private final Point3D position;
    private final Point3D velocity;
    private final Point3D acceleration;
    private ManathanDistance manathanDistance;

    ManathanDistance getManathanDistance() {
        return manathanDistance;
    }

    void setManathanDistance(ManathanDistance manathanDistance) {
        this.manathanDistance = manathanDistance;
    }

    @Override
    public String toString() {
        return "Particule{" +
                "position=" + position +
                ", velocity=" + velocity +
                ", acceleration=" + acceleration +
                ", manathanDistance=" + manathanDistance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Particule particule = (Particule) o;

        if (position != null ? !position.equals(particule.position) : particule.position != null) return false;
        if (velocity != null ? !velocity.equals(particule.velocity) : particule.velocity != null) return false;
        if (acceleration != null ? !acceleration.equals(particule.acceleration) : particule.acceleration != null)
            return false;
        return manathanDistance != null ? manathanDistance.equals(particule.manathanDistance) : particule.manathanDistance == null;
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + (velocity != null ? velocity.hashCode() : 0);
        result = 31 * result + (acceleration != null ? acceleration.hashCode() : 0);
        result = 31 * result + (manathanDistance != null ? manathanDistance.hashCode() : 0);
        return result;
    }

    Particule(Point3D position, Point3D velocity, Point3D acceleration) {
        this.position = position;
        this.velocity = velocity;

        this.acceleration = acceleration;
    }

    Point3D getPosition() {
        return position;
    }

    Point3D getVelocity() {
        return velocity;
    }

    Point3D getAcceleration() {
        return acceleration;
    }
}
