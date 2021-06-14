package whybrawl.mcvr;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class VR_Helmet {
    public static ItemStack getHelm(){
        ItemStack helmet = new ItemStack(Material.IRON_HELMET);
        ItemMeta meta = helmet.getItemMeta();
        meta.setDisplayName("Mineculus Quest");
        List<String> lore = new ArrayList<>();
        lore.add("VR Helmet by Mineculus.");
        lore.add("Play differently!");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        helmet.setItemMeta(meta);
        return helmet;
    }
    public static ItemStack getGame(String type){
        if(type.equals("void")) {
            ItemStack helmet = new ItemStack(Material.MUSIC_DISC_STAL);
            ItemMeta meta = helmet.getItemMeta();
            meta.setDisplayName("Void Simulator Game");
            List<String> lore = new ArrayList<>();
            lore.add("Cool game, very fun!");
            lore.add(" - Steve");
            meta.setLore(lore);
            meta.setUnbreakable(true);
            helmet.setItemMeta(meta);
            return helmet;
        }else if(type.equals("diamond")){
            ItemStack helmet = new ItemStack(Material.MUSIC_DISC_WAIT);
            ItemMeta meta = helmet.getItemMeta();
            meta.setDisplayName("Diamond Clicker Game");
            List<String> lore = new ArrayList<>();
            lore.add("I clicked 777 times on diamond!");
            lore.add(" - CoolGamer777");
            meta.setLore(lore);
            meta.setUnbreakable(true);
            helmet.setItemMeta(meta);
            return helmet;
        }
        return new ItemStack(Material.BRICK);
    }
}
