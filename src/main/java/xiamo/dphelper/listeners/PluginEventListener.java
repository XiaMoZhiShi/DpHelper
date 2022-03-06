package xiamo.dphelper.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import xiamo.dphelper.Dphelper;
import xiamo.dphelper.EventType;
import xiamo.dphelper.PluginObject;

import java.io.Console;

public class PluginEventListener extends PluginObject implements Listener {

    private final CommandSender bukkitSender = Bukkit.getConsoleSender();

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent ioe)
    {
        if (ioe.getInventory().getType() == InventoryType.ENDER_CHEST)
        {
            Bukkit.dispatchCommand(bukkitSender,
                    getExecuteCommandLine(ioe.getPlayer().getName(), EventType.EnderChestOpen));
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent ice)
    {
        if (ice.getInventory().getType() == InventoryType.ENDER_CHEST)
        {
            Bukkit.dispatchCommand(bukkitSender,
                    getExecuteCommandLine(ice.getPlayer().getName(), EventType.EnderChestClose));
        }
    }

    private String getExecuteCommandLine(String playerName, EventType eventType)
    {
        String targetfunction = "hub:external/";

        switch (eventType)
        {
            case EnderChestOpen:
                targetfunction += "on_enderchest_open";
                break;

            case EnderChestClose:
                targetfunction += "on_enderchest_close";
                break;

            case InventoryClick:
                targetfunction += "on_click";
                break;
        }

        return "execute as " + playerName + " at @s run function " + targetfunction;
    }
}
