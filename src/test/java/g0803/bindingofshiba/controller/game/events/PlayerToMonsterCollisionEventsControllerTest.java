package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.events.game.PlayerCollisionWithMonsterEvent;
import g0803.bindingofshiba.math.BoundingBox;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.Game;
import g0803.bindingofshiba.model.game.room.Room;
import g0803.bindingofshiba.model.game.elements.Monster;
import g0803.bindingofshiba.model.game.elements.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class PlayerToMonsterCollisionEventsControllerTest {

    @Test
    public void playerCollidingWithMonster() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(3)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster.getNextPosition(3)).thenReturn(new Vec2D(14, 0));

        Room room = Mockito.mock(Room.class);
        Mockito.when(room.getMonsters()).thenReturn(List.of(monster));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, room);
        PlayerToMonsterCollisionEventsController controller = new PlayerToMonsterCollisionEventsController(game, manager);

        controller.tick(app, 3);

        Mockito.verify(manager)
                .dispatchEvent(
                        Mockito.argThat(
                                event -> {
                                    if (!(event instanceof PlayerCollisionWithMonsterEvent e))
                                        return false;

                                    return e.getPlayer() == player
                                            && e.getMonster() == monster
                                            && e.getTickTime() == 3;
                                }));
    }

    @Test
    public void playerNotCollidingWithMonster() {
        App app = Mockito.mock(App.class);

        Bundle<BoundingBox> boundingBoxes = Mockito.mock(Bundle.class);
        Mockito.when(boundingBoxes.get("shiba")).thenReturn(new BoundingBox(-5, -4, 10, 8));
        Mockito.when(boundingBoxes.get("monster")).thenReturn(new BoundingBox(-3, -5, 6, 10));

        Mockito.when(app.getBoundingBoxes()).thenReturn(boundingBoxes);

        Player player = Mockito.mock(Player.class);
        Monster monster = Mockito.mock(Monster.class);

        Mockito.when(player.getNextPosition(4)).thenReturn(new Vec2D(13, 1));
        Mockito.when(monster.getNextPosition(4)).thenReturn(new Vec2D(18, 14));

        Room room = Mockito.mock(Room.class);
        Mockito.when(room.getMonsters()).thenReturn(List.of(monster));

        EventManager manager = Mockito.mock(EventManager.class);
        Game game = new Game(player, room);
        PlayerToMonsterCollisionEventsController controller = new PlayerToMonsterCollisionEventsController(game, manager);

        controller.tick(app, 4);

        Mockito.verifyNoInteractions(manager);
    }
}
