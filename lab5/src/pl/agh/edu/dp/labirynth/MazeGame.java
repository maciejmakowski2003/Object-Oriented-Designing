package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.sites.MapSite;
import pl.agh.edu.dp.labirynth.sites.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.sites.bombed.BombedWall;
import pl.agh.edu.dp.labirynth.sites.enchanted.Abyss;
import pl.agh.edu.dp.labirynth.sites.enchanted.Chamber;
import pl.agh.edu.dp.labirynth.sites.standard.Door;
import pl.agh.edu.dp.labirynth.sites.standard.Room;
import pl.agh.edu.dp.labirynth.sites.standard.Wall;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MazeGame {
    private Maze maze;
    private Player player;
    private MapSite currentSite;
    private int gameStatus = 0;

    public MazeGame() {}

    public void createMaze(StandardMazeBuilder builder) {
        maze =  builder.buildMaze();
    }

    public void play(){
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        DirectionParser parser = new DirectionParser();
        player = new Player(maze.getRooms().iterator().next());
        MapSite site = player.getCurrentRoom();
        site.enter();

        while(player.isAlive()){
            Direction direction = null;
            while(direction == null) {
                try {
                    System.out.println("Current room: " + player.getCurrentRoom());
                    System.out.println("Choose direction! (N, S, E, W)");
                    direction = parser.parse(consoleReader.readLine());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            site = player.getCurrentRoom().getSide(direction);

            if(site instanceof Wall){
                site.enter();
                System.out.println("Stay in the same room");
                if(site instanceof BombedWall){
                    player.hit();
                    if(!player.isAlive()){
                        gameStatus = -1;
                        break;
                    }
                }
            } else if(site instanceof Door) {
                site.enter();
                site = ((Door) site).getRoom1() != player.getCurrentRoom() ? ((Door) site).getRoom1() : ((Door) site).getRoom2();
            }
            if(site instanceof Room){
                player.move((Room) site);
                site.enter();
                if(site instanceof Chamber){
                    System.out.println("Guess the key (0 or 1): ");
                    try{
                        int key = Integer.parseInt(consoleReader.readLine());
                        if(!((Chamber) site).unlock(key)){
                            player.kill();
                            gameStatus = -1;
                            break;
                        }
                    } catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    gameStatus = 1;
                    break;
                }
            }
        }

        if(gameStatus == 1){
            System.out.println("You win!");
        } else if(gameStatus == -1){
            System.out.println("Game over!");
        }
    }
}
