package sample.getTextFromFile;

import sample.getTextFromFile.FilesAsText;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;

/**
 * Created by User on 12.03.2016.
 */
public class RtfFilesAsText extends FilesAsText {

    public RtfFilesAsText(String file) {
        super(file);
    }

    @Override
    public String asText ()throws IOException {

        String bufstr="";

        DefaultStyledDocument styledDoc = new DefaultStyledDocument();



            if (file.getCanonicalPath().endsWith("rtf")) {
                InputStream f = new FileInputStream(file);

                try {

                    RTFEditorKit rtfkt = new RTFEditorKit();

                    rtfkt.read(f, styledDoc, 0);



                    bufstr= new String(styledDoc.getText(0, styledDoc.getLength()).getBytes("ISO-8859-1"),"Windows-1251");

                }catch (BadLocationException ex) {ex.printStackTrace();}
                finally {
                    f.close();
                    try {
                        styledDoc.remove(0,styledDoc.getLength());
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }
                }
            }
        return bufstr;
    };


}
