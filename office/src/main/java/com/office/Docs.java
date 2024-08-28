package com.office;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Docs implements Office {

    public static String paragrafo = "paragrafo.txt";
    public static String output = "arquivoGerado.docx";

    @Override
    public void criarParagrafo(XWPFDocument document) {
        String texto = "", op = "";
        Manipulacao.criarArquivoDeTexto();
        Manipulacao.escreverNoArquivoTXT(texto);
        XWPFParagraph para = document.createParagraph();
        Manipulacao.selecionarAlinhamento(op, para);
        String textoDoTXT = Manipulacao.convertTextFileToString(paragrafo);
        XWPFRun paraRun = para.createRun();
        paraRun.setText(textoDoTXT);
    }

    public void gravarDocumento(XWPFDocument document) {
        try (FileOutputStream out = new FileOutputStream(output)) {
            document.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editarArquivo() {
        throw new UnsupportedOperationException("Unimplemented method 'editarArquivo'");
    }

    @Override
    public void excluirArquivo() {
        throw new UnsupportedOperationException("Unimplemented method 'excluirArquivo'");
    }

}