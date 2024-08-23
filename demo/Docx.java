public class Docx implements Office {
    @Override
    public void criar() {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
    }
}