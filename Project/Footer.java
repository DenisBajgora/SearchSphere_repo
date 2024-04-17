/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * This footer class extends JPannel. It has a single, basic JLabel with a customisable copyright text shown on it. 
 * The panel features a dark grey backdrop with text centred in the footer, all 
 * in a minimalistic design. With this setting, copyright information is visible 
 * and easily distinguishable.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Footer extends JPanel {
    private JLabel copyrightLabel;

    // Define constants for component configuration
    private static final Color BACKGROUND_COLOR = new Color(0x212121);
    private static final Dimension PREFERRED_SIZE = new Dimension(0, 25);
    private static final String COPYRIGHT_TEXT = "Denis © 2024 Copyright Reserved";

    /**
     * Constructor for Footer. Initializes the panel with a copyright label.
     */
    public Footer() {
        // Initialize the copyright label with text
        copyrightLabel = new JLabel(COPYRIGHT_TEXT);

        // Set the background color, layout, and preferred size of the panel using constants
        this.setBackground(BACKGROUND_COLOR);
        this.setLayout(new FlowLayout());
        this.setPreferredSize(PREFERRED_SIZE);

        // Add the copyright label to the panel
        this.add(copyrightLabel);
    }
}
