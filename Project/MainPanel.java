/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * MainPanel class extends JPanel. With a Header at the top, a SearchBar in the middle, 
 * and an InteractionPanel at the bottom, it is set up to oversee three different subpanels.
 * The Header provides branding, the SearchBar allows user input for searches, and the 
 * InteractionPanel has buttons for actions like deleting text, storing output, and 
 * choosing folders. Each subpanel is designed to carry out a certain task.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainPanel extends JPanel {

    private static final Color PANEL_BACKGROUND_COLOR = new Color(0x212121);
    private static final Dimension PANEL_PREFERRED_SIZE = new Dimension(0, 180);
    
    private Header subNorthPanel;
    private SearchBar subCenterPanel;
    private InteractionPanel subSouthPanel;
    
    public MainPanel(JTextArea textArea) {
        // Initialize components using setters
        setSubNorthPanel(new Header());
        setSubSouthPanel(new InteractionPanel(textArea));
        setSubCenterPanel(new SearchBar(
            getSubSouthPanel().getSelectFolderButton().getCurrentPathToFolder(), 
            textArea
        ));

        // Panel properties set using constants
        setBackground(PANEL_BACKGROUND_COLOR);
        setLayout(new BorderLayout());
        setPreferredSize(PANEL_PREFERRED_SIZE);

        // Add subpanels to the main panel using getters
        add(getSubNorthPanel(), BorderLayout.NORTH);
        add(getSubCenterPanel(), BorderLayout.CENTER);
        add(getSubSouthPanel(), BorderLayout.SOUTH);
    }

    // Getters and Setters for subpanels
    public Header getSubNorthPanel() {
        return subNorthPanel;
    }

    public void setSubNorthPanel(Header subNorthPanel) {
        this.subNorthPanel = subNorthPanel;
    }

    public SearchBar getSubCenterPanel() {
        return subCenterPanel;
    }

    public void setSubCenterPanel(SearchBar subCenterPanel) {
        this.subCenterPanel = subCenterPanel;
    }

    public InteractionPanel getSubSouthPanel() {
        return subSouthPanel;
    }

    public void setSubSouthPanel(InteractionPanel subSouthPanel) {
        this.subSouthPanel = subSouthPanel;
    }
}
