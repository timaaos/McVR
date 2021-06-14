package whybrawl.mcvr;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
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
                if(McVR.players_playing.get(player).equals("void")) {

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Location loc = event.getClickedBlock().getLocation();
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setX(loc.getX() + 1);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setX(loc.getX() - 2);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setX(loc.getX() + 1);
                            loc.setY(loc.getY() + 1);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setY(loc.getY() - 2);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setY(loc.getY() + 1);
                            loc.setZ(loc.getZ() + 1);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                            loc.setZ(loc.getZ() - 2);
                            if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                            }
                        }
                    }.runTaskLater(Bukkit.getPluginManager().getPlugin("McVR"), 1l);
                }else if(McVR.players_playing.get(player).equals("diamond")) {
                    if(McVR.blocks_in_vr.get(player).get(event.getClickedBlock().getLocation()).getMaterial().equals(Material.DIAMOND_ORE) && event.getAction().equals(Action.LEFT_CLICK_BLOCK))
                    {
                        if(!McVR.game_vars.get(player).containsKey("click_times")){
                            McVR.game_vars.get(player).put("click_times",1);
                            player.sendMessage("You need to beat CoolGamer777's record.");
                            player.sendMessage("P.S. his record is 777.");
                        }else{
                            McVR.game_vars.get(player).put("click_times",(Integer)McVR.game_vars.get(player).get("click_times")+1);
                        }
                        if((Integer)McVR.game_vars.get(player).get("click_times") > 777){
                            player.sendTitle("Achievment!","You beat CoolGamer777's record",5,20,5);
                        }
                        String message = "You clicked on diamond " + McVR.game_vars.get(player).get("click_times") + " times";
                        player.spigot().sendMessage(ChatMessageType.ACTION_BAR,TextComponent.fromLegacyText(message));
                    }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                Location loc = event.getClickedBlock().getLocation();
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setX(loc.getX() + 1);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setX(loc.getX() - 2);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setX(loc.getX() + 1);
                                loc.setY(loc.getY() + 1);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setY(loc.getY() - 2);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setY(loc.getY() + 1);
                                loc.setZ(loc.getZ() + 1);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                                loc.setZ(loc.getZ() - 2);
                                if (McVR.blocks_in_vr.get(player).containsKey(loc)) {
                                    player.sendBlockChange(loc, McVR.blocks_in_vr.get(player).get(loc));
                                }
                            }
                        }.runTaskLater(Bukkit.getPluginManager().getPlugin("McVR"), 1l);
                }
            }
            event.setCancelled(true);
        }
    }
    public void playerExitVR(Player player){
        player.teleport(McVR.players_in_vr.get(player));
        McVR.players_in_vr.remove(player);
        McVR.players_playing.remove(player);
        if(McVR.game_vars.containsKey(player)){
            McVR.game_vars.remove(player);
        }
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
        }else if (player.getInventory().getItemInMainHand().equals(VR_Helmet.getGame("diamond"))) {
            game = "diamond";
            McVR.players_in_vr.put(player, player.getLocation().clone());
            McVR.players_playing.put(player, game);
            McVR.blocks_in_vr.put(player, new HashMap<>());
            McVR.game_vars.put(player, new HashMap<>());
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
        }else if (game.equals("diamond")) {
            for (int x = player.getLocation().getBlockX() - 5; x < player.getLocation().getBlockX() + 5; x++) {
                for (int z = player.getLocation().getBlockZ() - 5; z < player.getLocation().getBlockZ() + 5; z++) {
                    player.sendBlockChange(new Location(player.getWorld(), x, player.getLocation().getBlockY() - 1, z), BlockVR.DIAMOND_BLOCK);
                    McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, player.getLocation().getBlockY() - 1, z), BlockVR.DIAMOND_BLOCK);
                    player.sendBlockChange(new Location(player.getWorld(), x, player.getLocation().getBlockY() + 4, z), BlockVR.DIAMOND_LIGHT);
                    McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, player.getLocation().getBlockY() + 4, z), BlockVR.DIAMOND_LIGHT);
                    for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + 4; y++) {
                        if (new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.AIR || new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.GRASS || new Location(player.getWorld(), x, y, z).getBlock().getType() == Material.TALL_GRASS) {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), Material.AIR.createBlockData());
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), Material.AIR.createBlockData());
                        } else {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), BlockVR.DIAMOND_WALL);
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), BlockVR.DIAMOND_WALL);
                        }

                    }
                    if (z == player.getLocation().getBlockZ() - 5 || z == player.getLocation().getBlockZ() + 4 || x == player.getLocation().getBlockX() - 5 || x == player.getLocation().getBlockX() + 4) {
                        for (int y = player.getLocation().getBlockY(); y < player.getLocation().getBlockY() + 4; y++) {
                            player.sendBlockChange(new Location(player.getWorld(), x, y, z), BlockVR.DIAMOND_WALL);
                            McVR.blocks_in_vr.get(player).put(new Location(player.getWorld(), x, y, z), BlockVR.DIAMOND_WALL);
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
