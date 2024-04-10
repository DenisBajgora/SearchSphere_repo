import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel extends JPanel {

    HeaderPanel subNorthPanel;
    SearchPanel subCenterPanel;
    InteractionPanel subSouthPanel;
    
    MainPanel(JTextArea textArea) {
        subNorthPanel = new HeaderPanel();
        subSouthPanel = new InteractionPanel(textArea);
        subCenterPanel = new SearchPanel(
        subSouthPanel.selectFolderButton.getCurrentPathToFolder(), 
        textArea
        );

        this.setBackground(new Color(0x212121));
        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(0, 180));

        this.add(subNorthPanel, BorderLayout.NORTH);
        this.add(subCenterPanel, BorderLayout.CENTER);
        this.add(subSouthPanel, BorderLayout.SOUTH);
    }
}
