package wave.myplugins;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;
import wave.myplugins.Rain.Commands.RainStartCMD;
import wave.myplugins.Rain.event.OnLandEvents;

public final class ForBoosty extends JavaPlugin {

    private static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getCommand("rain").setExecutor(new RainStartCMD());
        Bukkit.getServer().getPluginManager().registerEvents(new OnLandEvents(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
