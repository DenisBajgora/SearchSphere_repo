import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel {
    JLabel copyrightLabel;
    Footer() {
        copyrightLabel = new JLabel("Denis © 2024 Copyright Reserved");
        this.setBackground(new Color(0x212121));
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(0,25));
        this.add(copyrightLabel);
    }
}
