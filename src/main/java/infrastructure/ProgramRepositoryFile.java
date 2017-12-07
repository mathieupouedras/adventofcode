package infrastructure;

import domain.Program;
import domain.ProgramRepository;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProgramRepositoryFile implements ProgramRepository {
    private final String filename;

    public ProgramRepositoryFile(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<>();
        FileParser fileParser = new FileParser(getFile());

        return fileParser.parse();
    }

    @Override
    public File getFile() {
       ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException(String.format("Cannot get file with name : %S", filename));
        }
        return new File(resource.getFile());
    }
}
