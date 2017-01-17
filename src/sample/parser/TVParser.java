package sample.parser;

import java.io.*;

import java.util.Scanner;

import jxl.Workbook;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import sample.fileFactory.FilesFactory;
import sample.personChecker.PersonsChecker;
import sample.SupportedFileTypes;
import sample.exception.EmptyFolderException;
import sample.exception.IndefinedTypeException;

//import org.apache.poi.hwpf.HWPFDocument;
//import org.apache.poi.hwpf.extractor.WordExtractor;




/**
 * Created by User on 27.12.2015.
 */
public class TVParser implements XParser{

    private String name="Data.xls";

    private String folder;
    //static int indexmethod;
    SupportedFileTypes sft;

    public TVParser (String dir, SupportedFileTypes sft)
            throws IOException, WriteException,EmptyFolderException, IndefinedTypeException {
        folder=dir;this.sft=sft;
        if (dir==null){throw new EmptyFolderException();}
        if (sft==null){throw new IndefinedTypeException();}

    }


    String booltoString (boolean bool){
        if (bool ==true){return new String("1");}else{return new String("");}
    }

    void toExcel (WritableSheet ws, int i, String block){
        WritableCellFormat integerFormat = new WritableCellFormat (NumberFormats.INTEGER);
        DateFormat customDateFormat = new DateFormat ("dd mm yyyy");

        try {
            if (i==1){

                ws.addCell(new Label(0, 0, "Дата"));
                ws.addCell(new Label(1, 0, "Источник"));
                ws.addCell(new Label(2, 0, "Start time"));
                ws.addCell(new Label(3, 0, "End time"));
                ws.addCell(new Label(4, 0, "Заголовок"));


                ws.addCell(new Label(5, 0, "Текст"));

                ws.addCell(new Label(6, 0,"Порошенко"));
                ws.addCell(new Label(7, 0,"Яценюк"));
                ws.addCell(new Label(8, 0,"Путин"));
                ws.addCell(new Label(9, 0,"Лавров"));
                ws.addCell(new Label(10, 0,"Кириленко"));
                ws.addCell(new Label(11, 0,"Кононенко"));
                ws.addCell(new Label(12, 0,"Савченко"));
                ws.addCell(new Label(13, 0,"Зарубежные"));
                ws.addCell(new Label(14, 0,"Ложкин"));
                ws.addCell(new Label(15, 0,"Гонтарева"));
                ws.addCell(new Label(16, 0,"Климкин"));
                ws.addCell(new Label(17, 0,"Садовой"));
                ws.addCell(new Label(18, 0,"М. Порошенко"));
                ws.addCell(new Label(19, 0,"Гройсман"));
                ws.addCell(new Label(20, 0,"Саакашвили"));
                ws.addCell(new Label(21, 0,"Зубко"));
                ws.addCell(new Label(22, 0,"Елисеев"));
                ws.addCell(new Label(23, 0,"Шимкив"));
                ws.addCell(new Label(24, 0,"А. Филатов"));
                ws.addCell(new Label(25, 0,"Кубив"));
                ws.addCell(new Label(26, 0,"Геращенко"));
                ws.addCell(new Label(27, 0,"Луценко"));
                ws.addCell(new Label(28, 0,"Райнин"));
                ws.addCell(new Label(29, 0,"Полторак"));
                ws.addCell(new Label(30, 0,"Гриценко"));
                ws.addCell(new Label(31, 0,"Кличко"));
                ws.addCell(new Label(32, 0,"Ляшко"));
                ws.addCell(new Label(33, 0,"Муженко"));
                ws.addCell(new Label(34, 0,"Тигипко"));
                ws.addCell(new Label(35, 0,"Тимошенко"));
                ws.addCell(new Label(36, 0,"Турчинов"));
                ws.addCell(new Label(37, 0,"Тягнибок"));
                ws.addCell(new Label(38, 0,"Медведчук"));
                ws.addCell(new Label(39, 0,"Аваков"));
                ws.addCell(new Label(40, 0,"Ахметов"));
                ws.addCell(new Label(41, 0,"Коломойский"));
                ws.addCell(new Label(42, 0,"Пинчук"));
                ws.addCell(new Label(43, 0,"Шуфрич"));
                ws.addCell(new Label(44, 0,"Бойко"));
                ws.addCell(new Label(45, 0,"Кистион"));
                ws.addCell(new Label(46, 0,"Рабинович"));
                ws.addCell(new Label(47, 0,"Вилкул"));
                ws.addCell(new Label(48, 0,"Кутовой"));
                ws.addCell(new Label(49, 0,"Розенко"));
                ws.addCell(new Label(50, 0,"Насалик"));
                ws.addCell(new Label(51, 0,"Омелян"));
                ws.addCell(new Label(52, 0,"Рева"));
                ws.addCell(new Label(53, 0,"Квиташвили"));
                ws.addCell(new Label(54, 0,"Данилюк"));
                ws.addCell(new Label(55, 0,"Стець"));
                ws.addCell(new Label(56, 0,"Петренко"));
                ws.addCell(new Label(57, 0,"Левочкин"));
                ws.addCell(new Label(58, 0,"Гриневич"));
                ws.addCell(new Label(59, 0,"Грицак"));
                ws.addCell(new Label(60, 0,"Фирташ"));
                ws.addCell(new Label(61, 0,"Климпуш-Цинцадзе"));
                ws.addCell(new Label(62, 0,"Билоус"));
                ws.addCell(new Label(63, 0,"Насиров"));
                ws.addCell(new Label(64, 0,"Пашко"));
                ws.addCell(new Label(65, 0,"Хромаев"));
                ws.addCell(new Label(66, 0,"Терентьев"));
                ws.addCell(new Label(67, 0,"Колесников"));
                ws.addCell(new Label(68, 0,"Ковальчук"));
                ws.addCell(new Label(69, 0,"Таранов"));

            }


        ws.addCell(new Label(0, i, findDate(block)));
        ws.addCell(new Label(1, i, findSource(block)));
        ws.addCell(new Label(2, i, findTime(block)[0]));
        ws.addCell(new Label(3, i, findTime(block)[1]));
        ws.addCell(new Label(4, i, findTittle(block)));
            String buftext = findText(block);
        ws.addCell(new Label(5, i, buftext));

            ws.addCell(new Label(6, i,booltoString(PersonsChecker.isPresidentPoroshenko(buftext))));
            ws.addCell(new Label(7, i,booltoString(PersonsChecker.isYatsenyuk(buftext))));
            ws.addCell(new Label(8, i,booltoString(PersonsChecker.isPutin(buftext))));
            ws.addCell(new Label(9, i,booltoString(PersonsChecker.isLavrov(buftext))));
            ws.addCell(new Label(10, i,booltoString(PersonsChecker.isKirilenko(buftext))));
            ws.addCell(new Label(11, i,booltoString(PersonsChecker.isKononenko(buftext))));
            ws.addCell(new Label(12, i,booltoString(PersonsChecker.isSavchenko(buftext))));
            ws.addCell(new Label(13, i,booltoString(PersonsChecker.isAbroadPolitics(buftext))));
            ws.addCell(new Label(14, i,booltoString(PersonsChecker.isLozhkin(buftext))));
            ws.addCell(new Label(15, i,booltoString(PersonsChecker.isGontareva(buftext))));
            ws.addCell(new Label(16, i,booltoString(PersonsChecker.isKlimkin(buftext))));
            ws.addCell(new Label(17, i,booltoString(PersonsChecker.isSadovoy(buftext))));
            ws.addCell(new Label(18, i,booltoString(PersonsChecker.isMPoroshenko(buftext))));
            ws.addCell(new Label(19, i,booltoString(PersonsChecker.isPremyer(buftext))));
            ws.addCell(new Label(20, i,booltoString(PersonsChecker.isSaakashvili(buftext))));
            ws.addCell(new Label(21, i,booltoString(PersonsChecker.isZubko(buftext))));
            ws.addCell(new Label(22, i,booltoString(PersonsChecker.isEliseev(buftext))));
            ws.addCell(new Label(23, i,booltoString(PersonsChecker.isShimkiv(buftext))));
            ws.addCell(new Label(24, i,booltoString(PersonsChecker.isFilatov(buftext))));
            ws.addCell(new Label(25, i,booltoString(PersonsChecker.isKubiv(buftext))));
            ws.addCell(new Label(26, i,booltoString(PersonsChecker.isGerashenko(buftext))));
            ws.addCell(new Label(27, i,booltoString(PersonsChecker.isLutsenko(buftext))));
            ws.addCell(new Label(28, i,booltoString(PersonsChecker.isRaynin(buftext))));
            ws.addCell(new Label(29, i,booltoString(PersonsChecker.isPoltorak(buftext))));
            ws.addCell(new Label(30, i,booltoString(PersonsChecker.isGricenko(buftext))));
            ws.addCell(new Label(31, i,booltoString(PersonsChecker.isKlichko(buftext))));
            ws.addCell(new Label(32, i,booltoString(PersonsChecker.isLyashko(buftext))));
            ws.addCell(new Label(33, i,booltoString(PersonsChecker.isMuzhenko(buftext))));
            ws.addCell(new Label(34, i,booltoString(PersonsChecker.isTigibko(buftext))));
            ws.addCell(new Label(35, i,booltoString(PersonsChecker.isTimoshenko(buftext))));
            ws.addCell(new Label(36, i,booltoString(PersonsChecker.isTurchinov(buftext))));
            ws.addCell(new Label(37, i,booltoString(PersonsChecker.isTyagnibok(buftext))));
            ws.addCell(new Label(38, i,booltoString(PersonsChecker.isMedvedchuk(buftext))));
            ws.addCell(new Label(39, i,booltoString(PersonsChecker.isAvakov(buftext))));
            ws.addCell(new Label(40, i,booltoString(PersonsChecker.isAkhmetov(buftext))));
            ws.addCell(new Label(41, i,booltoString(PersonsChecker.isKolomoyskiy(buftext))));
            ws.addCell(new Label(42, i,booltoString(PersonsChecker.isPinchuk(buftext))));
            ws.addCell(new Label(43, i,booltoString(PersonsChecker.isShufrich(buftext))));
            ws.addCell(new Label(44, i,booltoString(PersonsChecker.isBoyko(buftext))));
            ws.addCell(new Label(45, i,booltoString(PersonsChecker.isKistion(buftext))));
            ws.addCell(new Label(46, i,booltoString(PersonsChecker.isRabinovich(buftext))));
            ws.addCell(new Label(47, i,booltoString(PersonsChecker.isVilkul(buftext))));
            ws.addCell(new Label(48, i,booltoString(PersonsChecker.isKutoviy(buftext))));
            ws.addCell(new Label(49, i,booltoString(PersonsChecker.isRozenko(buftext))));
            ws.addCell(new Label(50, i,booltoString(PersonsChecker.isNasalik(buftext))));
            ws.addCell(new Label(51, i,booltoString(PersonsChecker.isOmelyan(buftext))));
            ws.addCell(new Label(52, i,booltoString(PersonsChecker.isReva(buftext))));
            ws.addCell(new Label(53, i,booltoString(PersonsChecker.isKvitashvili(buftext))));
            ws.addCell(new Label(54, i,booltoString(PersonsChecker.isDanilyuk(buftext))));
            ws.addCell(new Label(55, i,""));
            ws.addCell(new Label(56, i,booltoString(PersonsChecker.isPetrenko(buftext))));
            ws.addCell(new Label(57, i,booltoString(PersonsChecker.isLevochkin(buftext))));
            ws.addCell(new Label(58, i,booltoString(PersonsChecker.isGrinevich(buftext))));
            ws.addCell(new Label(59, i,booltoString(PersonsChecker.isGrytsak(buftext))));
            ws.addCell(new Label(60, i,booltoString(PersonsChecker.isFirtash(buftext))));
            ws.addCell(new Label(61, i,booltoString(PersonsChecker.isKlimpushCincadze(buftext))));
            ws.addCell(new Label(62, i,booltoString(PersonsChecker.isBilous(buftext))));
            ws.addCell(new Label(63, i,booltoString(PersonsChecker.isNasirov(buftext))));
            ws.addCell(new Label(64, i,booltoString(PersonsChecker.isPashko(buftext))));
            ws.addCell(new Label(65, i,booltoString(PersonsChecker.isHromaev(buftext))));
            ws.addCell(new Label(66, i,booltoString(PersonsChecker.isTerentyev(buftext))));
            ws.addCell(new Label(67, i,booltoString(PersonsChecker.isKolesnikov(buftext))));
            ws.addCell(new Label(68, i,booltoString(PersonsChecker.isKovalchuk(buftext))));
            ws.addCell(new Label(69, i,booltoString(PersonsChecker.isTaranov(buftext))));
        }
        catch (RowsExceededException rex){rex.printStackTrace();}
        catch (WriteException rex){rex.printStackTrace();}
    }

