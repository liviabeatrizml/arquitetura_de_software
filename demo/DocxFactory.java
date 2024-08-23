public class DocxFactory extends OfficeFactory {
    @Override
    public Office criarArquivoOffice() {
        return new Docx();
    }
}