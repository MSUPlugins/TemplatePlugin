package vip.floatationdevice.msu.templateplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import static vip.floatationdevice.msu.templateplugin.TemplatePlugin.log;

public class TemplateEventListener implements Listener //TODO
{
    @EventHandler(priority = EventPriority.NORMAL)
    public void onServerLoadEvent(ServerLoadEvent event)
    {
        log.info("Hello world!");
    }
}
