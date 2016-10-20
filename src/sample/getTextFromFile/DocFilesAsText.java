package sample.getTextFromFile;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import sample.getTextFromFile.FilesAsText;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by User on 12.03.2016.
 */
public class DocFilesAsText extends FilesAsText {

    public DocFilesAsText(String file) {
        super(file);
    }

    @Override
    public String asText ()throws IOException {
        String bufstr="";

        NPOIFSFileSystem fs=new NPOIFSFileSystem();
        try
        {
            fs = new NPOIFSFileSystem(file);
        }
        catch (IOException e)
        {
            // an I/O error occurred, or the File did not provide a compatible
            // POIFS data structure
            e.printStackTrace();
        }
        DirectoryEntry root = fs.getRoot();


            if (file.getCanonicalPath().endsWith("doc")) {
                FileInputStream f = new FileInputStream(file);
                try {
                HWPFDocument doc = new HWPFDocument(f);// throws IOException and need to import org.apache.poi.hwpf.HWPFDocument;
                WordExtractor wordExtract = new WordExtractor(doc);
                    //System.out.println(wordExtract.getText());
                    bufstr = wordExtract.getText();
                } finally {
                    f.close();
                }
            }

        return bufstr;
    }

}
