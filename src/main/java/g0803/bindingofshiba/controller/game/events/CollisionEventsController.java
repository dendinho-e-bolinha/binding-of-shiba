package g0803.bindingofshiba.controller.game.events;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.controller.Controller;
import g0803.bindingofshiba.events.EventManager;
import g0803.bindingofshiba.model.game.Game;

public class CollisionEventsController extends Controller<Game> {

    public CollisionEventsController(Game model, EventManager eventManager) {
        super(model, eventManager);
    }

    @Override
    public void tick(App app, double dt) {
        throw new RuntimeException("Not implemented");
    }
}