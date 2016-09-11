package sample;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 12.03.2016.
 */
public abstract class FilesAsText {
    File file;

    FilesAsText(String file){this.file=new File(file);};
    abstract String asText()throws IOException;
}
