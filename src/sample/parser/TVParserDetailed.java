package sample.parser;

import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import sample.personChecker.PersonsChecker;
import sample.SupportedFileTypes;
import sample.exception.EmptyFolderException;
import sample.exception.IndefinedTypeException;

import java.io.IOException;

/**
 * Created by User on 19.05.2016.
 */
public class TVParserDetailed extends TVParser {
    public TVParserDetailed (String dir, SupportedFileTypes sft)
            throws IOException, WriteException,EmptyFolderException, IndefinedTypeException {
        super(dir,sft);
    }

    private String detailedParser(String person, String buftext){
        String output = "";
        String[] abzaces=buftext.split("\n");
        for (String abzac:abzaces){
            if (PersonsChecker.checkFactory(person, abzac)==true)output=output+"\n"+abzac;
        }
        return output;
    }

    @Override
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

                for (int j=0;j<63;j++){
                    ws.addCell(new Label(j+6, 0, PersonsChecker.persons[j]));
                }

            }


            ws.addCell(new Label(0, i, findDate(block)));
            ws.addCell(new Label(1, i, findSource(block)));
            ws.addCell(new Label(2, i, findTime(block)[0]));
            ws.addCell(new Label(3, i, findTime(block)[1]));
            ws.addCell(new Label(4, i, findTittle(block)));
            String buftext = findText(block);
            ws.addCell(new Label(5, i, buftext));

            for (int j=0;j<63;j++){

                    if (PersonsChecker.checkFactory(PersonsChecker.persons[j],buftext)==true)
                        ws.addCell(new Label(j+6, i, detailedParser(PersonsChecker.persons[j],buftext)));
                //detailedParser(PersonsChecker.persons[j],buftext)

            }
        }
        catch (RowsExceededException rex){rex.printStackTrace();}
        catch (WriteException rex){rex.printStackTrace();}

    }

}
