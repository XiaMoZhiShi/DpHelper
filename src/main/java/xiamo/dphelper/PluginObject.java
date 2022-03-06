package xiamo.dphelper;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Logger;

/**
 * 在这里存放一些会在所有插件对象中被经常调用的东西
 */
public abstract class PluginObject {
    protected Logger Logger;
    protected Dphelper Plugin;
    protected FileConfiguration Config;

    protected PluginObject()
    {
        Plugin = Dphelper.GetInstance();

        Logger = Plugin.getLogger();
        Config = Plugin.getConfig();
    }
}