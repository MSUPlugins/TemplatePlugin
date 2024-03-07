package vip.floatationdevice.msu.templateplugin;

import org.bukkit.plugin.java.JavaPlugin;
import vip.floatationdevice.msu.ConfigManager;
import vip.floatationdevice.msu.I18nManager;

import java.util.logging.Logger;

public final class TemplatePlugin extends JavaPlugin //TODO
{
    static TemplatePlugin instance;
    static Logger log;
    static ConfigManager cm;
    static I18nManager i18n;

    @Override
    public void onEnable() //TODO: plugin startup logic
    {
        // initialize static fields
        instance = this;
        log = getLogger();
        cm = new ConfigManager(this, 1).initialize();
        i18n = new I18nManager(this).setLanguage(cm.get(String.class, "language"));

        // register event listener and command
        getServer().getPluginManager().registerEvents(new TemplateEventListener(), this);
        getCommand("templatecommand").setExecutor(new TemplateCommandExecutor());

        log.info("TemplatePlugin loaded");
    }

    @Override
    public void onDisable() //TODO: plugin shutdown logic
    {
        log.info("TemplatePlugin is being disabled");
    }
}
