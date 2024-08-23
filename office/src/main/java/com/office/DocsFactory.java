package com.office;
public class DocsFactory extends OfficeFactory {
    @Override
    public Office criarArquivoOffice() {
        return new Docs();
    }
}