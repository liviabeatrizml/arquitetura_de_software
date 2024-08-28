package com.office;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Main {
    public static void main(String[] args) {
        OfficeFactory DocsF = new DocsFactory();
        Office docx = DocsF.criarArquivoOffice();
        XWPFDocument document = new XWPFDocument();
        docx.criarParagrafo(document);
        docx.gravarDocumento(document);
    }
}
