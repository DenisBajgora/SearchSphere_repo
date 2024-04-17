/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 * 
 * The purpose of the SearchBar class, which is an extension of JPanel, is to make 
 * searching easier within Java Swing applications. It has two features: a JTextArea 
 * to show search results and a JTextField for user input. This panel controls search 
 * activities across designated directory paths and shows search word occurrences and 
 * file names as results.
 * 
 * Upon starting a search, the class goes through the text files in the assigned folder, 
 * counts the times the search word appears, and then arranges the results according to 
 * frequency. Sorting is dynamic; a threshold of 20 is used to optimise merge sort for 
 * larger datasets and insertion sort for smaller ones. The results are then shown as a 
 * percentage and in the text field. 
 * 
 * The SearchBar's design is customised with a dark grey backdrop, a text field in the same colour scheme, and text in the 
 * white Consolas typeface. Applications that need to search files must have this panel, 
 * especially ones that deal with a lot of text data.
 */

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

public class SearchBar extends JPanel {

    private JTextField textfield = new JTextField();
    private ArrayList<String> currentPathToFolder;
    private JTextArea textArea;
    private static final int THRESHOLD = 20; // Used to decide sorting method based on list size

    // Define constants for appearance
    private static final Color BACKGROUND_COLOR = new Color(0x212121);
    private static final Dimension TEXT_FIELD_DIMENSION = new Dimension(400, 25);
    private static final Color TEXT_FIELD_COLOR = new Color(0x272727);
    private static final Color TEXT_COLOR = new Color(0xFFFFFF);
    private static final Font TEXT_FONT = new Font("Consolas", Font.PLAIN, 20);

    /**
     * Constructor for the SearchBar.
     * @param currentPathToFolder A list of paths to folders to search within.
     * @param textArea The JTextArea where search results will be displayed.
     */
    public SearchBar(ArrayList<String> currentPathToFolder, JTextArea textArea) {
        setCurrentPathToFolder(currentPathToFolder);
        setTextArea(textArea);
        
        this.setBackground(BACKGROUND_COLOR);
        this.setPreferredSize(new Dimension(0, 20));
        this.setLayout(new FlowLayout());

        textfield.setPreferredSize(TEXT_FIELD_DIMENSION);
        textfield.setBorder(null);
        textfield.setFont(TEXT_FONT);
        textfield.setForeground(TEXT_COLOR);
        textfield.setBackground(TEXT_FIELD_COLOR);
        textfield.setCaretColor(TEXT_COLOR);
        textfield.setSelectionColor(TEXT_COLOR);

        // Add an ActionListener to perform the search when the user presses Enter
        textfield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPathToFolder.isEmpty()) {
                    textArea.setText("Select a Folder!");
                    return;
                }
                if (textfield.getText().isEmpty()) {
                    return;
                }
                performSearch();
                textfield.setText(""); // Clear the textfield for new input after search
            }
        });
        
        this.add(textfield);
    }

    void performSearch() {
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
            if (!(file.isFile())) { continue; }
        
            //System.out.println("Opening file: " + file.getName());
            TextFileDetails textFileDetails = new TextFileDetails();
            textFileDetailsContainer.add(textFileDetails);
            textFileDetails.setFileName(file.getName());
        
            try {
                // Read the entire file content as a string
                String content = new String(Files.readAllBytes(Paths.get(file.getPath())), StandardCharsets.UTF_8);
                int occurrences = countOccurrences(content, textfield.getText());
                //System.out.printf("File: %s: %d total occurrence(s) of '%s'%n", file.getName(), occurrences, textfield.getText());
                textFileDetails.setStandaloneOccurances(occurrences);
                overallOccurence += occurrences;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (textFileDetailsContainer.size() < 20) {
            insertionSort(textFileDetailsContainer);
            //System.out.println("Insertion Sort");
        }
        else {
            mergeSort(textFileDetailsContainer);
            //System.out.println("Merge Sort");
        }
        displayToTextArea(textFileDetailsContainer, textArea, overallOccurence);
        /*for (TextFileDetails textFile : textFileDetailsContainer) {
            System.out.println(textFile.getFileName());
            System.out.println(textFile.getStandaloneOccurances());
            if (occurencePercentage(textFile.getStandaloneOccurances(), overallOccurence) != 0) {
                System.out.println(occurencePercentage(textFile.getStandaloneOccurances(), overallOccurence));
            }
        }
        System.out.println("Overall Occurence: " + overallOccurence);*/
    }

    private static int countOccurrences(String line, String word_or_phrase) {
        // Adjust case to make search case-insensitive
        String tempLine = " " + line.toLowerCase() + " "; // Added spaces to handle start and end of line
        String tempWord = word_or_phrase.toLowerCase();
    
        // Count occurrences
        int occurrences = 0;
        int index = 0;
        while ((index = tempLine.indexOf(tempWord, index)) != -1) {
            
            // Check if the character before and after the word are not letters (ensures standalone word)
            boolean isStandaloneWord = true;
            
            if (index > 0 && Character.isLetter(tempLine.charAt(index - 1))) {
                // Character before the word is a letter, not a standalone word
                isStandaloneWord = false;
            }
            
            int endIndex = index + tempWord.length();
            if (endIndex < tempLine.length() && Character.isLetter(tempLine.charAt(endIndex))) {
                // Character after the word is a letter, not a standalone word
                isStandaloneWord = false;
            }
            
            if (isStandaloneWord) {
                occurrences++;
            }
            
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

    void insertionSort(ArrayList<TextFileDetails> textFileDetailsContainer) {
        for (int i = 1; i < textFileDetailsContainer.size(); i++) {
            TextFileDetails currentValue = textFileDetailsContainer.get(i);

            int j = i - 1;
            while (j >= 0 && textFileDetailsContainer.get(j).getStandaloneOccurances() < currentValue.getStandaloneOccurances()) {
                textFileDetailsContainer.set(j + 1, textFileDetailsContainer.get(j));
                j--;
            }
            textFileDetailsContainer.set(j + 1, currentValue);
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

    // Getters and Setters.
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
    
    public int getThereshold() {
        return THRESHOLD;
    }

}
