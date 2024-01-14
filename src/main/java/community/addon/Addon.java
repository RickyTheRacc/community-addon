package community.addon;

import community.addon.commands.CommandExample;
import community.addon.hud.TravisScott;
import com.mojang.logging.LogUtils;
import community.addon.modules.ModuleExample;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.systems.config.Config;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

import java.util.Calendar;

public class Addon extends MeteorAddon {
    public static final Category CATEGORY = new Category("Community Addon");
    public static final HudGroup HUD_GROUP = new HudGroup("Community Addon");
    public static final Logger LOG = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        LOG.info("Initializing Community Addon");

        // Modules
        Modules.get().add(new ModuleExample());

        // Commands
        Commands.add(new CommandExample());

        // HUD
        Hud.get().register(TravisScott.INFO);

        Config.get().customWindowTitle.set(true);
        Config.get().customWindowTitleText.set("the University of Iowa OWNS you1!1!!");
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_YEAR); i++) {
            Modules.registerCategory(new Category("Fish " + i));
        }
    }

    @Override
    public String getPackage() {
        return "community.addon";
    }
}
