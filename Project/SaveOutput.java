import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

public class SaveOutput extends JButton implements MouseListener {
    JTextArea textArea;
    SaveOutput(JTextArea textArea) {
        super("Save Output");
        this.textArea = textArea;
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(130,20));
        this.setFocusable(false);
        this.setBackground(new Color(0x272727));
        this.setFont(new Font("Consolas", Font.PLAIN, 15));
        this.setForeground(new Color(0xFFFFFF));
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file;
            PrintWriter fileOut = null; 

            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try {
                fileOut = new PrintWriter(file);
                fileOut.println(textArea.getText());
            } 
            catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
            finally {
                fileOut.close();
            }
        }

    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(new Color(0x179E3B));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(0x1CC148));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }
}
