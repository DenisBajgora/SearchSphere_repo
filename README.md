# Search Sphere

![image](https://github.com/DenisBajgora/SearchSphere_repo/assets/124717960/e0b3614d-236d-4a7d-a36e-1dc0689e056e)


### Project Overview

Search Sphere is a Java-based desktop application designed to facilitate file and text management tasks. The application features a user-friendly graphical user interface (GUI) built using Java Swing. It allows users to search within text files, save outputs, and manage file directories efficiently.

# List of Classes

**Main:** The entry point of the application, responsible for launching the main window by creating an instance of MainFrame.


**MainFrame:** Sets up the main window of the application, including layout and initialization of all panels.


**Header:** Displays the application's title and logo at the top of the main window.


**Footer:** Contains copyright information and is displayed at the bottom of the main window.


**CenterPanel:** Hosts the main text area for displaying search results and other text outputs.


**MainPanel:** Serves as the container for Header, SearchBar, and Footer, organizing the main components vertically.


**SearchBar:** Allows users to enter search terms and initiate the search process across specified directory paths.


**ClearButton:** Clears the text displayed in the CenterPanel.


**SaveOutput:** Saves the current text in the CenterPanel to a file.


**SelectFolder:** Opens a dialog to select the directory for file searches or output saving.


**TextFileDetails:** Manages the details about text files, specifically tracking occurrences of search terms.

# Core Functionality

**Text Search:** Users can search for specific terms within text files located in selected directories.

**File Saving:** Text output visible in the application can be saved directly from the GUI to a chosen location.

**Directory Selection(Search Space):** Users can specify the folder to search in or save files to.

**Mutli File Support:** Users that can specify a folder with different file extenstions and as long as those files contain text it will open and read it. 

**Phrase Support:** Users can enter words like "Christmas Day" and it will search for that exact phrase.

**Non-Case-Senstive:** Search Sphere will search for the same word regardless if the word is upper case or not. 

**Ranking Mechanism:** File that contains the highest occurence of a word/phrase will be returned first and the least will be returned last along with a calucation match (%).

# Optional Functionality

**Visual Feedback for Button Interactions:** Buttons change color on hover and when clicked, providing clear visual cues to users.

**Resizable Text Areas:** Users can adjust the size of text areas to accommodate different volumes of text. 

**GUI Design:** The GUI is simple yet clean with a beautiful dark background. Search Sphere makes gives Users a clear indication where to input text. 

# Future Enhancements

### Polymorphism

If more time were available, I would integrate polymorphism to handl euser actions through a single interface,enabling the application to execute different actions dynamically at runtime depending on the object type, without needing to know the exact class of the objects.

### Multi-Threading

Another enhancement would be the addition of multi-threading to improve performance, especially when handling large files or performing long-running searches. This could prevent the GUI from freezing and improve user experience by allowing simultaneous execution of tasks such as searching in one thread and updating the GUI in another.



