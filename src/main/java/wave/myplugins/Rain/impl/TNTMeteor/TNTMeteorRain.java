package wave.myplugins.Rain.impl.TNTMeteor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import wave.myplugins.Rain.Rain;

import java.util.ArrayList;
import java.util.List;

public class TNTMeteorRain extends Rain {

    public static final TNTMeteorRain instance = new TNTMeteorRain();
    public static final Material pattern = Material.TNT;
    public List<TNTMeteor> meteorList = new ArrayList<>();

    public TNTMeteorRain() {
        super("&4Дождь из динамита", .00001);
    }

    @Override
    public void summonDrop(Location location) {
        meteorList.add(new TNTMeteor(location));
    }

    @Override
    public void onLand(Location location) {
        TNTMeteor tntMeteor = TNTMeteor.getMeteorBy(location);
        if(tntMeteor != null){
            World world = location.getWorld();
            world.createExplosion(location,3F,false,false);
            tntMeteor.getBlock().remove();
            meteorList.remove(tntMeteor);
        }
    }
}
