import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InteractionPanel extends JPanel {
    private ClearButton clearButton;
    private SaveOutput saveOutputButton;
    private SelectFolder selectFolderButton;
    
    // Constants for component configuration
    private static final Color PANEL_BACKGROUND_COLOR = new Color(0x212121);
    private static final Dimension PANEL_PREFERRED_SIZE = new Dimension(0, 60);
    private static final int FLOW_LAYOUT_HGAP = 20;
    private static final int FLOW_LAYOUT_VGAP = 20;

    public InteractionPanel(JTextArea textArea) {
        // Initialize buttons using setters
        setClearButton(new ClearButton(textArea));
        setSelectFolderButton(new SelectFolder());
        setSaveOutputButton(new SaveOutput(textArea));

        // Panel properties set using constants
        setBackground(PANEL_BACKGROUND_COLOR);
        setPreferredSize(PANEL_PREFERRED_SIZE);
        setLayout(new FlowLayout(FlowLayout.CENTER, FLOW_LAYOUT_HGAP, FLOW_LAYOUT_VGAP));

        // Add buttons to the panel using getters
        add(getClearButton());
        add(getSaveOutputButton());
        add(getSelectFolderButton());
    }
    
    // Getters and setters for clearButton
    public ClearButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(ClearButton clearButton) {
        this.clearButton = clearButton;
    }

    // Getters and setters for saveOutputButton
    public SaveOutput getSaveOutputButton() {
        return saveOutputButton;
    }

    public void setSaveOutputButton(SaveOutput saveOutputButton) {
        this.saveOutputButton = saveOutputButton;
    }

    // Getters and setters for selectFolderButton
    public SelectFolder getSelectFolderButton() {
        return selectFolderButton;
    }

    public void setSelectFolderButton(SelectFolder selectFolderButton) {
        this.selectFolderButton = selectFolderButton;
    }
}
