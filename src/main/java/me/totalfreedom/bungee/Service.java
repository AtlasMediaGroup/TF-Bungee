package me.totalfreedom.bungee;

import java.util.logging.Logger;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;

public abstract class Service implements Listener
{
    protected final Bungee plugin;
    protected final ProxyServer proxy;
    protected final Logger logger;

    public Service()
    {
        plugin = Bungee.plugin();
        proxy = plugin.getProxy();
        logger = plugin.getLogger();
        proxy.getPluginManager().registerListener(plugin, this);
        plugin.sh.add(this);
    }

    public abstract void onStart();
    public abstract void onStop();
}
