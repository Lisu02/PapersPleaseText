package org.example.DaneGryDoGenerowania;

import java.util.Arrays;
import java.util.Random;

public class ZbiorTwarzy {

    private static String[][] twarze;
    private static Random random = new Random();
    static {
         String[] twarz1 = {
                "........................................",
                "..............'''',,,,,,,''''...........",
                ".............',;:lodooolc;,,''..........",
                "...........,:cldk0KKKKK0Okoc:,'.........",
                ".........,:clokKKKKKKKKKKK0xol:,'.......",
                "....''';llllldkO00KKKKKKKKOkxolll;''....",
                "....''':lolllllodxOOOOOOkkxdddollc,''...",
                "...'''';clllcccccloooollc::ccccc;,''''..",
                ".',,'''';lc;;;,,,;;:clol;''',;;;,'''''..",
                "';c:,'',:c:;;,,,,;:oxxl;,''',::c:,'',;'.",
                "',;;:,,:lc:;,'''',lOK0o,''''''',;,',;;,'",
                "',:;;;,:looolc:,,cdO00k:'',;;;;;;,'',:;'",
                "',:;;;,:looolc:,,cdO00k:'',;;;;;;,'',:;'",
                ".,',,'',;cdoc:;,,;:ccc:,'',:lol;''',,;,.",
                "..,::,'',;;;;;;,,,,''''',',;::;''',;,'..",
                "...''.''',,;;;,,;;;;'',;:;',;:;'''......",
                "........',,'';:::ccc::cccc;'',,'........",
                "........'''',clccccccc:clo:,'''.........",
                "''.......'''';;,''''''',;:;''''.........",
                "''........'''''''''''''''''''.......''''",
                "'''.........''''''''''''''''........''''",
                "'''....'......''''''''''............''''"
        };
         //////
         String[] twarz2 = {
                "...............'',;;;;;;,''.............",
                "...........';:cloooodooooolc:,'.........",
                ".......,::clodxkkkOkkkkkxdoodol:'.......",
                ".....,coddodk0KKKKKKKKKKK0kdooooc,......",
                ".....:ooooxOKKKKKKKKKKKKKKKOdooool;.....",
                ".....:oooodxkOO00KKKKK0OOkkxdooooo:.....",
                ".....:olccccclodxxxkkkxdolllcclloo:.....",
                ".....''':llll:,,;::ccc:;,,;cllc;;;'.....",
                ".''...,d0KKKK0o'....'...lkOKKK0kl,..',..",
                "'c;...,xKKKKK0d'':,;l:''o0KKKKK0d,..';;.",
                ":c,.,:',ldodl:'.,ddldl:,,;clodl;...';c:'",
                "cl,.;dxl,...,,''o0Ol::oo:,.''.';:'..,lc'",
                "':;''cddollll:',x0kc,,,coollllll:'.':c,.",
                "..,'.'coooooc;'.;lo:,.';loooooo;....''..",
                "......;oooooooc'..'..'cooooooooc,.......",
                "......:oooooooo;...,:coooooooool,.......",
                ".......:oooooolc:,,:llllooooooo:........",
                ".......,looool;;:cc:;:;;coooool;..,,....",
                ".....''.;ooooooolcc:;:looooool,.',;,....",
                ".....,,'.:ooooooolccccooooool;.',;;;'...",
                "....,::,..:ooooooooooooooool;.',;;;;,'..",
                "...':lc:;'',:looooooooooll:'.',;;;;;;,.."
        };
         ////////////
         String[] twarz3 = {
                "dddddddddddddddddddddddddddddddddddddddd",
                "dddddddddddollc::::clllllllloddddddddddd",
                "dddddddddoc;,,,,,',,,,,,,,,,;coddddddddd",
                "ddddddddd:,,,,,,,,,,',,,,,,,,,;cdddddddd",
                "dddddddoc;,,,',,,,',,,,,,,,,,,,,codddddd",
                "dddddoc;,,'',,',,',;;;;;,,,,,,,',;oddddd",
                "ddddo:,',,,,,,,;:codddddl,,,',,',,:odddd",
                "ddddd:',,,,,,:oddddddddddl,,,,,,,,,:oddd",
                "ddddl;',,,,:odddddddddddddo:;,,',,':oddd",
                "dddd:,,',',coolccclodoolc:lolc;,,,,:dddd",
                "ddddo:',;,,;;;,,,,:odoc;,,,;;;;,;;:odddd",
                "dddddl;:l:,;:ccc:;ldddoc:::cc:;,:c:odddd",
                "ddddddol:;,:lllc;;lddlccclllloc,,;lddddd",
                "ddddddddl;,,:ll:;;:cccc;;:looc:,;ldddddd",
                "dddddddddo:,,,;coc;',:llll:;,,,:oddddddd",
                "ddddddddddccoccllc::::c:;:lc:coodddddddd",
                "ddddddddddoddoooooc;;;:looollddddddddddd",
                "dddddddddddl:;:cool;,,,coo::ldoodddddddd",
                "dddddddddolclc;,,;;,,,,,;;,cddc:oddddddd",
                "ddddddlc:::cddolc:::::::clooddocllcclddd",
                "dddlc:,,,:cldddddddddddddddddddo:,,',;;;",
                "dl:,,,,,,,:oddddddddddddddddddo:,,,,,,,,",
        };

         String[] twarz4 = {
                "dddddddddddddddddddddddddddddddddddddddd",
                "dddddddddddddddddddddddddddddddddddddddd",
                "ddddddddddddocccc:;;;;;;;:codddddddddddd",
                "ddddddddoc:;,,'',,,,,,,,,,';cldddddddddd",
                "dddddddl;',,,'',,,,,,,,,,,,,';lddddddddd",
                "ddddddc;,,',,,',,,,,,,,,,,,,,,,coddddddd",
                "dddddl;,,,,,,,,,,,,,,',,,,',,,,,cddddddd",
                "dddddc,''',,;cllc;,,,;cll:;,,,,,:odddddd",
                "dddddc,''',:oddddolcloddddo:,,,,:odddddd",
                "dddddc,,,,;ldddddddddddddddl,,,;lddddddd",
                "dddddl:;,,cdolcllloooc:clllc;,,:oddddddd",
                "dddddc::,:ol;;:;,,cdxl,',;,;:,;coddddddd",
                "dddddc;;;ldlcll:,:odxl,';c:ll,;::odddddd",
                "dddddlc:;cdddol:,;lll:,';ldoc,;clddddddd",
                "ddddddl;;lolc;,'',,,,,,,,,:ll:;cdddddddd",
                "dddddddccdc,,,,:;,,,,,;;,'';lccodddddddd",
                "dddddddlldc,',:dolllllooc,':l:cddddddddd",
                "dddddddddol:,,,;:;:::::l:,;cccdddddddddd",
                "dddddddol:coc;,,,'',',,,;::::llodddddddd",
                "dddolc:;,;lddollc:::::clodl,',,,:llddddd",
                "oc:;,,,,,;odddddddddddddddl,',,,',,:lodd",
                ";,,,,,,,',:dddddddddddddddl,','','',,;:l"
        };

         String[] twarz5 = {
                "dddddddddddddddddddddddddddddddddddddddd",
                "dddddddddddddddddddddddddddddddddddddddd",
                "ddddddddddddolc:::::::cllodddddddddddddd",
                "ddddddddoc::;,,,,'''',,,,,:coddddddddddd",
                "ddddddl:;,,,,,,,,,,,,,,',,,,;coddddddddd",
                "dddddl;,,,,,,,,,,,,,,,,,,,,,,,,cdddddddd",
                "ddddl;,',,,,,,,,,,,,,,,,,,,,,',,cddddddd",
                "dddo:,',',,,,,,',,,,,,',,,,,,,,';ldddddd",
                "dddc,',,'',,,,,,,,,,,,',,,,,,',,,;lddddd",
                "ddl;,,,,,,;;cl;,;c:;;;,,,;:c;,,,'':odddd",
                "dl;,,',,,:oollc::ldolc:;:lddl,',,':odddd",
                "dc,,,,,',cdc.,.lccldl.,.lclddl,',,,:oddd",
                "dc,,:c:,,cdololcoddolc:cldddc,,cc,:odddd",
                "dc,,,::,':dddddoolodoooodddl,,,:;,:odddd",
                "do:,',,',:dddddoc::c:codddo:,,,''':odddd",
                "dddo:,,,,;lddddoccccdcodddc,',',';lddddd",
                "dddddl,,,,:ddddol::::coddc,,,',:cldddddd",
                "ddddddo:,,;coddddollloddc,,:cclddddddddd",
                "dddddddo:,,;:clooddool:::ccodddddddddddd",
                "ddddddddc:ldolc::lc:;:cloccodddddddddddd",
                "ddddddolccddddddoodddddddl:coddddddddddd",
                "ol:clccloddddddoodddddddddollllooodddddd",
        };

        String[] twarz6 = {
                "MMMMMMMMMM0:................'c0MMMMMMMMM",
                "MMMMMWKOx:...................:oxOXWMMMMM",
                "MMMMWO;..........................;dKWMMM",
                "MMMMK:.........''..................lKWMM",
                "MMWXl.......',:ccc:;;,,,'...........,xWM",
                "MMWk,....';:clllllllllllcc::;,'.....cKWM",
                "MW0o,...,cllllllllllllllllllllc,....'oXW",
                "MXl.....',,,,,,,:ccllllllcc:;,,,'.....c0",
                "MMK:....  ........'colll:'...........'c0",
                "MMO,....','.......,loddo;.... ........:0",
                "MWd....'c:'.   .,;coodkxc,.  .......'lkX",
                "MWd....'cdxl::,,...';;,..',. .cxx:..,OWM",
                "Nk;....'cdO00Ooc:,.     .,::;;o0Oc..'l0W",
                "c,.....'codxxollll:;'..':llllodxd;....,l",
                ";;,....':llllcc:;''',,,'';cllllll;...,;,",
                ";;;'....,cll:,;,'''''''''':l:;clc'..',;;",
                ";;;,.....';lllll,.',''''',llllc;'...,;;;",
                ",;;;,......,:cll:;;;;;;;;:llc:,...',;;;;",
                ".';;;,'.......,;:ccccccc:;;,'..'',;;;;,'",
                "..',;;;;,,..................'',;;;,,'...",
                "....',;;;;;,'..........'',,;;;;,'......."
        };

       twarze = new String[][]{twarz1, twarz2, twarz3, twarz4, twarz5, twarz6};

    }

    public static String[] getTwarz(){
        int wybor = random.nextInt(6);
        String[] wynik = new String[twarze[wybor].length];
        for(int i = 0 ; i < twarze[wybor].length ; i++)
        {
            wynik[i] = twarze[wybor][i];
        }
        return wynik;
    }

        public static void main(String[] args) {
        String[] badziewie = getTwarz();
            for (String s : badziewie) {
                System.out.println(s);
            }
            String[] cos = {"aka","baka","caka"};
            System.out.println(random.nextInt(cos.length));
            System.out.println(cos.length);

            String [][] test = {
                    {"imie","kod"},
                    {"Powrot"}
            };

        }


}
