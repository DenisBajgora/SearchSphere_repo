/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * The CenterPanel class extends JPanel. It has a scrollable text display area that is provided by a JTextArea inside of a JScrollPane.
 * This class is set up with a dark theme, personalised scroll bars, and unique text area colours 
 * and fonts. Since the text section is not editable, it can be used to display logs or text output.
 * To ensure a pleasing layout, this class additionally includes a FlowLayout to centre
 * the scroll pane within the panel.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel; 
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class CenterPanel extends JPanel { 
    private JTextArea textArea;
    private JScrollPane scrollPane;

    // Define constants for component configuration
    private static final Color PANEL_BACKGROUND_COLOR = new Color(0x212121);
    private static final Color TEXT_AREA_BACKGROUND_COLOR = new Color(0x272727);
    private static final Color TEXT_AREA_FOREGROUND_COLOR = new Color(0xFFFFFF);
    private static final Color TEXT_AREA_CARET_COLOR = new Color(0x272727);
    private static final Color TEXT_AREA_SELECTION_COLOR = new Color(0xFFFFFF);
    private static final Font TEXT_AREA_FONT = new Font("Consolas", Font.PLAIN, 18);
    private static final Dimension SCROLL_PANE_PREFERRED_SIZE = new Dimension(450, 240);
    private static final int FLOW_LAYOUT_HGAP = 0;
    private static final int FLOW_LAYOUT_VGAP = 10;
    private static final Color SCROLL_BAR_THUMB_COLOR = new Color(0xFFFFFF);
    private static final Color SCROLL_BAR_TRACK_COLOR = new Color(0x272727);

    /**
     * Constructor initializes the CenterPanel with a text area and a scroll pane.
     */
    public CenterPanel() {
        // Set the background color and layout of the panel using constants
        this.setBackground(PANEL_BACKGROUND_COLOR);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, FLOW_LAYOUT_HGAP, FLOW_LAYOUT_VGAP));

        // Initialize and configure the text area
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setFont(TEXT_AREA_FONT);
        textArea.setBackground(TEXT_AREA_BACKGROUND_COLOR);
        textArea.setForeground(TEXT_AREA_FOREGROUND_COLOR);
        textArea.setCaretColor(TEXT_AREA_CARET_COLOR);
        textArea.setSelectionColor(TEXT_AREA_SELECTION_COLOR);
        textArea.setEditable(false); // Makes the text area non-editable

        // Initialize and configure the scroll pane
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(SCROLL_PANE_PREFERRED_SIZE);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(SCROLL_BAR_THUMB_COLOR, SCROLL_BAR_TRACK_COLOR));
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI(SCROLL_BAR_THUMB_COLOR, SCROLL_BAR_TRACK_COLOR));

        // Add the scroll pane to the panel
        this.add(scrollPane);
    }

    /**
     * Returns the JTextArea contained within this panel.
     * @return the JTextArea component.
     */
    public JTextArea getTextArea() {
        return textArea;
    }
}
