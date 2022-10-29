package ui;

import model.FilmList;
import model.FilmListEntry;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

//film tracker application
public class Application {      //some code is inspired from TellerApp, JSON work inspired from JSONSerializationDemo

    private static final String JSON_STORE = "./data/filmList.json";
    boolean running = true;
    String command = null;
    FilmList filmList = new FilmList();
    Scanner input = new Scanner(System.in);
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    String name;
    String type;
    String genre;
    int runtime;
    int year;
    double rating;

    BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

    //Effects: runs application
    public Application() throws IOException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApplication();
    }

    /*
    Modifies: this
    Effects: processes user inputs
     */
    private void runApplication() throws IOException, FileNotFoundException {

        while (running) {
            menu();
            command = input.next();
            command = command.toLowerCase();


            if (command.equals("7")) {
                running = false;
            } else {
                process(command);
            }
        }
    }

    // EFFECTS: displays options to user
    private void menu() {       //inspired from TellerApp
        System.out.println("\nSelect option");
        System.out.println("\t1 -> view list");
        System.out.println("\t2 -> add entry");
        System.out.println("\t3 -> remove entry");
        System.out.println("\t4 -> view entry");
        System.out.println("\t5 -> save list");
        System.out.println("\t6 -> load list");
        System.out.println("\t7 -> quit");
    }

    /*
    Modifies: this
    Effects: takes user input and runs the associated command
     */
    private void process(String command) throws IOException {
        if (command.equals("1")) {
            appViewList(filmList);
        } else if (command.equals("2")) {
            appAddEntry(filmList);
        } else if (command.equals("3")) {
            appRemoveEntry(filmList);
        } else if (command.equals("4")) {
            appViewEntry(filmList);
        } else if (command.equals("5")) {
            saveFilmList();
        } else if (command.equals("6")) {
            loadFilmList();
        } else {
            System.out.println("Option not available.");
        }
    }


    //Effects: adds entry to film list
    private void appViewList(FilmList filmList) {
        System.out.println(filmList.getEntries());
    }

    /*
    Modifies: this
    Effects: adds entry to film list
    */
    private void appAddEntry(FilmList filmList) throws IOException {    //inspired by Psy on Quora
        System.out.println("Name of media: ");
        this.name = consoleInput.readLine();

        System.out.println("Type of media (i.e. Film, TV, Animation): ");
        this.type = consoleInput.readLine();

        System.out.println("Type of genre (i.e. Horror, Drama, Romance, Musical): ");
        this.genre = consoleInput.readLine();

        System.out.println("Total length of media (in minutes): ");
        this.runtime = Integer.parseInt(consoleInput.readLine());
        checkLength();

        System.out.println("Year released: ");
        this.year = Integer.parseInt(consoleInput.readLine());
        checkYear();

        System.out.println("Rating: ");
        this.rating = Double.parseDouble(consoleInput.readLine());
        checkRating();

        FilmListEntry entry = new FilmListEntry(this.name, this.type, this.genre, this.runtime, this.year, this.rating);

        filmList.addEntry(entry);

        System.out.println("Entry added!");
    }

    /*
    Modifies: this
    Effects: check is the input is valid, and requests a new input if not
     */
    private void checkLength() throws IOException {
        if (runtime <= 0) {
            System.out.println("Please enter valid runtime: ");
            runtime = Integer.parseInt(consoleInput.readLine());
        }
    }

    /*
    Modifies: this
    Effects: check is the input is valid, and requests a new input if not
     */
    private void checkYear() throws IOException {
        if (year <= 0) {
            System.out.println("Please enter valid year: ");
            year = Integer.parseInt(consoleInput.readLine());
        }
    }

    /*
    Modifies: this
    Effects: check is the input is valid, and requests a new input if not
     */
    private void checkRating() throws IOException {
        if (rating <= 0) {
            System.out.println("Please enter valid rating: ");
            rating = Double.parseDouble(consoleInput.readLine());
        }
    }

    /*
    Modifies: this
    Effects: adds entry to film list
    */
    private void appRemoveEntry(FilmList filmList) throws IOException {
        String removeName;

        System.out.println("Enter name of entry to be removed: ");
        removeName = consoleInput.readLine();

        for (int i = 0; i < filmList.getSize(); i++) {
            FilmListEntry remove = filmList.getEntry(i);
            if (Objects.equals(remove.getName(), removeName)) {
                filmList.removeEntry(remove);
                System.out.println("Entry removed!");
            }
        }
    }

    /*
    Modifies: this
    Effects: adds entry to film list
    */
    private void appViewEntry(FilmList filmList) throws IOException {
        String viewName;

        System.out.println("Enter name of entry to be view: ");
        viewName = consoleInput.readLine();

        for (int i = 0; i < filmList.getSize(); i++) {
            FilmListEntry view = filmList.getEntry(i);
            if (Objects.equals(view.getName(), viewName)) {
                System.out.println(filmList.viewEntry(view));
            }
        }
    }

    // EFFECTS: saves the film list to file
    private void saveFilmList() {
        try {
            jsonWriter.open();
            jsonWriter.write(filmList);
            jsonWriter.close();
            System.out.println("Saved film list to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads film list from file
    private void loadFilmList() {
        try {
            filmList = jsonReader.read();
            System.out.println("Loaded film list from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
