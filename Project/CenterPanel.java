import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class CenterPanel extends Panel {
    JTextArea textArea;
    JScrollPane scrollPane;

    CenterPanel() {
        this.setBackground(new Color(0x212121));
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));

        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Consolas",Font.PLAIN, 18));
        textArea.setBackground(new Color(0x272727));
        textArea.setForeground(new Color(0xFFFFFF));
        textArea.setCaretColor(new Color(0x272727));
        textArea.setSelectionColor((new Color(0xFFFFFF)));
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450,240));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(null);

        // Set the custom scrollbar UI
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI(new Color(0xFFFFFF), new Color(0x272727)));
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI(new Color(0xFFFFFF), new Color(0x272727)));
        
        this.add(scrollPane);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
