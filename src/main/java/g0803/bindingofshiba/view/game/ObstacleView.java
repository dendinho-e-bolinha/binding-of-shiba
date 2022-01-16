package g0803.bindingofshiba.view.game;

import g0803.bindingofshiba.App;
import g0803.bindingofshiba.bundles.Bundle;
import g0803.bindingofshiba.gui.GUI;
import g0803.bindingofshiba.math.Vec2D;
import g0803.bindingofshiba.model.game.elements.Obstacle;
import g0803.bindingofshiba.textures.ITexture;
import g0803.bindingofshiba.view.View;

public class ObstacleView extends View<Obstacle> {

    public ObstacleView(Obstacle model) {
        super(model);
    }

    @Override
    public void draw(App app, GUI gui, Vec2D offset) {

    }
}