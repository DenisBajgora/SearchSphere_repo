import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SearchPanel extends JPanel {

    JTextField textfield = new JTextField();
    private ArrayList<String> currentPathToFolder;
    private JTextArea textArea;

    SearchPanel(ArrayList<String> currentPathToFolder,JTextArea textArea) {
        setCurrentPathToFolder(currentPathToFolder);
        setTextArea(textArea);
        this.setBackground(new Color(0x212121));
        this.setPreferredSize(new Dimension(0, 20));
        this.setLayout(new FlowLayout());

        textfield.setPreferredSize(new Dimension(400,25));
        textfield.setBorder(null);
        textfield.setFont(new Font("Consolas", Font.PLAIN, 20));
        textfield.setForeground(new Color(0xFFFFFF));
        textfield.setBackground(new Color(0x272727));
        textfield.setCaretColor(new Color(0xFFFFFF));
        textfield.setSelectionColor((new Color(0xFFFFFF)));

        // Add an action listener to the textfield
        textfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPathToFolder.isEmpty()) {
                    textArea.setText("Select a Folder!");
                    return;
                }
                searchForWord();

                
                // Clear the textfield for new input
                textfield.setText("");
            }
        });
        this.add(textfield);
    }

    void searchForWord() {
        // absolute path to the folder
        String folderPath = currentPathToFolder.get(currentPathToFolder.size() - 1);

        // Container to hold all text file details
        ArrayList<TextFileDetails> textFileDetailsContainer = new ArrayList<TextFileDetails>(); 
        
        // Access the folder
        File folder = new File(folderPath);
         
        // List all files in the folder
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {return;}

        // Overall occurences of a certain word
        int overallOccurence = 0;

        // Display the top part of the Search Output. 
        textArea.setText("Search results for: " + textfield.getText());
        textArea.append('\n' + "-------------------------------------------");
         
        for (File file : listOfFiles) {
            // Check if the file is a text file
            if (!(file.isFile() && file.getName().endsWith(".txt"))) { continue; }
        
            System.out.println("Opening file: " + file.getName());
            TextFileDetails textFileDetails = new TextFileDetails();
            textFileDetailsContainer.add(textFileDetails);
            textFileDetails.setFileName(file.getName());
        
            try {
                // Read the entire file content as a string
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())), StandardCharsets.UTF_8);
                int occurrences = countOccurrences(content, textfield.getText());
                System.out.printf("File: %s: %d total occurrence(s) of '%s'%n", file.getName(), occurrences, textfield.getText());
                textFileDetails.setStandaloneOccurances(occurrences);
                overallOccurence += occurrences;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mergeSort(textFileDetailsContainer);
        displayToTextArea(textFileDetailsContainer, textArea, overallOccurence);
        for (TextFileDetails textFile : textFileDetailsContainer) {
            System.out.println(textFile.getFileName());
            System.out.println(textFile.getStandaloneOccurances());
            if (occurencePercentage(textFile.getStandaloneOccurances(), overallOccurence) != 0) {
                System.out.println(occurencePercentage(textFile.getStandaloneOccurances(), overallOccurence));
            }
        }
        System.out.println("Overall Occurence: " + overallOccurence);
    }

    private static int countOccurrences(String line, String word_or_phrase) {
        // Adjust case to make search case-insensitive
        String tempLine = line.toLowerCase();
        String tempWord = word_or_phrase.toLowerCase();

        // Count occurrences
        int occurrences = 0;
        int index = 0;
        while ((index = tempLine.indexOf(tempWord, index)) != -1) {
            occurrences++;
            index += tempWord.length();
        }
        return occurrences;
    }
    
    void mergeSort(ArrayList<TextFileDetails> textFileDetailsContainer) {
        int inputLength = textFileDetailsContainer.size();

        if (inputLength < 2) {return;}
        
        int midIndex = inputLength / 2;                            
        ArrayList<TextFileDetails> leftHalf = new ArrayList<TextFileDetails>();
        ArrayList<TextFileDetails> rightHalf = new ArrayList<TextFileDetails>();      

        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(textFileDetailsContainer.get(i));
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf.add(textFileDetailsContainer.get(i));
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(textFileDetailsContainer, leftHalf, rightHalf);
    }

    void merge(ArrayList<TextFileDetails> textFileDetailsContainer,
    ArrayList<TextFileDetails> leftHalf, ArrayList<TextFileDetails> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();
        int i = 0 , j = 0, k = 0;

        while(i < leftSize && j < rightSize) {
            if (leftHalf.get(i).getStandaloneOccurances() >= rightHalf.get(j).getStandaloneOccurances()) {
                textFileDetailsContainer.set(k, leftHalf.get(i));
                i++;
            }
            else {
                textFileDetailsContainer.set(k, rightHalf.get(j));
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            textFileDetailsContainer.set(k, leftHalf.get(i));
            i++;
            k++;
        }

        while (j < rightSize) {
            textFileDetailsContainer.set(k, rightHalf.get(j));
            j++;
            k++;
        }
    }

    double occurencePercentage(int occurence, int totalOccurence) {
        if (occurence == 0 || totalOccurence == 0) {return 0;}
        double totalItems = occurence;
        double selectedItems = totalOccurence;
        double percentage = (totalItems / selectedItems) * 100;

        // Round to two decimal places for display
        return Double.parseDouble(String.format("%.2f", percentage));
    }

    void displayToTextArea(ArrayList<TextFileDetails> textFileDetailsContainer, JTextArea textArea, int overallOccurence) {
        for (int i = 0; i < textFileDetailsContainer.size(); i++) {
            textArea.append("\n" + (i + 1) + ".");

            textArea.append(" " + textFileDetailsContainer.get(i).getFileName() + " - ");

            textArea.append(occurencePercentage(textFileDetailsContainer.get(i).getStandaloneOccurances(), overallOccurence) + "% - ");
            
            textArea.append(textFileDetailsContainer.get(i).getStandaloneOccurances() + " occurences");
        }
        textArea.append("\n\n"+ "Total Occurences: " + overallOccurence);
    }

    public ArrayList<String> getCurrentPathToFolder() {
        return currentPathToFolder;
    }

    public void setCurrentPathToFolder(ArrayList<String> currentPathToFolder) {
        this.currentPathToFolder = currentPathToFolder;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
