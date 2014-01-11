package io.github.joeuguce99.Skinteractions;

import io.github.joeuguce99.Skinteractions.effects.EffRegen;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;

/**
 * <b><i>Skinteractions</i></b> - An addon for <a href="https://www.github.com/Njol/Skript">Skript</a href> that provides more effects, conditions, expressions, and effects which other plugins provide in their API. 
 *
 * @author joeuguce99
 */
public class Skinteractions extends JavaPlugin{	
    @Override
    public void onEnable(){
    	if (Bukkit.getPluginManager().getPlugin("Multiverse-Core") != null) {
    		Skript.registerEffect(EffRegen.class, "regen[erate] %world% [with [the ](same|current) seed]", "regen[erate] %world% with seed %string%", "regen[erate] %world% with [a ]random seed");
    	}
    }
}
