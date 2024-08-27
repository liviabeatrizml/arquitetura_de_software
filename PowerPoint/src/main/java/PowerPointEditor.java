import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PowerPointEditor {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\vgabr\\OneDrive\\Área de Trabalho\\projeto\\factoryMethod\\PowerPoint\\teste\\arquivo-teste.pptx";
        File file = new File(filePath);

        // Verifica se o arquivo está vazio (0 KB)
        if (file.length() == 0) {
            System.out.println("O arquivo está vazio. Não é possível processá-lo.");
            return;
        }

        boolean hasChanges = false; // Flag para verificar se houve alterações

        try (FileInputStream fis = new FileInputStream(filePath);
             XMLSlideShow ppt = new XMLSlideShow(fis)) {

            // Itera pelos slides
            for (XSLFSlide slide : ppt.getSlides()) {
                // Itera pelas formas no slide
                for (XSLFTextShape shape : slide.getPlaceholders()) {
                    if (shape != null && shape.getText() != null) {
                        // Verifica se o texto é diferente do que vai ser alterado
                        if (!"Texto alterado aqui".equals(shape.getText())) {
                            // Altera o texto
                            shape.setText("Texto alterado aqui");
                            hasChanges = true;
                        }
                    }
                }
            }

            if (hasChanges) {
                // Salva as alterações no mesmo arquivo
                try (FileOutputStream fos = new FileOutputStream(filePath)) {
                    ppt.write(fos);
                }
                System.out.println("Arquivo PowerPoint alterado e salvo com sucesso.");
            } else {
                System.out.println("Nenhuma alteração foi feita no arquivo.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}