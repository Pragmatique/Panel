package sample.getTextFromFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 12.03.2016.
 */
public abstract class FilesAsText {
    public File file;

    public FilesAsText(String file){this.file=new File(file);};
    public abstract String asText()throws IOException;
}
