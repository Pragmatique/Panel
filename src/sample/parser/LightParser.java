package sample.parser;

import jxl.write.WriteException;
import sample.SupportedFileTypes;
import sample.exception.EmptyFolderException;
import sample.exception.IndefinedTypeException;

import java.io.IOException;

/**
 * Created by User on 03.11.2016.
 */
public class LightParser extends TVParser {

    public LightParser (String dir, SupportedFileTypes sft)
            throws IOException, WriteException,EmptyFolderException, IndefinedTypeException {
        super(dir,sft);
    }

    @Override
    String[] findTime(String file){

        int indexbegin = file.indexOf("Дата выпуска:",0)+12;

                //int indexend = file.indexOf(':',indexbegin);
        String [] output ={"",""};

        output[0] = file.substring(indexbegin+1,indexbegin+9);
        output[1] = file.substring(indexbegin+10,indexbegin+18);
        return output;

    }

}
