package sample.parser;

import jxl.write.WriteException;
import sample.SupportedFileTypes;
import sample.exception.EmptyFolderException;
import sample.exception.IndefinedTypeException;

import java.io.IOException;

/**
 * Created by User on 17.01.2017.
 */
public class PressParser extends LightParser {

    public PressParser (String dir, SupportedFileTypes sft)
            throws IOException, WriteException,EmptyFolderException, IndefinedTypeException {
        super(dir,sft);
    }

    @Override
    String findSource(String file){
        //String file = fi;
        int indexbegin = file.indexOf("Источник:",0)+9;
        int indexend = file.indexOf("Номер выпуска",indexbegin);
        String output;
        output = file.substring(indexbegin,indexend-1).replaceAll("\\s+"," ").trim();
        return output;

    }

    @Override
    String[] findTime(String file){

        int indexbegin = file.indexOf("Номер выпуска:",0)+14;
        int indexend = file.indexOf("Дата выпуска:",indexbegin);

        //int indexend = file.indexOf(':',indexbegin);
        String [] output ={"",""};

        output[0] = file.substring(indexbegin,indexend-1).replaceAll("\\s+"," ").trim();

        output[1] = "";
        return output;

    }

    @Override
    String findText(String file){

        int begin = file.indexOf("Категория источника:",0);
        int first = file.indexOf("\n",begin)+1;
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

        output=sb.toString().trim();
        return output;
    }




}
