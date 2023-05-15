package wave.myplugins.Rain.event;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.persistence.PersistentDataType;
import wave.myplugins.Rain.impl.TNTMeteor.TNTMeteorRain;

public class OnLandEvents implements Listener {

    @EventHandler
    public void onLand(EntityChangeBlockEvent e){
        if(e.getEntity() instanceof FallingBlock){
            if(e.getEntity().getPersistentDataContainer().has(NamespacedKey.fromString("meteor"), PersistentDataType.INTEGER)){
                TNTMeteorRain.instance.onLand(e.getBlock().getLocation());
                e.setCancelled(true);
            }
        }
    }
}
