//Nombre del paquete
package com.ramide1.mcnohit;

//Importar Librerias
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

//Clase publica App extiende plugin de java
public class App extends JavaPlugin {
    // Declarar variables
    String pluginName = "Minecraft NO HIT";
    File data;
    FileConfiguration dataConfig;
    File config;

    // Cuando se activa el plugin
    public void onEnable() {
        // Registrar archivo de datos
        data = new File(getDataFolder(), "data.yml");
        // Cargar configuracion de datos
        dataConfig = YamlConfiguration.loadConfiguration(data);
        // Tratar de
        try {
            // Guardar los datos
            dataConfig.save(data);
            // En el caso de que no se pueda
        } catch (Exception exeption) {
            // Imprimir el error
            exeption.printStackTrace();
            // Mensaje de error
            getLogger().info(ChatColor.RED + "Ocurrio un error al crear el archivo de los datos");
        }
        // Registrar archivo de configuracion
        config = new File(getDataFolder(), "config.yml");
        // Si no existe el archivo de configuracion
        if (!config.exists()) {
            // Guardar configuracion por defecto
            saveDefaultConfig();
        }
        // Registrar Evento Onhit
        getServer().getPluginManager().registerEvents(new Onhit(this), this);
        // Registrar Evento Onkill
        getServer().getPluginManager().registerEvents(new Onkill(this), this);
        // Registrar Comando Deathcount
        getCommand("deathcount").setExecutor(new Deathcount(this));
        // Registrar Comando Reload
        getCommand("nohitreload").setExecutor(new Reload(this));
        // Registrar Comando Reset
        getCommand("deathcountreset").setExecutor(new Reset(this));
        // Mensaje de activacion
        getLogger().info(ChatColor.GREEN + "Se ha activado el plugin " + pluginName + " correctamente!");
    }

    // Cuando se desactiva el plugin
    public void onDisable() {
        // Mensaje de desactivacion
        getLogger().info(ChatColor.GREEN + "Se ha desactivado el plugin " + pluginName + " correctamente!");
    }
}