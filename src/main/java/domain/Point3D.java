package domain;

final class Point3D {
    private final Coordinate x;
    private final Coordinate y;
    private final Coordinate z;

    Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Coordinate getX() {
        return x;
    }

    Coordinate getY() {
        return y;
    }

    Coordinate getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point3D point3D = (Point3D) o;

        if (x != null ? !x.equals(point3D.x) : point3D.x != null) return false;
        if (y != null ? !y.equals(point3D.y) : point3D.y != null) return false;
        return z != null ? z.equals(point3D.z) : point3D.z == null;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        result = 31 * result + (z != null ? z.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
