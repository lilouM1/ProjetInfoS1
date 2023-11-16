import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Projet_Info_Base_Copie {
    public static void main(String[] args) {
        try {
            File inputFile = new File("algorithme.txt");
            Scanner scanner = new Scanner(inputFile);
            Scanner scanner2 = new Scanner(inputFile);
            String codeTikz = "";
            ArrayList<Object> liste = new ArrayList<Object>();
            int firstFS = 0;
            int firstSi = 0;
            String[][] matrice = new String[25][2];
            int posMatriceC = 0;
            int posMatriceL = 0;
            int FinElse = 0;

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();

                if (ligne.contains("Si") && !ligne.equals("FinSi") && !ligne.contains("Sinon")) {
                    matrice[posMatriceL][posMatriceC] = "S" + String.valueOf(posMatriceL) + String.valueOf(posMatriceC);
                    liste.add("S" + String.valueOf(posMatriceL));
                    if (ligne.contains("==")) {
                        String variable = ligne.substring(ligne.indexOf("i") + 2, ligne.indexOf("=")).trim();
                        String valeur = ligne.substring(ligne.indexOf("=") + 2, ligne.indexOf("A") - 1).trim();
                        if (posMatriceL == 0) {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ")  {Si " + variable
                                    + "$=$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        } else {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                    + matrice[posMatriceL - 1][posMatriceC] + "] {Si " + variable + "$=$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        }
                    } else if (ligne.contains("!=")) {
                        String variable = ligne.substring(ligne.indexOf("i") + 2, ligne.indexOf("!")).trim();
                        String valeur = ligne.substring(ligne.indexOf("=") + 1, ligne.indexOf("A") - 1).trim();
                        if (posMatriceL == 0) {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ")  {Si " + variable
                                    + "$!$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        } else {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                    + matrice[posMatriceL - 1][posMatriceC]
                                    + "] {Si " + variable + "$!$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        }
                    } else if (ligne.contains("<=")) {
                        String variable = ligne.substring(ligne.indexOf("i") + 2, ligne.indexOf("<")).trim();
                        String valeur = ligne.substring(ligne.indexOf("=") + 1, ligne.indexOf("A") - 1).trim();
                        if (posMatriceL == 0) {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ")  {Si " + variable
                                    + "$<$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        } else {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                    + matrice[posMatriceL - 1][posMatriceC]
                                    + "] {Si " + variable + "$<$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        }
                    } else if (ligne.contains(">=")) {
                        String variable = ligne.substring(ligne.indexOf("i") + 2, ligne.indexOf(">")).trim();
                        String valeur = ligne.substring(ligne.indexOf("=") + 1, ligne.indexOf("A") - 1).trim();
                        if (posMatriceL == 0) {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ")  {Si " + variable
                                    + "$>$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        } else {
                            codeTikz += "\\node[losange] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                    + matrice[posMatriceL - 1][posMatriceC]
                                    + "] {Si " + variable + "$>$="
                                    + valeur + "};\n";
                            System.out.println("liste" + liste);
                            posMatriceL++;
                        }
                    }
                    codeTikz += "\\node (aux" + matrice[posMatriceL - 1][posMatriceC] + ") [right = 4em of "
                            + matrice[posMatriceL - 1][posMatriceC]
                            + "]{};\r";

                } else if (ligne.contains("=")) {
                    liste.add("A" + String.valueOf(posMatriceL));
                    matrice[posMatriceL][posMatriceC] = "A" + String.valueOf(posMatriceL) + String.valueOf(posMatriceC);
                    String variable = ligne.substring(0, ligne.indexOf("=")).trim();
                    String valeur = ligne.substring(ligne.indexOf("=") + 1).trim();
                    if (posMatriceL == 0) {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ")  {" + variable + "="
                                + valeur
                                + "};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    } else {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                + matrice[posMatriceL - 1][posMatriceC]
                                + "] {" + variable + "=" + valeur + "};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    }

                } else if (ligne.contains("Ecrire")) {
                    liste.add("E" + String.valueOf(posMatriceL));
                    matrice[posMatriceL][posMatriceC] = "E" + String.valueOf(posMatriceL) + String.valueOf(posMatriceC);
                    String variable = ligne.substring(ligne.indexOf("(") + 1, ligne.indexOf(")"));
                    if (posMatriceL == 0) {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ") {Ecrire(" + variable
                                + ")};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    } else {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                + matrice[posMatriceL - 1][posMatriceC]
                                + "] {Ecrire(" + variable + ")};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    }

                } else if (ligne.contains("Lire")) {
                    liste.add("L" + String.valueOf(posMatriceL));
                    matrice[posMatriceL][posMatriceC] = "L" + String.valueOf(posMatriceL) + String.valueOf(posMatriceC);
                    String variable = ligne.substring(ligne.indexOf("(") + 1, ligne.indexOf(")"));
                    if (posMatriceL == 0) {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ") {Lire(" + variable
                                + ")};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    } else {
                        codeTikz += "\\node[carre] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                + matrice[posMatriceL - 1][posMatriceC]
                                + "] {Lire(" + variable + ")};\n";
                        System.out.println("liste" + liste);
                        posMatriceL++;
                    }

                } else if (ligne.contains("FinSi")) {
                    liste.add("FS" + String.valueOf(posMatriceL));
                    matrice[posMatriceL][posMatriceC] = "FS" + String.valueOf(posMatriceL)
                            + String.valueOf(posMatriceC);
                    codeTikz += "\\node (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                            + matrice[posMatriceL - 1][posMatriceC]
                            + "] {};\n";
                    posMatriceL++;

                } else if (ligne.contains("Sinon")) {
                    liste.add("Else" + String.valueOf(posMatriceL));
                    for (int i = 1; i < posMatriceL; i++) {
                        if (matrice[i][posMatriceC].toString().contains("S")
                                && !matrice[i][posMatriceC].toString().contains("FS")) {
                            firstSi = i; // assign the line position to firstSi
                            break; // stop searching after the first occurrence is found
                        }
                    }
                    System.out.println(posMatriceL);
                    System.out.println(firstSi);
                    matrice[firstSi][posMatriceC + 1] = "Else" + String.valueOf(firstSi)
                            + String.valueOf(posMatriceC + 1);
                    codeTikz += "\\node (" + matrice[firstSi][posMatriceC + 1] + ") [right =4em of "
                            + matrice[firstSi][posMatriceC] + "] {};\n";
                    firstSi++;

                    while (scanner.hasNextLine()) {

                        ligne = scanner.nextLine();
                        if (ligne.contains("=")) {
                            liste.add("A" + String.valueOf(firstSi));
                            matrice[firstSi][posMatriceC + 1] = "A" + String.valueOf(firstSi)
                                    + String.valueOf(posMatriceC + 1);
                            String variable = ligne.substring(0, ligne.indexOf("=")).trim();
                            String valeur = ligne.substring(ligne.indexOf("=") + 1).trim();
                            if (firstSi == 0) {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ")  {"
                                        + variable
                                        + "="
                                        + valeur
                                        + "};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            } else {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ") [below =of "
                                        + matrice[firstSi - 1][posMatriceC + 1]
                                        + "] {" + variable + "=" + valeur + "};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            }

                        } else if (ligne.contains("Ecrire")) {
                            liste.add("E" + String.valueOf(firstSi));
                            matrice[firstSi][posMatriceC + 1] = "E" + String.valueOf(firstSi)
                                    + String.valueOf(posMatriceC + 1);
                            String variable = ligne.substring(ligne.indexOf("(") + 1, ligne.indexOf(")"));
                            if (firstSi == 0) {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ") {Ecrire("
                                        + variable
                                        + ")};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            } else {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ") [below =of "
                                        + matrice[firstSi - 1][posMatriceC + 1]
                                        + "] {Ecrire(" + variable + ")};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            }

                        } else if (ligne.contains("Lire")) {
                            liste.add("L" + String.valueOf(firstSi));
                            matrice[firstSi][posMatriceC + 1] = "L" + String.valueOf(firstSi)
                                    + String.valueOf(posMatriceC + 1);
                            String variable = ligne.substring(ligne.indexOf("(") + 1, ligne.indexOf(")"));
                            if (firstSi == 0) {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ") {Lire("
                                        + variable
                                        + ")};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            } else {
                                codeTikz += "\\node[carre] (" + matrice[firstSi][posMatriceC + 1] + ") [below =of "
                                        + matrice[firstSi - 1][posMatriceC + 1]
                                        + "] {Lire(" + variable + ")};\n";
                                System.out.println("liste" + liste);
                                firstSi++;
                            }
                        } else if (ligne.contains("FinSi")) {
                            matrice[posMatriceL][posMatriceC] = "FS" + String.valueOf(posMatriceL)
                                    + String.valueOf(posMatriceC);
                            codeTikz += "\\node (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                                    + matrice[posMatriceL - 1][posMatriceC]
                                    + "] {};\n";
                            posMatriceL++;
                            break;
                        }
                    }

                }

            }

            liste.add("C" + String.valueOf(posMatriceL));
            matrice[posMatriceL][posMatriceC] = "C" + String.valueOf(posMatriceL) + String.valueOf(posMatriceC);
            codeTikz += "\\node[cercle] (" + matrice[posMatriceL][posMatriceC] + ") [below =of "
                    + matrice[posMatriceL - 1][posMatriceC]
                    + "] {\\textbullet};\n";
            codeTikz += "\n";

            System.out.println(liste);

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.println();
            }

            for (int loop = 1; loop < posMatriceL + 1; loop++) {
                if (matrice[loop][posMatriceC].toString().contains("S")
                        && !matrice[loop][posMatriceC].toString().contains("FS")) {

                    if (matrice[loop][posMatriceC + 1] != null
                            && matrice[loop][posMatriceC + 1].toString().contains("Else")) {
                        codeTikz += "\\draw[->] (" + matrice[loop][posMatriceC] + ".east)|-("
                                + matrice[loop][posMatriceC + 1] + ".center)node[pos=1.3,align=center]{sinon}to("
                                + matrice[loop + 1][posMatriceC + 1]
                                + ".north);\n";

                        for (int i = loop + 1; i < posMatriceL; i++) {
                            if (matrice[i][1] != null) {
                                FinElse = i; // update FinElse to the current position
                                codeTikz += "\\draw[->] (" + matrice[i - 1][posMatriceC + 1] + ".south) to ("
                                        + matrice[i][posMatriceC + 1] + ".north);\n";
                            }

                        }
                        for (int j = loop; j < posMatriceL; j++) {
                            if (matrice[j][posMatriceC].toString().contains("FS")) {
                                firstFS = j;
                                codeTikz += "\\node (aux" + matrice[firstFS][posMatriceC] + ") [right = 4em of "
                                        + matrice[firstFS][posMatriceC]
                                        + "]{};\r";
                                codeTikz += "\\draw [->](" + matrice[FinElse][posMatriceC + 1] + ".south)|-(aux"
                                        + matrice[firstFS][posMatriceC] + ".center)|-("
                                        + matrice[firstFS][posMatriceC] + ".center);\n";
                            }
                        }
                    } else {

                        for (int j = loop; j < posMatriceL; j++) {
                            if (matrice[j][posMatriceC].toString().contains("FS")) {
                                firstFS = j;
                                System.out.println(firstFS);
                                codeTikz += "\\draw [->](" + matrice[loop][posMatriceC] + ".east)|-(aux"
                                        + matrice[loop][posMatriceC]
                                        + ".center)node[pos=1.3,align=center]{non}|-("
                                        + matrice[firstFS][posMatriceC] + ".center);\n";
                            }
                        }
                    }
                    codeTikz += "\\draw[->] (" + matrice[loop - 1][posMatriceC] + ".south) to ("
                            + matrice[loop][posMatriceC] + ".north);\n";

                } else if (matrice[loop][posMatriceC].toString().contains("FS")) {
                    codeTikz += "\\draw[->] (" + matrice[loop - 1][posMatriceC] + ".south) to ("
                            + matrice[loop + 1][posMatriceC] + ".north);\n";
                    loop++;
                } else {
                    codeTikz += "\\draw[->] (" + matrice[loop - 1][posMatriceC] + ".south) to ("
                            + matrice[loop][posMatriceC] + ".north);\n";
                }
            }
            scanner.close();
            scanner2.close();
            System.out.println("liste" + liste);
            PrintWriter writer = new PrintWriter("logigramme.tex");
            writer.println("\\documentclass{article}");
            writer.println("\\usepackage[utf8]{inputenc}");
            writer.println("\\usepackage{tikz}");
            writer.println("\\usetikzlibrary{positioning,shapes.geometric}");
            writer.println(
                    "\\tikzstyle{carre}=[rectangle,rounded corners,draw=red!80,fill=red!10,inner ysep=0.2cm,text width=2cm,text centered]");
            writer.println(
                    "\\tikzstyle{losange}=[diamond,draw=blue!80,fill=blue!10, inner ysep=0.1cm,text width=1cm,text centered]");
            writer.println("\\tikzstyle{cercle}=[draw,circle]");
            writer.println("\\begin{document}\n");
            writer.println("\\begin{tikzpicture}\n");
            writer.println(codeTikz);
            writer.println("\\end{tikzpicture}\n");
            writer.println("\\end{document}");
            writer.close();

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[i].length; j++) {
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.println();
            }

        } catch (

        FileNotFoundException e) {
            System.out.println("Le fichier n'a pas été trouvé.");
        }
    }
}
