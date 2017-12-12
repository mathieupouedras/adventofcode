package infrastructure;

import java.io.File;
import java.net.URL;

class FileRepository {

    File loadFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(filename);
        if (url == null) {
            throw new IllegalArgumentException(String.format(
                    "Cannot find resource with name %s for classLoader %s", filename, classLoader.toString()));
        }

        return new File(url.getFile());
    }
}
