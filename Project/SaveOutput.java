/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * The SaveOutput class creates a specialised button for saving text content from a 
 * JTextArea to a file by extending JButton and implementing MouseListener. By offering 
 * visual feedback during interactions—such as altering the backdrop colour when hovered 
 * over or pressed—this class improves the user experience. The button emphasises simplicity
 * and clarity with its dark grey backdrop, bright green hover text, and darker green 
 * pressed text.
 */

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
    // Constants for the button configuration
    private static final Dimension BUTTON_SIZE = new Dimension(130, 20);
    private static final Color BUTTON_BACKGROUND = new Color(0x272727);
    private static final Color BUTTON_FOREGROUND = new Color(0xFFFFFF);
    private static final Font BUTTON_FONT = new Font("Consolas", Font.PLAIN, 15);
    private static final Color BUTTON_HOVER_BACKGROUND = new Color(0x1CC148);
    private static final Color BUTTON_PRESSED_BACKGROUND = new Color(0x179E3B);
    private static final String BUTTON_TEXT = "Save Output";
    
    // Class properties
    private JTextArea textArea;

    public SaveOutput(JTextArea textArea) {
        super(BUTTON_TEXT);
        this.textArea = textArea;
        this.addMouseListener(this);
        this.setPreferredSize(BUTTON_SIZE);
        this.setFocusable(false);
        this.setBackground(BUTTON_BACKGROUND);
        this.setFont(BUTTON_FONT);
        this.setForeground(BUTTON_FOREGROUND);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showSaveDialog(null);

        if (response == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
            try (PrintWriter fileOut = new PrintWriter(file)) {
                fileOut.println(textArea.getText());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(BUTTON_PRESSED_BACKGROUND);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(BUTTON_HOVER_BACKGROUND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND);
    }
}
