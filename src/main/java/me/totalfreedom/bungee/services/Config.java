package me.totalfreedom.bungee.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import me.totalfreedom.bungee.Service;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config extends Service
{

    private Configuration config;

    @Override
    public void onStart()
    {
        loadConfig();
    }

    @Override
    public void onStop()
    {
    }

    public void loadConfig()
    {
        if (!plugin.getDataFolder().exists())
        {
            plugin.getDataFolder().mkdir();
        }

        File file = new File(plugin.getDataFolder(), "config.yml");


        if (!file.exists())
        {
            try (InputStream in = plugin.getResourceAsStream("config.yml"))
            {
                Files.copy(in, file.toPath());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), "config.yml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public String getString(String key)
    {
        return config.getString(key);
    }
}
