package domain;

import java.util.List;
import java.util.Set;

class Village {
    Set<Pipe> pipes;
    FileRepository fileRepositonry;

    Village(Set<Pipe> pipes) {
        this.pipes = pipes;
    }
}
