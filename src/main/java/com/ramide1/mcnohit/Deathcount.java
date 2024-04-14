//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;

//Clase publica Deathcont implementa CommandExecutor
public class Deathcount implements CommandExecutor {
    // Clase principal
    private App plugin;

    public Deathcount(App plugin) {
        this.plugin = plugin;
    }

    // Booleano publico onCommand
    public boolean onCommand(CommandSender sender, Command deathcount, String label, String[] args) {
        // Variable kills
        Integer kills = 0;
        // Si es usado por un jugador
        if (sender instanceof Player) {
            // Variable player
            Player player = (Player) sender;
            // Configurar el archivo de datos
            FileConfiguration dataConfig = plugin.dataConfig;
            // Si se pasa un argumento
            if (args.length == 1) {
                // Si no existen los datos
                if (!dataConfig.contains(args[0])) {
                    // Enviar mensaje
                    player.sendMessage("No se ha encontrado un jugador con ese nombre");
                    // De lo contrario
                } else {
                    // Asignar variable kills segun el archivo
                    kills = dataConfig.getInt(args[0]);
                    // Enviar mensaje
                    player.sendMessage("El jugador " + args[0] + " tiene " + kills + " muertes");
                }
                // De lo contrario
            } else {
                // Asignar variable kills segun el archivo
                kills = dataConfig.getInt(sender.getName());
                // Enviar mensaje
                player.sendMessage("El jugador " + sender.getName() + " tiene " + kills + " muertes");
            }
            // De lo contrario
        } else {
            // Mensaje
            plugin.getLogger().info("Este comando solo puede ser usado por jugadores");
        }
        // Devolver comando
        return true;
    }
}