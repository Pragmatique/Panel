package sample;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by User on 12.03.2016.
 */
public class TxtFilesAsText extends FilesAsText {




    TxtFilesAsText(String file) {
        super(file);
    }

    @Override
    String asText ()throws IOException {
        String bufstr="";
        //String output;
        //StringBuilder sb = new StringBuilder();
            if (file.getCanonicalPath().endsWith("txt")) {
                RandomAccessFile f = new RandomAccessFile(file, "r");
                try {

                    byte[] buf = new byte[(int) f.length()];
                    f.read(buf);
                    bufstr= new String(buf, "Windows-1251");
                } finally {
                    f.close();
                }
            }
        return bufstr;
    };
}
