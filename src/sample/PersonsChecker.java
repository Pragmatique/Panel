package sample;

import java.io.IOException;

/**
 * Created by User on 03.01.2016.
 */
public class PersonsChecker {

    public final static String[] persons = {"Порошенко","Яценюк","Путин","Лавров","Кириленко","Кононенко","Савченко","Зарубежные","Ложкин","Гонтарева","Климкин","Садовой","М. Порошенко","Гройсман","Саакашвили","Зубко","Елисеев","Шимкив","А. Филатов","Кубив","Геращенко","Луценко","Райнин","Полторак","Гриценко","Кличко","Ляшко","Муженко","Тигипко","Тимошенко","Турчинов","Тягнибок","Медведчук","Аваков","Ахметов","Коломойский","Пинчук","Шуфрич","Бойко","Кистион","Рабинович","Вилкул","Кутовой","Розенко","Насалик","Омелян","Рева","Квиташвили","Данилюк","Стець","Петренко","Левочкин","Гриневич","Грицак","Фирташ","Климпуш-Цинцадзе","Билоус","Насиров","Пашко","Хромаев","Терентьев","Колесников","Ковальчук","Таранов"};

    public static boolean noWordinExpresion(String file, String expr, String keyword){
        boolean bool1 = false;
        //boolean bool2 = false;
        int indexof=0;
        int i=0;
        int indexof2=0;
        //if ((file.indexOf(keyword,indexof)<0)||(file.indexOf(expr,indexof)<0)){return true;};

        while ((i < file.length())&&(i>0)){
            System.out.println("i="+i);
            if (i==-1){i=file.length();
                return bool1;
            }
            indexof = file.indexOf(keyword,i);
            indexof2= file.indexOf(expr,i);
            if (indexof!=-1){i=indexof+1;}

            if (!(indexof>=indexof2)&&(indexof<=indexof2+expr.length())){
                bool1=true;
                return bool1;
            }
        }
        return bool1;
    }

    public static boolean noWordinExpresions(String file, String[] expr, String keyword){
        boolean bool1 = false;
        boolean bool2 = false;
        int indexof=0;
        int i=0;
        int indexof2=0;
        //if ((file.indexOf(keyword,indexof)<0)||(file.indexOf(expr,indexof)<0)){return true;};

        while ((i < file.length())&&(i>=0)){
            //System.out.println(i);
            //System.out.println(file.length());
            indexof = file.indexOf(keyword,i);
          if (indexof != -1) {
              bool1=false;
              bool2=false;

            for (String ex: expr) {



                indexof2 = file.indexOf(ex, i);


                if ((indexof >= indexof2) && (indexof <= indexof2 + ex.length())&&(indexof2!=-1)) {
                    bool2=true;
                }

                bool1 = bool1||bool2;

            }
              if (bool1==false){return bool1;}
            i = indexof+keyword.length();
           }else {return bool1;}
        }
        return bool1;
    }




