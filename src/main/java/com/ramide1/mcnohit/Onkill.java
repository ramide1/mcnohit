//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

//Clase publica Onkill implementa un Listener
public class Onkill implements Listener {
    // Clase principal
    private App plugin;

    public Onkill(App plugin) {
        this.plugin = plugin;
    }

    // Funcion onkill con el evento PlayerDeath
    @EventHandler
    public void onkill(PlayerDeathEvent event) {
        // Variable kills
        Integer kills = 0;
        // Configurar el archivo de datos
        File data = plugin.data;
        FileConfiguration dataConfig = plugin.dataConfig;
        // Si no existen los datos
        if (!dataConfig.contains(event.getEntity().getName())) {
            // Establece kills en 1
            kills = 1;
            // De lo contrario
        } else {
            // Asignar variable kills segun el archivo
            kills = dataConfig.getInt(event.getEntity().getName());
            // Sumar uno a kills
            kills += 1;
        }
        // Establece los datos en kills
        dataConfig.set(event.getEntity().getName(), kills);
        // Tratar de
        try {
            // Guardar los datos
            dataConfig.save(data);
            // En el caso de que no se pueda
        } catch (Exception e) {
            // Imprimir el error
            e.printStackTrace();
            // Mensaje de error
            plugin.getLogger().info(ChatColor.RED + "Ocurrio un error al guardar los datos");
        }
        // Establecer variable mensaje original
        String originalMessage = event.getDeathMessage();
        // Establecer variable mensaje añadido
        String addedMessage = ". Total: " + kills;
        // Establecer variable nuevo mensaje
        String newMessage = originalMessage + addedMessage;
        // Establecer el mensaje de kill a nuevo mensaje
        event.setDeathMessage(newMessage);
    }
}