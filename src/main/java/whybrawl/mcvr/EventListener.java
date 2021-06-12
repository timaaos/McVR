package whybrawl.mcvr;

import net.minecraft.server.v1_16_R3.PacketPlayInBlockDig;
import net.minecraft.server.v1_16_R3.PacketPlayInBlockPlace;
import net.minecraft.server.v1_16_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class EventListener implements Listener {
    /*@EventHandler
    public void onPlayerMovement(PlayerMoveEvent event){
        if(McVR.players_in_vr.contains(event.getPlayer())){
            event.setCancelled(true);
        }
    }*/
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(McVR.players_in_vr.containsKey(player)){
            if(McVR.blocks_in_vr.get(player).containsKey(event.getClickedBlock().getLocation())){
                new BukkitRunnable() {
                    @Override
                    public void run () {
                        Location loc = event.getClickedBlock().getLocation();
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setX(loc.getX()+1);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setX(loc.getX()-2);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setX(loc.getX()+1);
                        loc.setY(loc.getY()+1);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setY(loc.getY()-2);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setY(loc.getY()+1);
                        loc.setZ(loc.getZ()+1);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                        loc.setZ(loc.getZ()-2);
                        if(McVR.blocks_in_vr.get(player).containsKey(loc)){
                            player.sendBlockChange(loc,McVR.blocks_in_vr.get(player).get(loc));
                        }
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("McVR"),1l);
            }
            event.setCancelled(true);
        }
    }
    public void playerExitVR(Player player){
        player.teleport(McVR.players_in_vr.get(player));
        McVR.players_in_vr.remove(player);
        McVR.players_playing.remove(player);
        player.setWalkSpeed(0.2f);
        for (Location loc:McVR.blocks_in_vr.get(player).keySet()) {
            player.sendBlockChange(loc,loc.getBlock().getBlockData());
        }
        McVR.blocks_in_vr.remove(player);
    }
    public void playerVR(Player player) {
        String game = "";
        if (player.getInventory().getItemInMainHand().equals(VR_Helmet.getGame("void"))) {
            game = "void";
            McVR.players_in_vr.put(player, player.getLocation().clone());
            McVR.players_playing.put(player, game);
            McVR.blocks_in_vr.put(player, new HashMap<>());
        }
        if (game.equals("void")) {
            for (int x = player.getLocation().getBlockX() - 7; x < player.getLocation().getBlockX() + 7; x++) {
                for (int z = player.getLocation().getBlockZ() - 7; z < player.getLocation().getBlockZ() + 7; z++) {
                    player.sendBlockChange(new Location(player.getWorld(), x, player.getLocation().getBlockY() - 1, z), BlockVR.MENU_WALL);
                    McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, player.getLocation().getBlockY() - 1, z), BlockVR.MENU_WALL);
                    player.sendBlockChange(new Location(player.getWorld(), x, player.getLocation().getBlockY() + 4, z), BlockVR.MENU_WALL);
                    McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, player.getLocation().getBlockY() + 4, z), BlockVR.MENU_WALL);
                    for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + 4; y++) {
                        if (new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.AIR || new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.GRASS || new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.TALL_GRASS) {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), Material.AIR.createBlockData());
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), Material.AIR.createBlockData());
                        } else {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), BlockVR.MENU_WALL);
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), BlockVR.MENU_WALL);
                        }

                    }
                    if (z == player.getLocation().getBlockZ() - 7 || z == player.getLocation().getBlockZ() + 6 || x == player.getLocation().getBlockX() - 7 || x == player.getLocation().getBlockX() + 6) {
                        for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + 4; y++) {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), BlockVR.MENU_WALL);
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), BlockVR.MENU_WALL);
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        if(event.isSneaking() == false && !McVR.players_in_vr.containsKey(player)){
            if(player.getInventory().getHelmet().equals(VR_Helmet.getHelm())){
                playerVR(player);
            }
        }else if(event.isSneaking() == false && McVR.players_in_vr.containsKey(player)){
            playerExitVR(player);
        }
    }
}
