package me.totalfreedom.bungee;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import me.totalfreedom.bungee.services.Config;
import me.totalfreedom.bungee.services.MOTD;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Bungee extends Plugin
{

    private static Bungee plugin;
    public final Logger logger = getLogger();

    public ServiceHandler sh;
    public Config config;
    public MOTD md;

    @Override
    public void onLoad()
    {
        plugin = this;
    }

    @Override
    public void onEnable()
    {
        sh = new ServiceHandler();
        config = new Config();
        md = new MOTD();

        for (Service service : sh.getServices())
        {
            service.onStart();
        }
    }

    @Override
    public void onDisable()
    {
        for (Service service : sh.getServices())
        {
            service.onStop();
        }
    }

    public static Bungee plugin()
    {
        for (Plugin plugin : plugin.getProxy().getPluginManager().getPlugins())
        {
            if (plugin.getDescription().getName().equals("TF-Bungee"))
            {
                return (Bungee)plugin;
            }
        }
        return null;
    }
}
