package sample.controller;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import jxl.write.WriteException;
import sample.*;
import sample.exception.EmptyFolderException;
import sample.exception.IndefinedTypeException;
import sample.fileFactory.FilesFactory;
import sample.fileMerger.FileMerger;
import sample.parser.LightParser;
import sample.parser.RadioParser;
import sample.parser.TVParser;
import sample.parser.TVParserDetailed;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;


public class Controller {

    static String directory = "fdgdg";
    static String msg ="";
    static int indexType = 0;
    static SupportedFileTypes sft;


    @FXML
    Label MyLabel0;

    @FXML
    private void parser(ActionEvent event){


        msg=msg+"\n"+"Processing........";
        MyLabel0.setText(msg);

        try {

            TVParser tvp = new TVParser(directory,sft);
            tvp.start();

        }catch (IOException ex){ex.printStackTrace(); msg=msg+"\n"+ex.getClass().toString();MyLabel0.setText(msg);}
        catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        catch (WriteException we){we.printStackTrace();msg=msg+"\n"+we.getClass().toString();MyLabel0.setText(msg);}
        msg=msg+"\n"+"Process finished";
        MyLabel0.setText(msg);



    }

    @FXML
    private void parserRadio(ActionEvent event){
        msg=msg+"\n"+"Processing........";
        MyLabel0.setText(msg);

        try {

            RadioParser rdp = new RadioParser(directory,sft);
            rdp.start();
        }catch (IOException ex){ex.printStackTrace(); msg=msg+"\n"+ex.getClass().toString();MyLabel0.setText(msg);}
        catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        catch (WriteException we){we.printStackTrace();msg=msg+"\n"+we.getClass().toString();MyLabel0.setText(msg);}

        msg=msg+"\n"+"Process finished";
        MyLabel0.setText(msg);

    }

    @FXML
    private void detailedTVParser(ActionEvent event){
        msg=msg+"\n"+"Processing........";
        MyLabel0.setText(msg);
        //MyLabel0.notifyAll();

        try {

            TVParserDetailed tvpd = new TVParserDetailed(directory,sft);
            tvpd.start();
        }catch (IOException ex){ex.printStackTrace(); msg=msg+"\n"+ex.getClass().toString();MyLabel0.setText(msg);}
        catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        catch (WriteException we){we.printStackTrace();msg=msg+"\n"+we.getClass().toString();MyLabel0.setText(msg);}

        msg=msg+"\n"+"Process finished";
        MyLabel0.setText(msg);

    }

    @FXML
    private void lightParser(ActionEvent event){
        msg=msg+"\n"+"Processing........";
        MyLabel0.setText(msg);
        //MyLabel0.notifyAll();

        try {

            LightParser ltp = new LightParser(directory,sft);
            ltp.start();
        }catch (IOException ex){ex.printStackTrace(); msg=msg+"\n"+ex.getClass().toString();MyLabel0.setText(msg);}
        catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        catch (WriteException we){we.printStackTrace();msg=msg+"\n"+we.getClass().toString();MyLabel0.setText(msg);}

        msg=msg+"\n"+"Process finished";
        MyLabel0.setText(msg);

    }

    @FXML
    private void setTxt(ActionEvent event){

            //indexType=1;
        sft=SupportedFileTypes.TXT;
        try {
            msg = msg + "\n" + new FilesFactory(directory, sft).message;
        }catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}

        MyLabel0.setText(msg);

    }

    @FXML
         private void setRtf(ActionEvent event){

        //indexType=2;
        sft=SupportedFileTypes.RTF;
        try {
            msg=msg+"\n"+new FilesFactory(directory,sft).message;
        }catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        MyLabel0.setText(msg);

    }

    @FXML
    private void setDoc(ActionEvent event){

        //indexType=3;
        sft=SupportedFileTypes.DOC;
        try {
            msg=msg+"\n"+new FilesFactory(directory,sft).message;
        }catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        MyLabel0.setText(msg);

    }

    @FXML
    private void setXls(ActionEvent event){

        //indexType=4;
        sft=SupportedFileTypes.XLS;
        try {
            msg=msg+"\n"+new FilesFactory(directory,sft).message;
        }catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}
        MyLabel0.setText(msg);

    }

    @FXML
    private void merge(ActionEvent event){
        msg=msg+"\n"+"Processing........";
        MyLabel0.setText(msg);

        try {

            FileMerger filemerger = new FileMerger(directory,sft);
            filemerger.merge();
        }catch (IOException ex){ex.printStackTrace(); msg=msg+"\n"+ex.getClass().toString();MyLabel0.setText(msg);}
        catch (IndefinedTypeException ite){msg=msg+"\n"+"Please, set fileType!"+"\n"+ite.getClass().toString();MyLabel0.setText(msg);}
        catch (EmptyFolderException efe){msg=msg+"\n"+"Directory is empty or unhandled"+"\n"+efe.getClass().toString();MyLabel0.setText(msg);}


        msg=msg+"\n"+"Process finished";
        MyLabel0.setText(msg);

    }



    @FXML
    private void chooseDirectory(ActionEvent event)
    {
        String output="";

        try {


            DirectoryChooser dirChooser = new DirectoryChooser();
            dirChooser.setTitle("Choose directory");
            File file = dirChooser.showDialog(null);

            directory = file.getCanonicalPath();
            if (msg.equals(""))msg=msg+directory;
            else msg=msg+"\n"+directory;

            //strprpt.set(directory);
            MyLabel0.setText(msg);

        }catch (IOException ex){ex.printStackTrace();}

    }


}
