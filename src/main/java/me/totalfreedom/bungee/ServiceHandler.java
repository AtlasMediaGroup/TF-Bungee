package me.totalfreedom.bungee;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class ServiceHandler
{
    @Getter
    private List<Service> services;

    public ServiceHandler()
    {
        this.services = new ArrayList<>();
    }

    public void add(Service service)
    {
        services.add(service);
    }

    public int getServiceCount()
    {
        return services.size();
    }
}