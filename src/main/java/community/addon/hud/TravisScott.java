package community.addon.hud;

import community.addon.Addon;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementInfo;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.utils.render.color.Color;
import net.minecraft.util.Identifier;

public class TravisScott extends HudElement {
    public static final HudElementInfo<TravisScott> INFO = new HudElementInfo<>(Addon.HUD_GROUP, "teravilis scot", "", TravisScott::new);

    public TravisScott() {
        super(INFO);
    }

    private final Identifier travisScott = new Identifier("template", "travisscott.png");

    @Override
    public void render(HudRenderer renderer) {
        renderer.texture(travisScott, x,y,400,200,Color.WHITE);
    }
}
