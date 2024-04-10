import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InteractionPanel extends JPanel {
    ClearButton clearButton;
    SaveOutput saveOutputButton;
    SelectFolder selectFolderButton;
    
    InteractionPanel(JTextArea textArea) {
        clearButton = new ClearButton(textArea);
        selectFolderButton = new SelectFolder();
        saveOutputButton = new SaveOutput(textArea);

        this.setBackground(new Color(0x212121));
        this.setPreferredSize(new Dimension(0, 60));
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        this.add(clearButton);
        this.add(saveOutputButton);
        this.add(selectFolderButton);
    }
}
