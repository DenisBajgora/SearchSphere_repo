import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ClearButton extends JButton implements MouseListener {
    JTextArea textArea;
    ClearButton(JTextArea textArea) {
        super("Clear");
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
        textArea.setText("");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(new Color(0x7c1710));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(0xb73224));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }
}
