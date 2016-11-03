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

        int indexbegin = file.indexOf("Дата выпуска:",0)+24;

                //int indexend = file.indexOf(':',indexbegin);
        String [] output ={"",""};

        output[0] = file.substring(indexbegin+1,indexbegin+9);
        output[1] = "";
        return output;

    }

    @Override
    String findText(String file){

        int begin = file.indexOf("Дата выпуска:",0);
        int first = file.indexOf("\n\n\n",begin)+3;
        //int indexend = file.indexOf(':',indexbegin);
        String output="";
        String fortrim = file.substring(first,file.length());
        fortrim=fortrim.trim();
        if (fortrim.substring(fortrim.length()-1,fortrim.length()-1).equals(".")){;}else{fortrim=fortrim+".";}
        String [] sentences = fortrim.split("[\\\\.\\\\!\\\\?]");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<sentences.length-1;i++){
            sb.append(sentences[i].toString());
            sb.append(".");

        }

        output=sb.toString();
        return output;
    }

}
