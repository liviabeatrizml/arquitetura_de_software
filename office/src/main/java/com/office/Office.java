package com.office;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

//interface do produto criado, neste caso, arquivo docx, xslx e pptx
public interface Office {
    void editarArquivo();
    void excluirArquivo();
    void criarParagrafo(XWPFDocument document);
    void gravarDocumento(XWPFDocument document);
}
