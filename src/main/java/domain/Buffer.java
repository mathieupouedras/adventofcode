package domain;

import java.util.*;
import java.util.stream.Collectors;

class Buffer {
    private final List<Particule> particules;

    Buffer(List<Particule> particules) {
        this.particules = particules;
    }

    void tick() {
        for (int i = 0; i < particules.size(); i++) {
            Particule particule = particules.get(i);
            Point3D velocity = particule.getVelocity();
            Point3D acceleration = particule.getAcceleration();
            Point3D position = particule.getPosition();

            Point3D newVelocity = new Point3D(
                    velocity.getX().increase(acceleration.getX()),
                    velocity.getY().increase(acceleration.getY()),
                    velocity.getZ().increase(acceleration.getZ())
            );

            Point3D newPosition = new Point3D(
                    position.getX().increase(newVelocity.getX()),
                    position.getY().increase(newVelocity.getY()),
                    position.getZ().increase(newVelocity.getZ())
            );

            Particule newParticule = new Particule(newPosition, newVelocity, particule.getAcceleration());

            newParticule.setManathanDistance(new ManathanDistance(Math.abs(newParticule.getPosition().getX().getValue()) +
                    Math.abs(newParticule.getPosition().getY().getValue()) +
                    Math.abs(newParticule.getPosition().getZ().getValue()))
            );


            particules.set(i, newParticule);

            List<Particule> toBeRemoved = new ArrayList<>();
            for (Particule p : particules) {
                if (p.equals(newParticule)) {
                    continue;
                }
                if (p.getPosition().equals(newParticule.getPosition())) {
                    toBeRemoved.add(p);
                }
            }

            if (!toBeRemoved.isEmpty()) {
                particules.removeAll(toBeRemoved);
                particules.remove(newParticule);
            }
        }
    }

    Particule getClosestParticuleToZERO() {
        int minimum = particules.stream().mapToInt(particule -> particule.getManathanDistance().getValue()).min().getAsInt();
        for (Particule particule : particules) {
            if (particule.getManathanDistance().getValue() == minimum) {
                return particule;
            }
        }
        throw new RuntimeException("Cannot get closest Particule");
    }
}