    String findSource(String file){
        //String file = fi;
        int indexbegin = file.indexOf("Источник:",0)+9;
        int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(indexbegin,indexend).replaceAll("\\s+"," ").trim();
        return output;

    }

    String findDate(String file){
        //String file = fi;
        int indexDate = file.indexOf("Дата выпуска:",0)+14;
        //int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(indexDate,indexDate+10).replaceAll("\\s+"," ").trim();
        return output;
    }

    String findTittle(String file){
        //String file = fi;
        int firstEnter = file.indexOf("\n",0);
        //int indexend = file.indexOf(':',indexbegin);
        String output;
        output = file.substring(0,firstEnter-1).replaceAll("\\s+"," ").trim();
        return output;
    }

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

        output=sb.toString().trim();
        return output;
    }

    String[] findTime(String file){

        int begin = file.indexOf("Сюжет №",0);
        int indexbegin = file.indexOf("\n",begin);
        //int indexend = file.indexOf(':',indexbegin);
        String [] output ={"",""};

        output[0] = file.substring(indexbegin+1,indexbegin+9).trim();
        output[1] = file.substring(indexbegin+10,indexbegin+18).trim();
        return output;

    }

    File[] getFileList(String folder){

        FilenameFilter fln = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(new String(sft.toString()).toLowerCase())){
                    return true;
                }
                return false;
            }
        };


        return new File(folder).listFiles(fln);
    }

    public void start() throws IOException, IndefinedTypeException, EmptyFolderException{
        String text="";


        for (File f:getFileList(folder)){
            try{text=text+new FilesFactory(f.getCanonicalPath(),sft).buildText();}
            catch (IndefinedTypeException ite){throw new IndefinedTypeException();}
            catch (EmptyFolderException efe){throw new EmptyFolderException();}
        }




        File newfile = new File(folder+"\\"+name);
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(newfile);
            WritableSheet writableSheet = workbook.createSheet("Data", 0);

            Scanner sc = new Scanner(System.in, "utf-8");
            System.setProperty("console.encoding", "utf-8");
            Scanner sc1 = new Scanner(System.in);
            PrintStream ps = new PrintStream(System.out);

            String[] blocks = text.split("Заглавие:");
            for (int i = 1; i < blocks.length; i++) {
                toExcel(writableSheet,i,blocks[i]);
            }
            workbook.write();
            workbook.close();

        }catch (WriteException rex){rex.printStackTrace();}//catch (IOException e){}

    }

}
