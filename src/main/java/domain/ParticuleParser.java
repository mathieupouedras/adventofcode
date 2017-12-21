package domain;

class ParticuleParser {

    Particule parse(String line) {
        String[] points3D = line.split(", ");

        String position = points3D[0];
        position = position.substring(3, position.length() - 1);

        Point3D positionPoint3D = parsePoint3D(position);

        String velocity = points3D[1];
        velocity = velocity.substring(3, velocity.length() - 1);

        Point3D velocityPoint3D = parsePoint3D(velocity);

        String acceleration = points3D[2];
        acceleration = acceleration.substring(3, acceleration.length() - 1);

        Point3D accelerationPoint3D = parsePoint3D(acceleration);


        return new Particule(positionPoint3D, velocityPoint3D, accelerationPoint3D);

    }

    private Point3D parsePoint3D(String position) {
        String[] coordinates = position.split(",");

        Coordinate coordinateX = new Coordinate(Integer.valueOf(coordinates[0]));
        Coordinate coordinateY = new Coordinate(Integer.valueOf(coordinates[1]));
        Coordinate coordinateZ = new Coordinate(Integer.valueOf(coordinates[2]));

        return new Point3D(coordinateX, coordinateY, coordinateZ);
    }
}
