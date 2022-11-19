package ui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import javax.swing.*;

import model.FilmList;
import model.FilmListEntry;
import persistence.JsonReader;
import persistence.JsonWriter;

public class ApplicationGUI extends JFrame {
    private static final String newline = "\n";

    private String name;
    private String tom;
    private String genre;
    private int runtime;
    private int year;
    private double rating;

    private FilmListEntry entry;
    private FilmListEntry chosen;
    FilmList filmList = new FilmList();

    JButton loadButton;
    JButton saveButton;
    JButton addFilmButton;
    JButton removeFilmButton;
    JButton viewFilmButton;
    JList list;

    JTextArea log;

    private static final String JSON_STORE = "./data/filmList.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    /*
    EFFECTS: creates the buttons for the interface
     */
    public ApplicationGUI() {
        super("Film Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        loadButton = new JButton("Load Data");
        loadButton.setActionCommand("load");
        loadButton.addActionListener(this::actionPerformed);

        saveButton = new JButton("Save Data");
        saveButton.setActionCommand("save");
        saveButton.addActionListener(this::actionPerformed);

        addFilmButton = new JButton("Add Entry");
        addFilmButton.setActionCommand("add");
        addFilmButton.addActionListener(this::actionPerformed);

        removeFilmButton = new JButton("Remove Entry");
        removeFilmButton.setActionCommand("remove");
        removeFilmButton.addActionListener(this::actionPerformed);

        viewFilmButton = new JButton("View Media List");
        viewFilmButton.setActionCommand("view");
        viewFilmButton.addActionListener(this::actionPerformed);

        addButtons();

        pack();
        setVisible(true);
    }

    /*
    EFFECTS: Adds the buttons created earlier
     */
    private void addButtons() {
        add(loadButton,BorderLayout.SOUTH);
        add(saveButton,BorderLayout.NORTH);
        add(addFilmButton,BorderLayout.EAST);
        add(removeFilmButton,BorderLayout.WEST);
        add(viewFilmButton, BorderLayout.CENTER);
    }

    /*
    EFFECTS: matches method to command from button
     */
    private void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("load")) {
            loadData();
        } else if (actionEvent.getActionCommand().equals("save")) {
            saveData();
        } else if (actionEvent.getActionCommand().equals("add")) {
            inputText();
        } else if (actionEvent.getActionCommand().equals("remove")) {
            removeEntries();
        } else {
            viewEntries();
        }
    }

    /*
    MODIFIES: this
    EFFECTS: loads film list from file
     */
    private void loadData() {
        try {
            filmList = jsonReader.read();
            JOptionPane.showMessageDialog(this,"Loaded film list from " + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"Unable to read from file: " + JSON_STORE);
        }
    }

    /*
    EFFECTS: saves the film list to file
     */
    private void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(filmList);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this,"Saved film list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this,"Unable to write to file: " + JSON_STORE);
        }
    }

    /*
    MODIFIES: this
    EFFECTS: adds entry to film list
    */
    public void inputText() {
        name = JOptionPane.showInputDialog("What is the name of the entry?");
        tom = JOptionPane.showInputDialog("What type of media is it?");
        genre = JOptionPane.showInputDialog("What genre is it?");
        runtime = Integer.parseInt(JOptionPane.showInputDialog("What is the runtime of the entry?"));
        year = Integer.parseInt(JOptionPane.showInputDialog("When was it first released?"));
        rating = Double.parseDouble(JOptionPane.showInputDialog("What would you rate it (decimals allowed)?"));
        JOptionPane.showMessageDialog(this, "Entry of name " + name + " added!");

        entry = new FilmListEntry(this.name, this.tom, this.genre, this.runtime, this.year, this.rating);

        filmList.addEntry(entry);
    }

    /*
    MODIFIES: this
    EFFECTS: displays the list of names of entries, with an ImageIcon
     */
    public void viewEntries() {

        String[] entries = filmList.getEntries().toArray(new String[filmList.getSize() - 1]);
        ImageIcon duck = new ImageIcon("./data/duckpfp.png");
        Image image = duck.getImage(); // transform it
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        duck = new ImageIcon(newImage);
        String input = (String) JOptionPane.showInputDialog(null, "Choose entry to view",
                "All Entries", JOptionPane.QUESTION_MESSAGE, duck, entries, entries[0]);

        if (filmList.getSize() == 0) {
            JOptionPane.showMessageDialog(this, "There are no entries to view!");
        } else {
            for (int i = 0; i < filmList.getSize(); i++) {
                FilmListEntry view = filmList.getEntry(i);
                if (Objects.equals(view.getName(), input)) {
                    JOptionPane.showMessageDialog(this, filmList.viewEntry(view));
                }
            }
        }
    }


    /*
    REQUIRES: entry is in film list
    MODIFIES: this
    EFFECTS: removes entry
     */
    public void removeEntries() {

        String[] entries = filmList.getEntries().toArray(new String[filmList.getSize() - 1]);
        list = new JList(entries); //data has type Object[]
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(-1);


        String input = (String) JOptionPane.showInputDialog(null, "Choose entry to delete",
                "All Entries", JOptionPane.QUESTION_MESSAGE, null, entries, entries[0]);

        for (int i = 0; i < filmList.getSize(); i++) {
            FilmListEntry view = filmList.getEntry(i);
            if (Objects.equals(view.getName(), input)) {
                filmList.removeEntry(view);
                JOptionPane.showMessageDialog(this, "Removed entry " + input);
            }
        }
    }


}
