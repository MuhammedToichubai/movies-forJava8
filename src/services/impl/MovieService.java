package services.impl;

import classes.Cast;
import classes.Director;
import classes.Movie;
import services.FindAble;
import services.SortAble;

import javax.management.AttributeNotFoundException;
import javax.management.relation.RoleInfoNotFoundException;
import javax.naming.NameNotFoundException;
import java.time.Year;
import java.util.*;

public class MovieService implements FindAble, SortAble {

    public List<Movie> creatingAllMovies(){
        return List.of(
                new Movie("Аватар", Year.of(2009), "Фантастика",
                        new Director("Джеймс", "Кэмерон"),
                        List.of
                                (
                                        new Cast("Зои Салдана", "Актриса"),
                                        new Cast("Сигурни Уивер", "Актриса"),
                                        new Cast("Сэм Уортингтон", "Актёр"),
                                        new Cast("Джованни Рибизи", "Актёр")
                                )
                ),
                new Movie("Доктор Стрэндж", Year.of(2022), "Боевик",
                        new Director("Скотт", "Дерриксон"),
                        List.of
                                (
                                        new Cast("Рэйчел Макадамс", "Актриса"),
                                        new Cast("Линда Дуань", "Актриса"),
                                        new Cast("Бенедикт Камбербэтч", "Актёр"),
                                        new Cast("Бенедикт Вонг", "Актёр")
                                )
                ),
                new Movie("Настоящий детектив", Year.of(2019), "Детектив",
                        new Director("Дэниэл", "Сакхайм"),
                        List.of
                                (
                                        new Cast("Рэйчел Макадамс", "Актриса"),
                                        new Cast("Мишель Монахэн", "Актриса"),
                                        new Cast("Келли Райлли", "Актриса"),
                                        new Cast("Майкл Поттс", "Актёр"),
                                        new Cast("Тейлор Китч", "Актёр")
                                )
                ),
                new Movie("Человек-паук: Нет пути домой", Year.of(2021), "Фантастика",
                        new Director("Джон", "Уоттс"),
                        List.of
                                (
                                        new Cast("Зендея", "Актриса"),
                                        new Cast("Элизабет Олсен", "Актриса"),
                                        new Cast("Энгаури Райс", "Актриса"),
                                        new Cast("Том Холланд", "Актёр"),
                                        new Cast("Эндрю Гарфилд", "Актёр"),
                                        new Cast("Бенедикт Камбербэтч", "Актёр")
                                )
                ),
                new Movie("Доктор Хаус", Year.of(2012), "Драма",
                        new Director("Дэниэл", "Сакхайм"),
                        List.of
                                (
                                        new Cast("Дженнифер Моррисон", "Актриса"),
                                        new Cast("Рекха Шарма", "Актриса"),
                                        new Cast("Роберт Шон Леонард", "Актёр"),
                                        new Cast("Джесси Спенсер", "Актёр"),
                                        new Cast("Хью Лори", "Актёр")
                                )
                ),
                new Movie("Аяш", Year.of(2021), "Комедия",
                        new Director("Бакыт", "Осмонканов"),
                        List.of
                                (
                                        new Cast("Динара Багышбаева", "Актриса"),
                                        new Cast("Калипа Таштанова", "Актриса"),
                                        new Cast("Бакыт Осмонканов", "Актёр"),
                                        new Cast("Жениш Майрамбек уулу", "Актёр")
                                )
                ),
                new Movie("Напарники", Year.of(2015), "Криминал",
                        new Director("Бакыт", "Осмонканов"),
                        List.of
                                (
                                        new Cast("Динара Багышбаева", "Актриса"),
                                        new Cast("Атай Омурбеков", "Актёр"),
                                        new Cast("Азамат Уланов", "Актёр"),
                                        new Cast("Бакыт Мукул", "Актёр"),
                                        new Cast("Бакыт Осмонканов", "Актёр"),
                                        new Cast("Жениш Майрамбек уулу", "Актёр")
                                )
                ),
                new Movie("В поисках мамы", Year.of(2017), "Комедия",
                        new Director("Руслан", "Акун"),
                        List.of
                                (
                                        new Cast("Светлана Титова", "Актриса"),
                                        new Cast("Мередит Луиз Томас", "Актриса"),
                                        new Cast("Александр Бабаев", "Актёр"),
                                        new Cast("Азамат Уланов", "Актёр"),
                                        new Cast("Таукел Мусилим", "Актёр"),
                                        new Cast("Жениш Майрамбек уулу", "Актёр"),
                                        new Cast("Бакыт Осмонканов", "Актёр")
                                )
                )
        );
    }

    @Override
    public List<Movie> getAllMovies(List<Movie> movies) {
        List<Movie> list = null;
        if (movies.isEmpty()){
            try {
                throw new NullPointerException();
            }catch (NullPointerException e){
                System.err.println("No movies, list is empty: "+e);
            }
        }else {
            list = movies;
        }
        return list;
    }

