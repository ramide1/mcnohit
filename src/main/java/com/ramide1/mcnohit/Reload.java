//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

//Clase publica Reload implementa CommandExecutor
public class Reload implements CommandExecutor {
    // Clase principal
    private App plugin;

    public Reload(App plugin) {
        this.plugin = plugin;
    }

    // Booleano publico onCommand
    public boolean onCommand(CommandSender sender, Command nohitreload, String label, String[] args) {
        // Recargar configuracion
        plugin.reloadConfig();
        // Mostrar mensaje
        sender.sendMessage("Se ha recargado el plugin " + plugin.pluginName + " correctamente!");
        // Devolver comando
        return true;
    }
}