package g0803.bindingofshiba.model.game;

import g0803.bindingofshiba.Constants;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Obstacle;
import g0803.bindingofshiba.model.game.elements.Player;
import g0803.bindingofshiba.model.game.room.Door;
import g0803.bindingofshiba.model.game.room.DoorPosition;
import g0803.bindingofshiba.model.game.room.Room;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final Player player;
    private Room currentRoom;

    public Game() {
        this.player = new Player(new Vec2D(10, 20), 1, 30, 5);
        this.currentRoom =
                new Room(
                        Constants.ROOM_WIDTH,
                        Constants.ROOM_HEIGHT,
                        Arrays.asList(
                                new Monster(new Vec2D(15, 40), 3, 1),
                                new Monster(new Vec2D(10, 50), 5, 2)),
                        List.of(new Obstacle(30, 15)));

        Room room2 = new Room(Constants.ROOM_WIDTH, Constants.ROOM_HEIGHT, List.of(), List.of());
        Door door = new Door(currentRoom, DoorPosition.TOP, room2, DoorPosition.BOTTOM);
        currentRoom.addDoor(door);
        room2.addDoor(door);
    }

    public Game(Player player, Room room) {
        this.player = player;
        this.currentRoom = room;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
