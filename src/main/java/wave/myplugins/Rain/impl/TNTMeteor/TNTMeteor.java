package wave.myplugins.Rain.impl.TNTMeteor;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.FallingBlock;
import org.bukkit.persistence.PersistentDataType;

import java.util.Random;

public class TNTMeteor {
    private  FallingBlock block;

    public FallingBlock getBlock() {
        return block;
    }

    public static TNTMeteor getMeteorBy(Location location){
        for(TNTMeteor meteor : TNTMeteorRain.instance.meteorList){
            if(meteor.block.getLocation().distance(location) < 1) {
                return meteor;
            }
        }
        return null;
    }


    public TNTMeteor(Location location) {
        Location temp = new Location(location.getWorld(),location.getX(),location.getY(),location.getZ());
        FallingBlock fallingBlock = temp.getWorld().spawnFallingBlock(
                temp,
                TNTMeteorRain.instance.pattern.createBlockData()
        );
        fallingBlock.setDropItem(false);
        fallingBlock.getPersistentDataContainer().set(NamespacedKey.fromString("meteor"), PersistentDataType.INTEGER,1);
        block = fallingBlock;

    }

}
