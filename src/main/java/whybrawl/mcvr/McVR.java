package whybrawl.mcvr;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;import java.util.List;

public final class McVR extends JavaPlugin {
    public static HashMap<Player,Location> players_in_vr = new HashMap<>();
    public static HashMap<Player,String> players_playing = new HashMap<>();
    public static HashMap<Player,HashMap<String,Object>> game_vars = new HashMap<>();
    public static HashMap<Player,HashMap<Location, BlockData>> blocks_in_vr = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("givevr").setExecutor(new GiveVR());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
