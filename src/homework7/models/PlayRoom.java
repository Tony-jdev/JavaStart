package homework7.models;

import homework7.constants.Brand;
import homework7.constants.Genre;
import homework7.exceptions.ConsoleOffException;

import java.util.Arrays;
import java.util.Comparator;

public class PlayRoom {

    public static void main(String[] args) {

        Game.GameDisk[] physicalGames = new Game.GameDisk[]{
                Game.getDisk("God of War", Genre.ACTION, "История Кратоса продолжается"),
                Game.getDisk("Elden Ring", Genre.ACTION, "Огромный открытый мир"),
                Game.getDisk("GTA 5", Genre.ACTION, "История банды из Лос-Сантоса"),
                Game.getDisk("Spider-Man", Genre.ACTION, "Приключения Человека-паука")
        };

        Game.VirtualGame[] virtualGames = new Game.VirtualGame[]{
                Game.getVirtualGame("Minecraft", Genre.ACTION),
                Game.getVirtualGame("The Witcher 3: Wild Hunt", Genre.RPG),
                Game.getVirtualGame("Red Dead Redemption 2", Genre.ACTION),
                Game.getVirtualGame("Horizon Forbidden West", Genre.ACTION)
        };

        Arrays.sort(physicalGames, new Comparator<Game.GameDisk>() {
            @Override
            public int compare(Game.GameDisk o1, Game.GameDisk o2) {
                return o1.getData().getGenre().compareTo(o2.getData().getGenre());
            }
        });
        for (Game.GameDisk pgame : physicalGames) {
            System.out.println(pgame);
        }
        Arrays.sort(virtualGames, new Comparator<Game.VirtualGame>() {
            @Override
            public int compare(Game.VirtualGame o1, Game.VirtualGame o2) {
                return Integer.compare(o1.getRating(), o2.getRating());
            }
        });
        for (Game.VirtualGame vgame : virtualGames) {
            System.out.println(vgame);
        }

        GameConsole console = new GameConsole(Brand.SONY, "1234567890");

        Game game = new Game();

        console.powerOn();

        System.out.println("Приставка включена: " + console.isOn());
        console.loadGame(game);
        console.playGame();

        System.out.println("Перший джойстик включений: " + console.getFirstGamepad().isOn());
        System.out.println("Другий джойстик включений: " + console.getSecondGamepad().isOn());

        console.getFirstGamepad().powerOn();
        console.getSecondGamepad().powerOn();

        System.out.println("Перший джойстик включений: " + console.getFirstGamepad().isOn());
        System.out.println("Другий джойстик включений: " + console.getSecondGamepad().isOn());

        for(int i = 0; i < 9; ++i){
            console.playGame();
        }

        console.getFirstGamepad().powerOff();
        console.connectSecondGamepadToFirst();

        System.out.println("Перший джойстик включений: " + console.getFirstGamepad().isOn());
        System.out.println("Другий джойстик включений: " + console.getSecondGamepad().isOn());

        console.playGame();

        console.getFirstGamepad().powerOff();
        console.getSecondGamepad().powerOff();

        System.out.println("Перший джойстик включений: " + console.getFirstGamepad().isOn());
        System.out.println("Другий джойстик включений: " + console.getSecondGamepad().isOn());

        try {
            console.playGame();
        } catch (ConsoleOffException e) {
            System.out.println(e.getMessage());
        }
    }
}
