import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class POC {

    public static void main(String[] args)  {
        JFrame frame = new JFrame("Document Reader");
        frame.setSize(400, 400);
        frame.setLocation(750, 350);
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent arg0) {
                JFileChooser fileChooser = new JFileChooser();
                int selected = fileChooser.showOpenDialog(frame);

                if(selected == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getAbsolutePath();
                    String[] splittedData = path.split("\\.");

                    if(splittedData.length > 0) {
                        if(splittedData[1].equalsIgnoreCase("docx")) {

                            try {
                                FileInputStream fps = new FileInputStream(path);
                                XWPFDocument docu = new XWPFDocument(fps);

                                List<XWPFParagraph> data = docu.getParagraphs();

                                for(XWPFParagraph p : data) {
                                    System.out.print(p.getText());
                                }

                            }
                            catch(FileNotFoundException ex) {
                                System.out.print(ex.getMessage());
                            }
                            catch(IOException ex1) {
                                System.out.print(ex1.getMessage());
                            }

                        }
                    }
                }
            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosed(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
