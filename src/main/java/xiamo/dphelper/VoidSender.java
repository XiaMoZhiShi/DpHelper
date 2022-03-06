package xiamo.dphelper;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.UUID;

public class VoidSender extends PluginObject implements CommandSender {
    @Override
    public void sendMessage(@NotNull String message) {

    }

    @Override
    public void sendMessage(@NotNull String... messages) {

    }

    @Override
    public void sendMessage(@Nullable UUID sender, @NotNull String message) {

    }

    @Override
    public void sendMessage(@Nullable UUID sender, @NotNull String... messages) {

    }

    @NotNull
    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @NotNull
    @Override
    public String getName() {
        return "Void";
    }

    private Spigot spigot = new Spigot();

    @NotNull
    @Override
    public Spigot spigot() {
        return spigot;
    }

    @Override
    public boolean isPermissionSet(@NotNull String name) {
        return true;
    }

    @Override
    public boolean isPermissionSet(@NotNull Permission perm) {
        return true;
    }

    @Override
    public boolean hasPermission(@NotNull String name) {
        return true;
    }

    @Override
    public boolean hasPermission(@NotNull Permission perm) {
        return true;
    }

    private final PermissionAttachment permissionAttachment = new PermissionAttachment(Plugin, this);

    @NotNull
    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value) {
        return permissionAttachment.getPermissible().addAttachment(plugin, name, value);
    }

    @NotNull
    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin) {
        return permissionAttachment.getPermissible().addAttachment(plugin);
    }

    @Nullable
    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, @NotNull String name, boolean value, int ticks) {
        return permissionAttachment.getPermissible().addAttachment(plugin, name, value, ticks);
    }

    @Nullable
    @Override
    public PermissionAttachment addAttachment(@NotNull Plugin plugin, int ticks) {
        return permissionAttachment.getPermissible().addAttachment(plugin, ticks);
    }

    @Override
    public void removeAttachment(@NotNull PermissionAttachment attachment) {
        permissionAttachment.getPermissible().removeAttachment(attachment);
    }

    @Override
    public void recalculatePermissions() {
        permissionAttachment.getPermissible().recalculatePermissions();
    }

    @NotNull
    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return permissionAttachment.getPermissible().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean value) {

    }
}
