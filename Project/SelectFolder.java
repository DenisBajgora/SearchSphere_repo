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

    private ArrayList<String> currentPathToFolder = new ArrayList<String>();
    
    SelectFolder() {
        super("Select a Folder");
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(130,20));
        this.setFocusable(false);
        this.setBackground(new Color(0x272727));
        this.setFont(new Font("Consolas", Font.PLAIN, 15));
        this.setForeground(new Color(0xFFFFFF));
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();

        // Set the selection mode to directories only.
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        // Open the dialog to choose a directory
        int response = fileChooser.showOpenDialog(null);
        
        if (response == JFileChooser.APPROVE_OPTION) {
            File folder = fileChooser.getSelectedFile();
            System.out.println("Selected folder: " + folder.getAbsolutePath());
            currentPathToFolder.add(folder.getAbsolutePath());
        } else {
            System.out.println("No folder selected.");
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setBackground(new Color(0x1c6ba0));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(new Color(0x5aa6e3));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(0x272727));
    }

    public ArrayList<String> getCurrentPathToFolder() {
        return currentPathToFolder;
    }

    public void setCurrentPathToFolder(ArrayList<String> currentPathToFolder) {
        this.currentPathToFolder = currentPathToFolder;
    }
}
