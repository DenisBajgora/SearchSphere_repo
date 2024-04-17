/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * the Header class extends JPanel to produce a visually appealing header. 
 * It includes a centralised JLabel with the title "Search Sphere" and a corresponding
 * sphere icon, created especially to symbolise application branding. The header uses
 * a large, readable Consolas font with a dark grey background and white lettering. 
 * There is a large space between the text and the icon in this design. 
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

    // Encapsulated class properties
    private JLabel label;
    private ImageIcon image;

    // Constants for component configuration
    private static final Color BACKGROUND_COLOR = new Color(0x212121);
    private static final Dimension PREFERRED_SIZE = new Dimension(0, 80);
    private static final Color LABEL_FOREGROUND_COLOR = new Color(0xFFFFFF);
    private static final Font LABEL_FONT = new Font("Consolas", Font.PLAIN, 30);
    private static final int ICON_TEXT_GAP = 35;
    private static final String TEXT = "Search Sphere";
    private static final String ICON_PATH = "Project/Icon/Sphere.png";

    // Constructor
    public Header() {
        // Initialize the properties using setters
        setLabel(new JLabel(TEXT));
        setImage(new ImageIcon(ICON_PATH));
        
        // Now using getters to work with properties
        getLabel().setIcon(getImage());
        getLabel().setIconTextGap(ICON_TEXT_GAP);

        // Apply configurations to the panel
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(PREFERRED_SIZE);
        setLayout(new BorderLayout());

        getLabel().setForeground(LABEL_FOREGROUND_COLOR);
        getLabel().setFont(LABEL_FONT);
        getLabel().setHorizontalAlignment(JLabel.CENTER);
        getLabel().setVerticalAlignment(JLabel.CENTER);

        // Add the label to the panel using a getter
        add(getLabel());
    }
    
    // Getter and Setter for label
    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    // Getter and Setter for image
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
        // If label is already initialized, update its icon
        if (this.label != null) {
            this.label.setIcon(image);
        }
    }
}
