import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {

    JLabel label = new JLabel("Search Sphere");
    ImageIcon image = new ImageIcon("Icon/Sphere.png");

    HeaderPanel() {
        this.setBackground(new Color(0x212121));
        label.setIcon(image);
        label.setIconTextGap(35);
        
        this.setPreferredSize(new Dimension(0, 80));
        this.setLayout(new BorderLayout());

        label.setForeground(new Color(0xFFFFFF));
        label.setFont(new Font("Consolas", Font.PLAIN, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        this.add(label);
    }
}
