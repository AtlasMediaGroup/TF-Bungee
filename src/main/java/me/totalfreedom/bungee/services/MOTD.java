package me.totalfreedom.bungee.services;

import me.totalfreedom.bungee.Service;
import me.totalfreedom.bungee.util.Util;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.event.EventHandler;

public class MOTD extends Service
{

    @Override
    public void onStart()
    {
    }

    @Override
    public void onStop()
    {
    }


    @EventHandler
    public void onProxyPing(ProxyPingEvent event)
    {
        ServerPing serverPing = event.getResponse();
        serverPing.setDescriptionComponent(getMOTD());
        event.setResponse(serverPing);

    }

    private TextComponent getMOTD()
    {
        String primaryServerName = plugin.config.getString("primary-server");
        ServerInfo primaryServerInfo = plugin.getProxy().getServers().get(primaryServerName);
        String motd = randomlyColorize(primaryServerInfo.getMotd().replace("\\n", "\n"));
        return new TextComponent(ChatColor.translateAlternateColorCodes('&', motd));
    }


    private String randomlyColorize(String input)
    {
        String output = "";
        for (String string : input.split(" "))
        {
            output += Util.randomChatColor() + string + " ";
        }
        return output;
    }
}
