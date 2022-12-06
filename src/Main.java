import services.impl.MovieService;

import java.time.Year;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieService service = new MovieService();
        while (true) {
            commandsVersionEnglish();
            commandsVersionRussian();
            switch (scanner.nextLine()) {
                case "1" -> System.out.println(service.getAllMovies(service.creatingAllMovies()));
                case "2" -> {
                    System.out.print("Write movie name: ");
                    service.findMovieByName(service.creatingAllMovies(), scanner.nextLine());
                }
                case "3" -> service.sortByYear(service.creatingAllMovies());
                case "4" -> service.sortByMovieName(service.creatingAllMovies());
                case "5" -> service.sortByDirectorName(service.creatingAllMovies());
                case "6" -> {
                    System.out.print("Write actor's name: ");
                    service.findMovieByActorName(service.creatingAllMovies(), scanner.nextLine());
                }
                case "7" -> {
                    System.out.print("Write director's name: ");
                    service.findMovieByDirector(service.creatingAllMovies(), scanner.nextLine());

                }
                case "8" -> {
                    System.out.print("Write the year the movie was released: ");
                    service.findMovieByYear(service.creatingAllMovies(), Year.of(Integer.parseInt(scanner.nextLine())));
                }
                case "9" -> {
                    System.out.print("Write movie's description: ");
                    service.findMovieByDescription(service.creatingAllMovies(), scanner.nextLine());
                }
                case "10" -> {
                    System.out.print("Write actor's role: ");
                    service.findMovieByRole(service.creatingAllMovies(), scanner.nextLine());
                }
                default -> System.out.println("Wrong commands");
            }
        }
    }
    public static void commandsVersionEnglish(){
        System.out.println("""
                =================== Commands ===================
                Press 1 to print catalog
                Press 2 to find a movie by full or part name
                Press 3 to sort by year
                Press 4 to sort by name
                Press 5 to sort by director
                Press 6 to find movies by actor's name
                Press 7 to find movies by director's name
                Press 8 to find movies by year
                Press 9 to list all movies by description
                Press 10 to find movies by actor's role
                =================================================
               
                """);
    }

    public static void commandsVersionRussian(){
        System.out.println("""
                                 =================== Команды ====================
                                 Нажмите 1, чтобы распечатать каталог
                                 Нажмите 2, чтобы найти фильм по полному или частичному названию.
                                 Нажмите 3, чтобы отсортировать по году
                                 Нажмите 4 для сортировки по имени
                                 Нажмите 5 для сортировки по директору
                                 Нажмите 6, чтобы найти фильмы по имени актера
                                 Нажмите 7, чтобы найти фильмы по имени режиссера
                                 Нажмите 8, чтобы найти фильмы по годам
                                 Нажмите 9, чтобы просмотреть все фильмы по описанию.
                                 Нажмите 10, чтобы найти фильмы по роли актера
                                 =================================================
                """);
    }
}