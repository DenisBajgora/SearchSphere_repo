import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class SelectFolder extends JButton implements MouseListener {

    private ArrayList<String> currentPathToFolder = new ArrayList<>();

    // Define constants for button appearance
    private static final String BUTTON_TEXT = "Select a Folder";
    private static final Dimension BUTTON_SIZE = new Dimension(130, 20);
    private static final Color BUTTON_BACKGROUND = new Color(0x272727);
    private static final Color BUTTON_FOREGROUND = new Color(0xFFFFFF);
    private static final Color BUTTON_PRESS_COLOR = new Color(0x1c6ba0);
    private static final Color BUTTON_HOVER_COLOR = new Color(0x5aa6e3);
    private static final Font BUTTON_FONT = new Font("Consolas", Font.PLAIN, 15);

    /**
     * Constructor for SelectFolder. Initializes the button with predefined settings.
     */
    public SelectFolder() {
        super(BUTTON_TEXT);
        this.addMouseListener(this);
        this.setPreferredSize(BUTTON_SIZE);
        this.setFocusable(false);
        this.setBackground(BUTTON_BACKGROUND);
        this.setFont(BUTTON_FONT);
        this.setForeground(BUTTON_FOREGROUND);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Only directories can be selected

        int response = fileChooser.showOpenDialog(null); // Show the directory selection dialog

        // Add the selected directory's path to currentPathToFolder if approved
        if (response == JFileChooser.APPROVE_OPTION) {
            File folder = fileChooser.getSelectedFile();
            System.out.println("Selected folder: " + folder.getAbsolutePath());
            currentPathToFolder.add(folder.getAbsolutePath());
        } else {
            System.out.println("No folder selected.");
        }
    }

    // Change background color when the button is pressed
    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(BUTTON_PRESS_COLOR);
    }

    // Revert background color when the button is released
    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND);
    }

    // Change background color when the mouse enters the button area
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(BUTTON_HOVER_COLOR);
    }

    // Revert background color when the mouse exits the button area
    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(BUTTON_BACKGROUND);
    }

    // Getter for the current path to folder
    public ArrayList<String> getCurrentPathToFolder() {
        return currentPathToFolder;
    }

    // Setter for the current path to folder
    public void setCurrentPathToFolder(ArrayList<String> currentPathToFolder) {
        this.currentPathToFolder = currentPathToFolder;
    }
}
