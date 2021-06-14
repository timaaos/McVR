package whybrawl.mcvr;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveVR implements CommandExecutor {

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if(args.length == 1){
                if(args[0].equals("helm")){
                    Player player = (Player) sender;
                    player.getInventory().addItem(VR_Helmet.getHelm());
                    return true;
                }else if(args[0].equals("game_void")){
                    Player player = (Player) sender;
                    player.getInventory().addItem(VR_Helmet.getGame("void"));
                    return true;
                }else if(args[0].equals("game_diamond")){
                    Player player = (Player) sender;
                    player.getInventory().addItem(VR_Helmet.getGame("diamond"));
                    return true;
                }
                return false;
            }else{
                return false;
            }
        }
        return false;
    }
}
