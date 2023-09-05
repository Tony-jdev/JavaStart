package homework7.models;

import homework7.constants.Genre;
import homework7.constants.Type;

public class Game {

    private final String name;
    private final Genre ganre;
    private final Type type;

    public Game() {
        this.name = "name";
        this.ganre = Genre.RACE;
        this.type = Type.PHYSICAL;
    }

    private Game(String name, Genre ganre, Type type) {
        this.name = name;
        this.ganre = ganre;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return ganre;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", ganre=" + ganre +
                ", type=" + type +
                '}';
    }

    public static class GameDisk {

        private final String description;
        private final Game data;

        private GameDisk(String name, Genre ganre, String description) {
            this.data = new Game(name, ganre, Type.PHYSICAL);
            this.description = description;
        }

        @Override
        public String toString() {
            return "GameDisk{" +
                    "description='" + description + '\'' +
                    ", data=" + data +
                    '}';
        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }

    public static class VirtualGame {

        private int rating;
        private final Game data;

        private VirtualGame(String name, Genre ganre) {
            this.data = new Game(name, ganre, Type.VIRTUAL);
            rating = 1;
        }

        @Override
        public String toString() {
            return "VirtualGame{" +
                    "rating=" + rating +
                    ", data=" + data +
                    '}';
        }

        public int getRating() {
            return rating;
        }

        public Game getData() {
            return data;
        }
    }

    public static GameDisk getDisk(String name, Genre ganre, String description) {
        return new GameDisk(name, ganre, description);
    }

    public static VirtualGame getVirtualGame(String name, Genre ganre) {
        return new VirtualGame(name, ganre);
    }
}

