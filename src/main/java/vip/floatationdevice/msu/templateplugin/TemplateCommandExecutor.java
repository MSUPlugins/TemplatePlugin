package vip.floatationdevice.msu.templateplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static vip.floatationdevice.msu.templateplugin.TemplatePlugin.i18n;

public class TemplateCommandExecutor implements CommandExecutor //TODO
{
    private static final String USE_PERM = "templateplugin.use";
    private static final String ADMIN_PERM = "templateplugin.admin";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!(sender instanceof Player))
        {
            sender.sendMessage(i18n.translate("err-player-only"));
            return false;
        }

        Player p = (Player) sender;

        if(args.length == 0)
        {
            if(!p.hasPermission(USE_PERM))
            {
                sender.sendMessage(i18n.translate("err-permission-denied"));
                return true;
            }
            p.sendMessage("Hello world!");
        }
        else if(args.length == 1 && args[0].equalsIgnoreCase("admin"))
        {
            if(!p.hasPermission(ADMIN_PERM))
            {
                sender.sendMessage(i18n.translate("err-permission-denied"));
                return true;
            }
            p.sendMessage("Hello admin!");
        }
        else
        {
            p.sendMessage(i18n.translate("usage"));
        }

        return true;
    }
}
