package sample;

import java.io.*;

import java.util.Scanner;

import com.lowagie.text.rtf.document.RtfDocument;
import com.lowagie.text.rtf.parser.RtfParser;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;




/**
 * Created by User on 27.12.2015.
 */
public class RadioParser extends TVParser{




    String name="RadioData.xls";

    public RadioParser (String dir, SupportedFileTypes sft)
            throws IOException, WriteException,EmptyFolderException, IndefinedTypeException{
        super(dir,sft);
    }


    @Override
    String findSource(String file){
        //String file = fi;
        int indexbegin = file.indexOf("Источник:",0)+9;
        int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(indexbegin,indexend);
        return output;

        /*char[]charr=file.toCharArray();

        for (int i=0;i<=charr.length;i++){
            char[]testarr=

        }*/
    }

    @Override
    String findDate(String file){
        //String file = fi;
        int indexDate = file.indexOf("Дата выпуска:",0)+14;
        //int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(indexDate,indexDate+10);
        return output;
    }

    @Override
    String findTittle(String file){
        //String file = fi;
        int firstEnter = file.indexOf("\n",0);
        //int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(0,firstEnter-1);
        return output;
    }

    @Override
    String findText(String file){
        int first = file.indexOf("(время эфира)",0)+14;
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

        //sb.append(sentences[0]);
        //sb.append(".");
        //sb.append(sentences[1]);
        //sb.append(".");
        output=sb.toString();
        return output;
    }

    @Override
    String[] findTime(String file){

        int begin = file.indexOf("(время эфира)",0);
        //int indexbegin = file.indexOf("\n",begin);
        //int indexend = file.indexOf(':',indexbegin);
        String [] output ={"",""};

        output[0] = file.substring(begin-17,begin-9);
        output[1] = file.substring(begin-8,begin);
        return output;

    }


}