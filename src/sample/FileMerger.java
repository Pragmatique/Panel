package sample;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.*;
import org.apache.poi.hwpf.*;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

/**
 * Created by User on 18.03.2016.
 */
public class FileMerger {

    String folder;
    SupportedFileTypes fileType;
    final String fname = "Merged";

    FileMerger(String folder, SupportedFileTypes fileType){this.folder=folder; this.fileType=fileType;}

    private File[] getFileList(){

        FilenameFilter fln = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(new String(fileType.toString()).toLowerCase())){
                    return true;
                }
                return false;
            }
        };


        return new File(folder).listFiles(fln);
    }

    private void excelMerger(){
        File[] files=getFileList();
        WritableWorkbook workbook = null;
        File file = new File(folder+"\\"+
                fileType.toString()+fname+"."+new String(fileType.toString()).toLowerCase());

        try {
            workbook = Workbook.createWorkbook(file);
            WritableSheet writableSheet = workbook.createSheet("Merged", 0);
            int k=0;


            for (File f:files){
                Workbook w;

                w=Workbook.getWorkbook(f);
                Sheet sheet = w.getSheet(0);
                for (int j = 0; j < sheet.getRows(); j++) {
                    if ((k!=0)&&(j==0)){continue;}

                    for (int i = 0; i < sheet.getColumns(); i++) {

                        Cell cell = sheet.getCell(i, j);
                        //CellType type = cell.getType();
                        writableSheet.addCell(new Label(i,k,cell.getContents()));
                    }
                    k++;
                }
                w.close();
            }
            workbook.write();
        }
         catch (IOException e) { e.printStackTrace();}
        catch (BiffException e) { e.printStackTrace();}
        catch (WriteException e) { e.printStackTrace();}

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }


    }

    private void txtMerger() throws EmptyFolderException, IndefinedTypeException {
        String text="";
        File[] files=getFileList();
        File file = new File(folder+"\\"+
                fileType.toString()+fname+"."+new String(fileType.toString()).toLowerCase());
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (File f:files){
                try{text=text+"\n"+new FilesFactory(f.getCanonicalPath(),fileType).buildText();}
                catch (IndefinedTypeException ite){throw new IndefinedTypeException();}
                catch (EmptyFolderException efe){throw new EmptyFolderException();}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.write(text);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void rtfMerger()throws EmptyFolderException, IndefinedTypeException{
        String text="";
        File[] files=getFileList();
        File file = new File(folder+"\\"+
                fileType.toString()+fname+"."+new String(fileType.toString()).toLowerCase());
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (File f:files){
                try{text=text+"\n"+new FilesFactory(f.getCanonicalPath(),fileType).buildText();}
                catch (IndefinedTypeException ite){throw new IndefinedTypeException();}
                catch (EmptyFolderException efe){throw new EmptyFolderException();}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.write(text);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void docMerger()throws EmptyFolderException, IndefinedTypeException{
        String text="";
        File[] files=getFileList();
        File file = new File(folder+"\\"+
                fileType.toString()+fname+"."+new String(fileType.toString()).toLowerCase());

        /*try{
            FileOutputStream fos = new FileOutputStream(file);
        XWPFDocument doc = new XWPFDocument();
            XWPFParagraph para = doc.createParagraph();
            XWPFRun rh = para.createRun();
            rh.setText("This is a Paragraph");
            rh.setFontSize(12);

        //Range range = doc.getRange();
        //CharacterRun run=range.insertBefore(text);
        //run.setData(true);

        doc.write(fos);
        fos.close();
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}*/



        for (File f:files) {
            try {
                text = text + "\n" + new FilesFactory(f.getCanonicalPath(), fileType).buildText();
            } catch (IndefinedTypeException ite) {
                throw new IndefinedTypeException();
            } catch (EmptyFolderException efe) {
                throw new EmptyFolderException();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    XWPFDocument doc = new XWPFDocument();

                    XWPFParagraph para = doc.createParagraph();
                    XWPFRun rh = para.createRun();
                    rh.setText(text);
                    //rh.setFontSize(12);
                    //Range range = doc.getRange();
                    //CharacterRun run=range.insertBefore(text);
                    //run.setData(true);
                    doc.write(fos);
                    fos.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void docMergergood()throws EmptyFolderException{
        String text="";
        File[] files=getFileList();
        if (files==null){throw new EmptyFolderException();}
        File file = new File(folder+"\\"+
                fileType.toString()+fname+"."+new String(fileType.toString()).toLowerCase());
        try{
        XWPFDocument doc = new XWPFDocument();

            for (File f:files){
                FileInputStream fis=new FileInputStream(f);

                HWPFDocument doc1 = new HWPFDocument(fis);
                WordExtractor we = new WordExtractor(doc1);
                for (String s:we.getParagraphText()){
                    XWPFParagraph pr = doc.createParagraph();
                    XWPFRun rh=pr.createRun();
                    rh.setText(s);
                }

                /*XWPFDocument dc=new XWPFDocument(fis);
                for (XWPFParagraph para:dc.getParagraphs()){
                    XWPFParagraph pr = doc.createParagraph();
                    pr=para;
                }
                fis.close();*/



            }

            FileOutputStream fos = new FileOutputStream(file);
            doc.write(fos);
            fos.close();

        }catch(IOException e){e.printStackTrace();}



    }

    void merge()throws IndefinedTypeException,EmptyFolderException, IOException{

        switch (fileType){
            case TXT:  txtMerger();
                break;
            case RTF:  rtfMerger();
                break;
            case DOC:  docMergergood();
                break;
            case XLS:  excelMerger();
                break;
            default: throw new IndefinedTypeException();

        }

    };


}