    @Override
    public void findMovieByName(List<Movie> movies, String movieName) {
        try {
            List<Movie> collect = movies.stream()
                    .filter(movie -> movie.getName()
                            .equals(movieName)).toList();
            collect
                    .forEach(System.out::println);

            if (movies.isEmpty()) throw new NullPointerException();
            if (collect.isEmpty()) throw new NameNotFoundException();
        } catch (NullPointerException | NameNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void findMovieByActorName(List<Movie> movies, String actorFullName) {
        try{
            List<Movie> arrayList = new ArrayList<>();
            for (Movie movie : movies) {
                for (Cast cast : movie.getCasts()) {
                    if (cast.getActorFullName().equals(actorFullName)){
                        arrayList.add(movie);
                    }
                }
            }
            if (movies.isEmpty()) throw new NullPointerException();
            if (arrayList.isEmpty()) throw new NameNotFoundException();
            arrayList.forEach(System.out::println);
        } catch (NullPointerException | NameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void findMovieByYear(List<Movie> movies, Year year) {
        try {
            List<Movie> list = movies.
                    stream().
                    filter(movie -> movie.getYear().equals(year)).toList();
            list
                   .forEach(System.out::println);
            if (movies.isEmpty()) throw new NullPointerException();
            if (list.isEmpty()) throw new AttributeNotFoundException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void findMovieByDirector(List<Movie> movies, String directorFullName) {
        try {
            List<Movie> list = movies
                    .stream()
                    .filter(movie ->
                            movie.getDirector().getName().replace(" ", "")
                                    .concat(movie.getDirector().getLastName().replace(" ", ""))
                                    .contains(directorFullName.replace(" ", ""))).toList();
            list
                  .forEach(System.out::println);
            if (movies.isEmpty()) throw new NullPointerException();
            if (list.isEmpty()) throw new NameNotFoundException();
        } catch (NullPointerException | NameNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void findMovieByDescription(List<Movie> movies, String description) {
        try {
            List<Movie> list = movies.stream()
                    .filter(movie -> movie.getDescription()
                            .equals(description)).toList();
            list
                    .forEach(System.out::println);

            if (movies.isEmpty()) throw new NullPointerException();
            if (list.isEmpty()) throw new NameNotFoundException();
        } catch (NullPointerException | NameNotFoundException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void findMovieByRole(List<Movie> movies, String role) {
        try{
            List<Movie> list = new LinkedList<>();
            for (Movie movie : movies) {
                for (Cast cast : movie.getCasts()) {
                    if (cast.getRole().equals(role)){
                        list.add(movie);
                    }
                }
            }
            if (movies.isEmpty()) throw new NullPointerException();
            if (list.isEmpty()) throw new RoleInfoNotFoundException();
            list.forEach(System.out::println);
        } catch (NullPointerException | RoleInfoNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void sortByMovieName(List<Movie> movies) {

        try {
            System.out.print("""
                    How to sort
                    press: asc
                    press: desc
                    write: 
                    """);

            switch (new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT)){
                case "ASC" -> {
                    movies.stream()
                            .sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                            .forEach(System.out::println);
                }
                case "DESC" ->{
                    movies.stream()
                            .sorted(Comparator.comparing(Movie::getName).reversed())
                            .forEach(System.out::println);
                }
            }
            if (movies.isEmpty()) throw new NullPointerException();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void sortByYear(List<Movie> movies) {
        try {
            System.out.print("""
                    How to sort
                    press: asc
                    press: desc
                    write: 
                    """);

            switch (new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT)){
                case "ASC" -> {
                    movies.stream()
                            .sorted(Comparator.comparing(Movie::getYear))
                            .forEach(System.out::println);
                }
                case "DESC" ->{
                    movies.stream()
                            .sorted(Comparator.comparing(Movie::getYear).reversed())
                            .forEach(System.out::println);
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }

    @Override
    public void sortByDirectorName(List<Movie> movies) {
        try {
            System.out.print("""
                    How to sort
                    press: asc
                    press: desc
                    write: 
                    """);

            switch (new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT)){
                case "ASC" -> {
                    movies.stream()
                            .sorted((o1, o2) -> o1.getDirector().getName().compareTo(o2.getDirector().getName()))
                            .forEach(System.out::println);
                }
                case "DESC" ->{
                    LinkedList<String> directorNameList = new LinkedList<>();
                    for (int i = 0; i < movies.size(); i++) {
                        directorNameList.add(movies.get(i).getDirector().getName());
                    }
                    Collections.sort(directorNameList);
                    Collections.reverse(directorNameList);

                    for (String directorName : directorNameList) {
                        for (Movie movie : movies) {
                            if (directorName.equals(movie.getDirector().getName())){
                                System.out.println(movie);
                            }
                        }
                    }
                    if (directorNameList.isEmpty()) throw new NullPointerException();
                }
            }
            if (movies.isEmpty()) throw new NullPointerException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
