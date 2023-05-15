package wave.myplugins.Rain;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import wave.myplugins.ForBoosty;

import java.util.Random;

public abstract class Rain {
    private final String name;
    private final double standardChance;

    public Rain(String name, double standardChance) {
        this.name = name;
        this.standardChance = standardChance;
    }

    public void start(long length){
        Random random = new Random();
        new BukkitRunnable(){
            int ctr = 0;

            @Override
            public void run() {
                for(World world : Bukkit.getWorlds()){
                    if(world.getEnvironment() == World.Environment.NORMAL){
                        for(Chunk chunk : world.getLoadedChunks()){
                            for(int x = 0; x < 16; x++){
                                for(int z = 0; z < 16; z++){
                                    if(random.nextDouble() < standardChance){
                                        Location location = chunk.getBlock(x,world.getMaxHeight(),z).getLocation();
                                        summonDrop(location);
                                    }
                                }
                            }
                        }
                    }
                }
                if(ctr >= length)
                    cancel();
                else
                    ctr += 1;
            }
        }.runTaskTimer(ForBoosty.getInstance(),0L,1L);

    }
    public abstract void summonDrop(Location location);
    public abstract void onLand(Location location);

    public String getName() {
        return name;
    }

    public double getStandardChance() {
        return standardChance;
    }
}