    public static boolean isPresidentPoroshenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"порошенк", "президент укра", "гарант конституц","вальцман"};
        String [] bigexpresions = {"блок петра порошенк", "блок порошенк", "блок петро порошенк", "марина порошенк", "марине порошенк", "марини порошенк", "марины порошенк", "блоке петра порошенк", "блоці петра порошенк", "блоку петра порошенк", "блокові петра порошенк"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isPremyer(String file){
        file=file.toLowerCase();
        String [] expresions = {"гройсман", "премьер", "прем’єр", "премєр"};
        String [] bigexpresions = {"віце-прем’єр","віце-премєр", "вице-премьер", "віце прем’єр", "віце премєр", "вице премьер", "екс прем’єр", "екс премєр", "єкс прем’єр", "єкс премєр", "прем’єри"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isPutin(String file){
        file=file.toLowerCase();
        String [] expresions = {"путин", "путін", "президент рф", "президент росии", "президент росії"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isLavrov(String file){
        file=file.toLowerCase();
        String [] expresions = {"лавров", "глава мид рф", "глава мзс рф", "глава мзс росії", "глава мид росии", "министр иностранных дел росии", "міністр закордонних справ росії", "министр иностранных дел рф", "міністр закордонних справ рф"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKirilenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"кириленк"};
        String [] bigexpresions = {"кириленков"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isKononenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"кононенк"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isSavchenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"савченко"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isAbroadPolitics(String file){
        file=file.toLowerCase();
        String [] expresions = {"обама","меркель","олланд","байден","лукашенко","ердоган","єрдоган","грибаускайте","дуда"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isLozhkin(String file){
        file=file.toLowerCase();
        String [] expresions = {"ложкин", "ложкін"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isGontareva(String file){
        file=file.toLowerCase();
        String [] expresions = {"гонтарев","гонтарєв","гонтарэв", "глава нбу", "глава нацбанк", "главу нбу", "главу нацбанк", "главе нбу", "главе нацбанк", "главі нбу", "главі нацбанк", "главой нбу", "главой нацбанк", "главою нбу", "главою нацбанк", "главі нбу", "главе нбу", "главе нацбанк", "главі нацбанк", "голова нбу", "голові нбу", "головою нбу", "голову нбу"};
        String [] bigexpresions = {"екс-глава нбу", "экс-глава нбу","екс-глава нацбанк","экс-глава нацбанк","минулий глава нбу", "бывший глава нбу","глава нацбанк","глава нацбанк","екс-голова нбу", "екс-голові нбу", "екс-головою нбу", "екс-голову нбу"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isKlimkin(String file){
        file=file.toLowerCase();
        String [] expresions = {"климкин", "клімкін", "глава мзс", "глава мид", "глава министерства иносртра", "глава міністерства закорд"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isSadovoy(String file){
        file=file.toLowerCase();
        String [] expresions = {"садовой", "садовий", "мэр львов", "мер львов", "садовый", "мэра львов", "мера львов",
                "мэру львов", "меру львов","мэром львов", "мером львов"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isMPoroshenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"м. порошенко", "марина порошенко", "дружина президента", "супруга президента", "дружина порошенк"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isYatsenyuk(String file){

        file=file.toLowerCase();
        String [] expresions = {"яценюк"};
        String [] bigexpresions = {"якрорь"};
        //String [] bigexpresions = {"якрорь", "спикер генштаб", "спикер генер", "спікер штаб", "спікер генштаб", "спікер генер", "спікер ато", "спікер міністер", "спикер ато", "спикер министер", "спікерам", "спикерам", "спікери", "спикеры", "спікерів", "спикеров", "спикер мвд", "спікер мвс", "спикер сбу", "спікер сбу", "спикер глав", "спікер голов", "спикер адм", "спікер адм", "вице спикер", "віце спікер"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isSaakashvili(String file){
        file=file.toLowerCase();
        String [] expresions = {"саакашвили", "саакашвілі", "губернатор оде", "глава одесской ога", "глава одеської ода"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isZubko(String file){
        file=file.toLowerCase();
        String [] expresions = {"зубко", "министр регионального", "міністр регіонального"};
        String [] bigexpresions = {"зубков"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isEliseev(String file){
        file=file.toLowerCase();
        String [] expresions = {"елисеев", "єлісеєв", "єлісєєв"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isShimkiv(String file){
        file=file.toLowerCase();
        String [] expresions = {"шимкив", "шимків"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isFilatov(String file){
        file=file.toLowerCase();
        String [] expresions = {"филатов", "філатов"};
        String [] bigexpresions = {"борис филатов", "борису филатов", "бориса филатов", "борис філатов", "борису філатов", "бориса філатов", "б. філатов", "б. филатов"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isKubiv(String file){
        //file=file.toLowerCase();
        String [] expresions = {"Кубив", "Кубів","КУБИВ", "КУБІВ"};
        String [] bigexpresions = {"Кубів газ", "Кубів пальн"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isGerashenko(String file){

        file=file.toLowerCase();
        String [] expresions = {"геращенко"};
        String [] bigexpresions = {"антон геращенко", "а. геращенко", "а.геращенко", "зам министра мвд геращенко", "заступник мінистра мвс геращенко"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isLutsenko(String file){

        file=file.toLowerCase();
        String [] expresions = {"луценк", "генпрокурор", "генеральний прокурор", "генеральный прокурор", "генерального прокурор", "генеральному прокурор", "генеральным прокурор", "генеральним прокурор",
                "глава гпу","главе гпу","главі гпу","главой гпу","главою гпу"};
        String [] bigexpresions = {"игорь луценк", "игоря луценк", "игорю луценк","и. луценк", "ігор луценк", "ігоря луценк", "ігору луценк","і. луценк","наталія луценк","наталия луценк",
                "бывший генпрокурор", "колишній генпрокурор","бывшего генпрокурор", "колишнього генпрокурор","бывшему генпрокурор", "колишньому генпрокурор","екс-генпрокурор","экс-генпрокурор","екс генпрокурор","экс генпрокурор",
                "екс-генеральний прокурор", "экс-генеральный прокурор", "екс-генерального прокурор", "екс-генеральному прокурор","экс-генерального прокурор", "экс-генеральному прокурор", "экс-генеральным прокурор", "екс-генеральним прокурор",
                "экс-глава гпу","екс-глава гпу","экс-главе гпу","екс-главі гпу","экс-главой гпу","екс-главою гпу",
                "бывший глава гпу","колишній глава гпу","бывшему главе гпу","колишньому главі гпу","бывшим главой гпу","колишнім главою гпу"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isRaynin(String file){

        file=file.toLowerCase();
        String [] bigexpresions = {
                "экс-глава ап", "бывший глава администрации президент", "колишній глава адміністрації президент", "колишній очільник адміністрації президент", "попередній глава адміністрації президент", "попередній очільник адміністрації президент", "екс-очільник ап",
                "экс-главы ап","екс-глави ап",
                "замглавы администрации президент", "замглава администрации президент", "заместитель главы администрации президент","заместителя главы администрации президент","заступник глави адміністрації президент", "заступника глави адміністрації президент", "заступнику глави адміністрації президент"};
        String [] expresions = {"райнин", "райнін",
                "глава ап", "глава администрации президент", "глава адміністрації президент", "очільник адміністрації президент", "очільник ап",
                "главы ап","глави ап", "главы администрации президент", "глави адміністрації президент", "очільника адміністрації президент", "очільника ап",
                "главе ап","главі ап", "главе администрации президент", "главі адміністрації президент", "очільнику адміністрації президент", "очільнику ап",
                "главой ап", "главою ап", "главой администрации президент", "главою адміністрації президент", "очільником адміністрації президент", "очільником ап"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isPoltorak(String file){
        file=file.toLowerCase();
        String [] expresions = {"полторак", "министр оборон", "міністр оборон", "министру оборон", "міністру оборон", "министра оборон", "міністра оборон"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isGricenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"гриценк"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKlichko(String file){

        file=file.toLowerCase();
        String [] expresions = {"кличк", "мер києв", "мэр киев"};
        String [] bigexpresions = {"владимир кличк", "володимир кличк", "владимира кличк", "володимира кличк","владимиру кличк", "володимиру кличк"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isLyashko(String file){
        file=file.toLowerCase();
        String [] expresions = {"ляшк", "лидер радикальной парт", "лідер радикальної парт"};
        String [] bigexpresions = {"пляшк", "радикальная партия ляшк", "радикальная партия олега ляшк", "радикальная партия о. ляшк", "радикальна партія ляшк", "радикальна партія олега ляшк", "радикальна партія о. ляшк"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isMuzhenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"муженк", "глава генштаб"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isTigibko(String file){
        file=file.toLowerCase();
        String [] expresions = {"тигипк","тигибк"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isTimoshenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"тимошенк"};
        String [] bigexpresions = {"юрий тимошенк", "юрій тимошенк", "юрием тимошенк", "юрієм тимошенк", "юрию тимошенк", "юрію тимошенк", "юрия тимошенк", "юрія тимошенк"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isTurchinov(String file){
        file=file.toLowerCase();
        String [] expresions = {"турчинов", "секретар рнбо", "секретарь рнбо", "секретарь снбо", "глава рнбо", "очільник снбо"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isTyagnibok(String file){
        file=file.toLowerCase();
        String [] expresions = {"тягнибок"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isMedvedchuk(String file){
        file=file.toLowerCase();
        String [] expresions = {"медведчук"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isShokin(String file){
        file=file.toLowerCase();
        String [] expresions = {"шокин","шокін"};
        String [] bigexpresions = {"зам генрокурор"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isAvakov(String file){
        file=file.toLowerCase();
        String [] expresions = {"аваков","глава мвд","глава мвс","министр внутренних","міністр внутрішніх","главе мвд","главі мвс","министру внутренних","міністру внутрішніх","главы мвд","глави мвс","министра внутренних","міністра внутрішніх"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isAkhmetov(String file){
        file=file.toLowerCase();
        String [] expresions = {"ахметов"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKolomoyskiy(String file){
        file=file.toLowerCase();
        String [] expresions = {"коломойск"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isPinchuk(String file){
        file=file.toLowerCase();
        String [] expresions = {"пинчук", "pinchuk"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isShufrich(String file){
        file=file.toLowerCase();
        String [] expresions = {"шуфрич"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isBoyko(String file){
        file=file.toLowerCase();
        String [] expresions = {"бойко","бойка","бойку"};
        String [] bigexpresions = {"игорь бойк", "бойкот"};
        boolean bool = false;
        //boolean bool2 = true;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isKistion(String file){
        file=file.toLowerCase();
        String [] expresions = {"кистион","кістіон","кистіон","кістион"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isRabinovich(String file){
        file=file.toLowerCase();
        String [] expresions = {"рабинович"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isVilkul(String file){
        file=file.toLowerCase();
        String [] expresions = {"вилкул"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKutoviy(String file){
        file=file.toLowerCase();
        String [] expresions = {"кутовий","кутовый","кутовой","министр аграр","міністр аграр"};
        String [] bigexpresions = {"бывший министр аграр", "минулий міністр аграр", "экс министр аграр", "екс міністр аграр"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isRozenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"розенк"};
        String [] bigexpresions = {"розенков"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isNasalik(String file){
        file=file.toLowerCase();
        String [] expresions = {"насалик","министр энерг","міністр енерг","міністр палива","министра энерг","міністра енерг","міністра палива","министру энерг","міністру енерг","міністру палива","министром энерг","міністром енерг","міністром палива","глава мінене","глави мінене","главі мінене","главу мінене","главою мінене"};
        String [] bigexpresions = {"бывший министр энерг", "бывшего министра энерг", "бывшему министру энерг", "бывшим министром энерг","колишній міністр енерг","колишнього міністра енерг","колишньому міністру енерг","колишнім міністром енерг"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isOmelyan(String file){
        file=file.toLowerCase();
        String [] expresions = {"омелян","омельян","міністр інфраструктур","министр инфраструктур","міністра інфраструктур","министра инфраструктур","міністру інфраструктур","министру инфраструктур"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isReva(String file){
        file=file.toLowerCase();
        String [] expresions = {" рева "," реві "," реве "," реву "," ревою ",
                " рева, "," реві, "," реве, "," реву, "," ревою, ",
                " рева. "," реві. "," реве. "," реву. "," ревою. ",
                "министр социальной политики", "министр соцполитики", "министр соц политики", "міністр соціальної політики", "міністр соцполітики", "міністр соц політики"};
        String [] bigexpresions = {"реванш", "ревальвац", "ревуар", "реваж", "подозрева", "гонтарева", "перев", "чрева"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isKvitashvili(String file){
        file=file.toLowerCase();
        String [] expresions = {"квиташвили","квіташвілі","міністр охорони здоров","глава моз","очільник моз","министр здравохранения","глава минздрава"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isDanilyuk(String file){
        file=file.toLowerCase();
        String [] expresions = {"динилюк","министр финансов","міністр фінансів","глава мінфін","глава минфин"};
        String [] bigexpresions = {"бывший министр финанс", "бывшего министра финанс", "бывшему министру финанс", "бывшим министром финанс",
                "колишній міністр фінанс","колишнього міністра фінанс","колишньому міністру фінанс","колишнім міністром фінанс",
                "колишній глава мінфін","колишньому главі мінфін","колишнім главою мінфін","колишнього главу мінфін","колишню главу мінфін",
                "бывший глава минфин", "бывшего главу минфин", "бывшему главе минфин", "бывшим главой минфин", "бывшую главу минфин"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isPetrenko(String file){
        file=file.toLowerCase();
        String [] expresions = {"петренко","министр юстиц","міністр юстиц"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isLevochkin(String file){
        file=file.toLowerCase();
        String [] expresions = {"левочк","лёвочк","льовочк"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isGrinevich(String file){
        file=file.toLowerCase();
        String [] expresions = {"гриневич","гриневіч","міністр освіти","министр образования","міністру освіти","министру образования","міністра освіти","министра образования"};
        boolean bool = false;
        String [] bigexpresions = {"квіташвілі"};
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isGrytsak(String file){
        file=file.toLowerCase();
        String [] expresions = {"грицак","глава сбу","главы сбу","глави сбу","главі сбу","главою сбу","главе сбу","главой сбу"};
        boolean bool = false;
        String [] bigexpresions = {"зам глави сбу", "замглави сбу", "зам главы сбу", "замглавы сбу","замглаву сбу", "заместитель главы сбу","заместителя главы сбу",
                "советник главы сбу","советника главы сбу", "советнику главы сбу", "заступник глави сбу", "радник глави сбу", "радника глави сбу", "раднику глави сбу",
                "апарату глави сбу", "аппарата главы сбу","екс-главою сбу", "экс-главой сбу","бывший глава сбу", "колишній глава сбу","екс-глава сбу",
                "экс-глава сбу","екс-глави сбу", "экс-главы сбу","екс-главі сбу", "экс-главе сбу"};
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isFirtash(String file){
        file=file.toLowerCase();
        String [] expresions = {"фирташ","фірташ"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKlimpushCincadze(String file){
        file=file.toLowerCase();
        String [] expresions = {"климпуш-цинцадзе","клімпуш-цинцадзе"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isBilous(String file){
        file=file.toLowerCase();
        String [] expresions = {"билоус","білоус","глава фонда госимущ","глава фонду держмайн","главе фонда госимущ","главі фонду держмайн","главою фонда госимущ","главою фонду держмайн"};
        boolean bool = false;
        String [] bigexpresions = {"билоусов", "білоусов"};
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isNasirov(String file){
        file=file.toLowerCase();
        String [] expresions = {"насиров","насіров","глава гфс","глава дфс","главе гфс","главі дфс","главу гфс","главу дфс","главой гфс","главою дфс"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isPashko(String file){
        file=file.toLowerCase();
        String [] expresions = {"пашк"};
        boolean bool = false;
        String [] bigexpresions = {"степашк"};
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool = bool||(!noWordinExpresions(file,bigexpresions,ex));
            }
        }
        return bool;
    }

    public static boolean isHromaev(String file){
        file=file.toLowerCase();
        String [] expresions = {"хромаев","хромаєв"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isTerentyev(String file){
        file=file.toLowerCase();
        String [] expresions = {"терент"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKolesnikov(String file){
        file=file.toLowerCase();
        String [] expresions = {"колесников","колесніков"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isKovalchuk(String file){
        file=file.toLowerCase();
        String [] expresions = {"ковальчук"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean isTaranov(String file){
        file=file.toLowerCase();
        String [] expresions = {"таранов"};
        boolean bool = false;
        for (String ex:expresions){
            if(file.indexOf(ex)>-1){
                bool=true;
            }
        }
        return bool;
    }

    public static boolean checkFactory(String person, String file){
        boolean bool = false;

        switch (person) {
            case "Порошенко":
                bool = isPresidentPoroshenko(file);
                break;
            case "Яценюк":
                bool = isYatsenyuk(file);
                break;
            case "Путин":
                bool = isPutin(file);
                break;
            case "Лавров":
                bool = isLavrov(file);
                break;
            case "Кириленко":
                bool = isKirilenko(file);
                break;
            case "Кононенко":
                bool = isKononenko(file);
                break;
            case "Савченко":
                bool = isSavchenko(file);
                break;
            case "Зарубежные":
                bool = isAbroadPolitics(file);
                break;
            case "Ложкин":
                bool = isLozhkin(file);
                break;
            case "Гонтарева":
                bool = isGontareva(file);
                break;
            case "Климкин":
                bool = isKlimkin(file);
                break;
            case "Садовой":
                bool = isSadovoy(file);
                break;
            case "М. Порошенко":
                bool = isMPoroshenko(file);
                break;
            case "Гройсман":
                bool = isPremyer(file);
                break;
            case "Саакашвили":
                bool = isSaakashvili(file);
                break;
            case "Зубко":
                bool = isZubko(file);
                break;
            case "Елисеев":
                bool = isEliseev(file);
                break;
            case "Шимкив":
                bool = isShimkiv(file);
                break;
            case "А. Филатов":
                bool = isFilatov(file);
                break;
            case "Кубив":
                bool = isKubiv(file);
                break;
            case "Геращенко":
                bool = isGerashenko(file);
                break;
            case "Луценко":
                bool = isLutsenko(file);
                break;
            case "Райнин":
                bool = isRaynin(file);
                break;
            case "Полторак":
                bool = isPoltorak(file);
                break;
            case "Гриценко":
                bool = isGricenko(file);
                break;
            case "Кличко":
                bool = isKlichko(file);
                break;
            case "Ляшко":
                bool = isLyashko(file);
                break;
            case "Муженко":
                bool = isMuzhenko(file);
                break;
            case "Тигипко":
                bool = isTigibko(file);
                break;
            case "Тимошенко":
                bool = isTimoshenko(file);
                break;
            case "Турчинов":
                bool = isTurchinov(file);
                break;
            case "Тягнибок":
                bool = isTyagnibok(file);
                break;
            case "Медведчук":
                bool = isMedvedchuk(file);
                break;
            case "Аваков":
                bool = isAvakov(file);
                break;
            case "Ахметов":
                bool = isAkhmetov(file);
                break;
            case "Коломойский":
                bool = isKolomoyskiy(file);
                break;
            case "Пинчук":
                bool = isPinchuk(file);
                break;
            case "Шуфрич":
                bool = isShufrich(file);
                break;
            case "Бойко":
                bool = isBoyko(file);
                break;
            case "Кистион":
                bool = isKistion(file);
                break;
            case "Рабинович":
                bool = isRabinovich(file);
                break;
            case "Вилкул":
                bool = isVilkul(file);
                break;
            case "Кутовой":
                bool = isKutoviy(file);
                break;
            case "Розенко":
                bool = isRozenko(file);
                break;
            case "Насалик":
                bool = isNasalik(file);
                break;
            case "Омелян":
                bool = isOmelyan(file);
                break;
            case "Рева":
                bool = isReva(file);
                break;
            case "Квиташвили":
                bool = isKvitashvili(file);
                break;
            case "Данилюк":
                bool = isDanilyuk(file);
                break;
            case "Стець":
                bool = false;
                break;
            case "Петренко":
                bool = isPetrenko(file);
                break;
            case "Левочкин":
                bool = isLevochkin(file);
                break;
            case "Гриневич":
                bool = isGrinevich(file);
                break;
            case "Грицак":
                bool = isGrytsak(file);
                break;
            case "Фирташ":
                bool = isFirtash(file);
                break;
            case "Климпуш-Цинцадзе":
                bool = isKlimpushCincadze(file);
                break;
            case "Билоус":
                bool = isBilous(file);
                break;
            case "Насиров":
                bool = isNasirov(file);
                break;
            case "Пашко":
                bool = isPashko(file);
                break;
            case "Хромаев":
                bool = isHromaev(file);
                break;
            case "Терентьев":
                bool = isTerentyev(file);
                break;
            case "Колесников":
                bool = isKolesnikov(file);
                break;
            case "Ковальчук":
                bool = isKovalchuk(file);
                break;
            case "Таранов":
                bool = isTaranov(file);
                break;
            default:
                bool=false;

        }

        return bool;


    }



}
