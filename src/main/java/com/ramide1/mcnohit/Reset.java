//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.command.Command;

//Clase publica Deathcont implementa CommandExecutor
public class Reset implements CommandExecutor {
    // Clase principal
    private App plugin;

    public Reset(App plugin) {
        this.plugin = plugin;
    }

    // Booleano publico onCommand
    public boolean onCommand(CommandSender sender, Command deathcountreset, String label, String[] args) {
        // Variable kills
        Integer kills = 0;
        // Configurar el archivo de datos
        FileConfiguration dataConfig = plugin.dataConfig;
        // Si se pasa un argumento
        if (args.length == 1) {
            // Si no existen los datos
            if (!dataConfig.contains(args[0])) {
                // Enviar mensaje
                sender.sendMessage("No se ha encontrado un jugador con ese nombre");
                // De lo contrario
            } else {
                // Establecer kills en el archivo
                dataConfig.set(args[0], kills);
                // Enviar mensaje
                sender.sendMessage("Se han reiniciado las kills de el jugador " + args[0] + " y ahora tiene " + kills);
            }
            // De lo contrario
        } else {
            // Enviar mensaje
            sender.sendMessage("Se debe especificar el nombre del jugador");
        }
        // Devolver comando
        return true;
    }
}