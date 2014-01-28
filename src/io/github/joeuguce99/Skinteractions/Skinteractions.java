package io.github.joeuguce99.Skinteractions;

import io.github.joeuguce99.Skinteractions.effects.EffClone;
import io.github.joeuguce99.Skinteractions.effects.EffCreate;
import io.github.joeuguce99.Skinteractions.effects.EffDel;
import io.github.joeuguce99.Skinteractions.effects.EffRegen;
import io.github.joeuguce99.Skinteractions.expressions.ExprMVSpawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;

/**
 * <b><i>Skinteractions</i></b> - An addon for <a href="https://www.github.com/Njol/Skript">Skript</a href> that provides more effects, conditions, expressions, and effects which other plugins provide in their API. 
 *
 * @author joeuguce99
 */
public class Skinteractions extends JavaPlugin{	
    @Override
    public void onEnable(){
    	if (Bukkit.getPluginManager().getPlugin("Multiverse-Core") != null) {
    		
    		Skript.registerEffect(EffRegen.class,
    				"re[-]gen[erate][ world] %world% [with[ the] (same|current) seed]",
    				"re[-]gen[erate][ world] %world% with seed %text%",
    				"re[-]gen[erate][ world] %world% with[ a] random seed");
    		
    		Skript.registerEffect(EffCreate.class,
    				"(gen[erate]|create|make)[ a] %text% world (with name|named|called) %text%[ with[ a] random seed]",
    				"(gen[erate]|create|make)[ a] %text% world (with name|named|called) %text% with seed %text%",
    				"(gen[erate]|create|make)[ a] %text% world (with name|named|called) %text% with seed %text% and gen[erator] %text%",
    				"(gen[erate]|create|make)[ a] %text% world (with name|named|called) %text% (with[ a] random seed and|with) gen[erator] %text%");

    		Skript.registerEffect(EffDel.class,
    				"(delete|remove) world %world%");
    		
    		Skript.registerEffect(EffClone.class,
    				"(clone|copy|duplicate) world %world% to[ world] %text%");
    		
    		Skript.registerExpression(ExprMVSpawn.class, Location.class, ExpressionType.PROPERTY,
    				"(mv|multiverse|plugin) spawn of[ world] %world%");
    		
    		Skript.info("Successfully added Skinteractions Multiverse Hook.");
    	} else {
    		Skript.warning("Couldn't find a valid Multiverse Core plugin, won't load Skinteractions hook for it.");
    	}
    }
}
