package com.office;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Manipulacao {

    public static String convertTextFileToString(String fileName) {

        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {
            return stream.collect(Collectors.joining(" "));
        } catch (IOException | URISyntaxException e) {
            return null;
        }
    }

    public static void selecionarAlinhamento(String op, XWPFParagraph para) {
        System.out.println("Centro");
        System.out.println("Direita");
        System.out.println("Esquerda");
        Scanner in = new Scanner(System.in);
        op = in.nextLine();
        if (op.equals("1")) {
            para.setAlignment(ParagraphAlignment.CENTER);
        } else if (op.equals("2")) {
            para.setAlignment(ParagraphAlignment.RIGHT);
        } else if (op.equals("3")) {
            para.setAlignment(ParagraphAlignment.LEFT);
        } else {
            para.setAlignment(ParagraphAlignment.CENTER);
        }
    }

    public static void criarArquivoDeTexto() {
        try (FileWriter paragrafo = new FileWriter(
                "C:/Users/Mikael/Documents/WordJava/factoryMethod/office/src/main/resources/paragrafo.txt")) {
            PrintWriter gravarParagrafo = new PrintWriter(paragrafo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escreverNoArquivoTXT(String texto) {
        Scanner in = new Scanner(System.in);
        texto = in.nextLine();
        try (FileWriter paragrafo = new FileWriter(
                "C:/Users/Mikael/Documents/WordJava/factoryMethod/office/src/main/resources/paragrafo.txt")) {
            PrintWriter gravarParagrafo = new PrintWriter(paragrafo);
            gravarParagrafo.println(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
