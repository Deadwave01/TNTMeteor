package wave.myplugins.Rain.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import wave.myplugins.Rain.impl.TNTMeteor.TNTMeteorRain;

public class RainStartCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args[0].equals("TNTRain")){
                TNTMeteorRain.instance.start(1200);
            }
        }
        return true;
    }
}
