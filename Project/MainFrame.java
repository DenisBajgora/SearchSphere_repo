import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    ImageIcon icon = new ImageIcon("Icon/Search Sphere Icon.png");
    CenterPanel centerPanel = new CenterPanel();
    MainPanel northPanel = new MainPanel(centerPanel.getTextArea());
    Footer southPanel = new Footer();
    
    MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setResizable(false);
        this.setTitle("Search Sphere V1.0");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(new Color(0x212121));
        this.setLocationRelativeTo(null);

        this.setVisible(true);

        this.add(northPanel,BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
    } 
}
