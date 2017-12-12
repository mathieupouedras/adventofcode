package domain;

import java.io.File;

public interface FileRepository {

    public File loadFile(String filename);
}
