package sample;

import java.io.IOException;

import static sample.SupportedFileTypes.*;

/**
 * Created by User on 12.03.2016.
 */
public class FilesFactory {

    String message = "";
    SupportedFileTypes fileType;
    String file ="";


    FilesFactory (String folder){if (!folder.isEmpty()){this.file=file;}else{message="Please set a directory";};};

    FilesFactory (String folder,SupportedFileTypes fileType)throws IndefinedTypeException,EmptyFolderException{

        if (!folder.isEmpty()){this.file=folder;}
        else{message="Please set a directory";throw new EmptyFolderException();};

        for (SupportedFileTypes ftype: values()){
            if (ftype == fileType){this.fileType=fileType; message="FileType is "+fileType.name();}
        }

        if (this.fileType==null){message="Unsupported fileType";throw new IndefinedTypeException();};
    }

    String buildText()throws IndefinedTypeException,IOException{
        String output="";
        switch (fileType){
            case TXT:  try {output = new TxtFilesAsText(file).asText();}
            catch (IOException ex){ex.printStackTrace();}
                break;
            case RTF:  try {output = new RtfFilesAsText(file).asText();}
            catch (IOException ex){ex.printStackTrace();}
                break;
            case DOC:  try {output = new DocFilesAsText(file).asText();}
            catch (IOException ex){ex.printStackTrace();}
                break;
            default: throw new IndefinedTypeException();

        }
        return output;
    };
}
