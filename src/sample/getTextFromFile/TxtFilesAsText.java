package sample.getTextFromFile;

import sample.getTextFromFile.FilesAsText;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by User on 12.03.2016.
 */
public class TxtFilesAsText extends FilesAsText {




    public TxtFilesAsText(String file) {
        super(file);
    }

    @Override
    public String asText ()throws IOException {
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
