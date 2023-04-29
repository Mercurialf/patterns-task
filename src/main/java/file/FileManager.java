package file;

import movie.Movie;
import utils.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void saveObject(Serializable object, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName + ".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(object);
            objectOutputStream.close();
            fos.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void saveAllMovie(List<Movie> movies) {
        try {
            FileOutputStream fos = new FileOutputStream(Config.MOVIE_STORAGE_PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(movies);
            objectOutputStream.close();
            fos.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static List<Movie> loadAllMovie() {
        List<Movie> movies = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(Config.MOVIE_STORAGE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            movies = (List<Movie>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        return movies;
    }
}
