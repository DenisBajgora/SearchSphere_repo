/*
 *  Author: Denis Bajgora
 *  Date: 17/04/24
 *  Description:
 *
 * Text file details are best captured by the TextFileDetails class, which is especially helpful for 
 * searching within Java applications. The file name and the number of separate instances of a search term 
 * in the file are stored in this class. The class makes it simple to access and modify the file name and the
 * number of occurrences by including getter and setter methods.
 *  
 */

public class TextFileDetails {
    // Fields
    private String fileName; // The name of the file
    private int standaloneOccurances; // The count of standalone occurrences

    /**
     * Gets the file name.
     * @return The name of the file.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the file name.
     * @param fileName The name of the file to set.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets the number of standalone occurrences.
     * @return The count of standalone occurrences.
     */
    public int getStandaloneOccurances() {
        return standaloneOccurances;
    }

    /**
     * Sets the number of standalone occurrences.
     * @param standaloneOccurances The count of standalone occurrences to set.
     */
    public void setStandaloneOccurances(int standaloneOccurances) {
        this.standaloneOccurances = standaloneOccurances;
    }
}
