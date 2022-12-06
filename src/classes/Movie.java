package classes;

import java.time.Year;
import java.util.List;



public class Movie{
    private String name;
    private Year year;
    private String description;
    private Director director;
    private List<Cast> casts;

    public Movie() {
    }

    public Movie(String name, Year year, String description, Director director, List<Cast> casts) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.casts = casts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    @Override
    public String toString() {
        return
                "\n>>>>>>>>>> Movie <<<<<<<<<<\n" +
                "Name: " + name + '\n' +
                "Year: " + year +'\n' +
                "Description: " + description + '\n' +
                 director +'\n' +
                 casts +'\n' +
                "_____________________________________________\n";
    }
}
