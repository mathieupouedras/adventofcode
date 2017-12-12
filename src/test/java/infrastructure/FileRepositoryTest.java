package infrastructure;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FileRepositoryTest {

    private final String UNKNOWN_FILENAME = "UNKNOWN_FILENAME";

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_filename_not_found() {
        FileRepositoryClassloader fileRepository = new FileRepositoryClassloader();

        fileRepository.loadFile(UNKNOWN_FILENAME);
    }

    @Test
    public void should_return_true_if_file_exists() {
        FileRepositoryClassloader fileRepository = new FileRepositoryClassloader();

        assertThat(fileRepository.loadFile("input.txt").exists(), is(true));
    }

}