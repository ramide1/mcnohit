//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.configuration.file.FileConfiguration;

//Clase publica Onhit implementa un Listener
public class Onhit implements Listener {
    // Clase principal
    private App plugin;

    public Onhit(App plugin) {
        this.plugin = plugin;
    }

    // Funcion onhit con el evento EntityDamage
    @EventHandler
    public void onhit(EntityDamageEvent event) {
        // Variables
        FileConfiguration config = plugin.getConfig();
        int killDamage = config.getInt("Config.kill-damage");
        // Si el tipo de entidad es un jugador
        if (event.getEntityType() == EntityType.PLAYER) {
            // Establecer daño
            event.setDamage(killDamage);
        }
    }
}