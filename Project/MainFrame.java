import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    // Constants for the frame configuration
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = new Color(0x212121);
    private static final String FRAME_TITLE = "Search Sphere V1.0";
    private static final String ICON_PATH = "Project/Icon/Search Sphere Icon.png";

    // Encapsulated components of the frame
    private ImageIcon icon;
    private CenterPanel centerPanel;
    private MainPanel mainPanel;
    private Footer footer;
    
    public MainFrame() {
        // Initialize components using setters
        setIcon(new ImageIcon(ICON_PATH));
        setCenterPanel(new CenterPanel());
        setMainPanel(new MainPanel(getCenterPanel().getTextArea()));
        setFooter(new Footer());

        // Setup the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setTitle(FRAME_TITLE);
        this.setIconImage(getIcon().getImage());
        this.getContentPane().setBackground(BACKGROUND_COLOR);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // Adding panels to the frame
        this.add(getMainPanel(), BorderLayout.NORTH);
        this.add(getCenterPanel(), BorderLayout.CENTER);
        this.add(getFooter(), BorderLayout.SOUTH);
    } 

    // Getters and setters
    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public Footer getFooter() {
        return footer;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }
}
