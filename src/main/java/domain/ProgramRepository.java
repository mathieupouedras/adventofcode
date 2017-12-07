package domain;

import java.io.File;
import java.util.List;

public interface ProgramRepository {
    List<Program> getAllPrograms();

    File getFile();
}
