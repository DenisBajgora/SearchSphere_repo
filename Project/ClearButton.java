/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * The ClearButton class makes a custom button that is intended to clear the contents of a
 * JTextArea by extending JButton and implementing MouseListener. This button is set up with
 * a non-editable text box as its target and a simple black look. It has visual 
 * feedback that changes colour in response to mouse actions, including hover, press, 
 * and release.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ClearButton extends JButton implements MouseListener {
    private JTextArea textArea;

    // Define constants for component configuration
    private static final String BUTTON_TEXT = "Clear";
    private static final Dimension BUTTON_SIZE = new Dimension(130, 20);
    private static final Color BUTTON_BACKGROUND_COLOR = new Color(0x272727);
    private static final Color BUTTON_PRESSED_COLOR = new Color(0x7c1710);
    private static final Color BUTTON_HOVER_COLOR = new Color(0xb73224);
    private static final Color BUTTON_FOREGROUND_COLOR = new Color(0xFFFFFF);
    private static final Font BUTTON_FONT = new Font("Consolas", Font.PLAIN, 15);

    /**
     * Constructor for ClearButton.
     * @param textArea The JTextArea that this button will clear when clicked.
     */
    public ClearButton(JTextArea textArea) {
        super(BUTTON_TEXT);
        this.textArea = textArea;
        this.addMouseListener(this);
        this.setPreferredSize(BUTTON_SIZE);
        this.setFocusable(false);
        this.setBackground(BUTTON_BACKGROUND_COLOR);
        this.setFont(BUTTON_FONT);
        this.setForeground(BUTTON_FOREGROUND_COLOR);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
    }

    // Clears the text area
    @Override
    public void mouseClicked(MouseEvent e) {
        textArea.setText(""); 
    }

    // Changes background color when button is pressed
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(BUTTON_PRESSED_COLOR); 
    }

    // Reverts to original background color upon release
    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND_COLOR); 
    }

    // Changes background color when mouse hovers over the button
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(BUTTON_HOVER_COLOR); 
    }

    // Reverts to original background color when mouse exits
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND_COLOR); 
    }
}
