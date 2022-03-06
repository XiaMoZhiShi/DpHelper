package xiamo.dphelper;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import xiamo.dphelper.listeners.PluginEventListener;

public final class Dphelper extends JavaPlugin {

    public static Dphelper GetInstance()
    {
        return instance;
    }

    private static Dphelper instance;

    public VoidSender VoidSender;

    public Dphelper()
    {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        if (VoidSender == null)
            VoidSender = new VoidSender();

        Bukkit.getPluginManager().registerEvents(new PluginEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
