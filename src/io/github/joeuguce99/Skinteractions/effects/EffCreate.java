package io.github.joeuguce99.Skinteractions.effects;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World.Environment;
import org.bukkit.WorldType;
import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

@SuppressWarnings("serial")
public class EffCreate extends Effect {
	private Expression<String> wtype;
	private Expression<String> wname;
	private Expression<String> wseed;
	private Expression<String> wplugin;
	private byte method;
        
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
 		wname = (Expression<String>) exprs[0];
 		wtype = (Expression<String>) exprs[1];
 		if (matchedPattern == 0){
 			method = 0;
 		} else if(matchedPattern == 1){
 			wseed = (Expression<String>) exprs[2];
 			method = 1;
 		} else if(matchedPattern == 2){
 			wseed = (Expression<String>) exprs[2];
 			wplugin = (Expression<String>) exprs[3];
 			method = 2;
 		} else if(matchedPattern == 3){
 			wplugin = (Expression<String>) exprs[2];
 			method = 3;
 		}
		return true;
	}
	
	@Override
	public String toString(Event e, boolean debug) {
		return "generate a " + wtype.toString(e, debug) + "world named " + wname.toString(e, debug) + "with " + (method == 1||method == 2 ? "seed " +
		wseed.toString(e, debug) : "a random seed ") + "and " + (method == 2||method == 3 ? "generator " + wplugin.toString(e, debug) : "default generator");
	}

	@Override
	protected void execute(Event e) {
		final String n = wname.getSingle(e);
		final String t = wtype.getSingle(e);
		final String s = wseed == null ? null : wseed.getSingle(e);
		final String g = wseed == null ? null : wplugin.getSingle(e);
		
		Random y = new Random();
		final long x = y.nextLong();
		
		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		
		if (method == 0){			
			if (t == "normal" || t == "default" || t == "overworld"){
				m.addWorld(n, Environment.NORMAL, String.valueOf(x), WorldType.NORMAL, true, null);
			} else if(t == "nether" || t == "hell"){
				m.addWorld(n, Environment.NETHER, String.valueOf(x), WorldType.NORMAL, true, null);
			} else if(t == "end" || t == "the end" || t == "sky"){
				m.addWorld(n, Environment.THE_END, String.valueOf(x), WorldType.NORMAL, true, null);
			} else if(t == "flat" ||t == "flatland" ||t == "flat land" ||t == "flat world" ||t == "flatworld"){
				m.addWorld(n, Environment.NORMAL, String.valueOf(x), WorldType.FLAT, true, null);
			} else if(t == "amplified"|| t == "tall"){
				m.addWorld(n, Environment.NORMAL, String.valueOf(x), WorldType.AMPLIFIED, true, null);
			} else if(t == "large biomes" || t == "largebiomes"){
				m.addWorld(n, Environment.NORMAL, String.valueOf(x), WorldType.FLAT, true, null);
			}
		} else if(method == 1) {
			if (t == "normal" || t == "default" || t == "overworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.NORMAL, true, null);
			} else if(t == "nether" || t == "hell"){
				m.addWorld(n, Environment.NETHER, s, WorldType.NORMAL, true, null);
			} else if(t == "end" || t == "the end" || t == "sky"){
				m.addWorld(n, Environment.THE_END, s, WorldType.NORMAL, true, null);
			} else if(t == "flat" ||t == "flatland" ||t == "flat land" ||t == "flat world" ||t == "flatworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, null);
			} else if(t == "amplified" || t == "tall"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.AMPLIFIED, true, null);
			} else if(t == "large biomes" || t == "largebiomes"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, null);
		} else if(method == 2) {		
			if (t == "normal" || t == "default" || t == "overworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.NORMAL, true, g);
			} else if(t == "nether" || t == "hell"){
				m.addWorld(n, Environment.NETHER, s, WorldType.NORMAL, true, g);
			} else if(t == "end" || t == "the end" || t == "sky"){
				m.addWorld(n, Environment.THE_END, s, WorldType.NORMAL, true, g);
			} else if(t == "flat" ||t == "flatland" ||t == "flat land" ||t == "flat world" ||t == "flatworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, g);
			} else if(t == "amplified" || t == "tall"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.AMPLIFIED, true, g);
			} else if(t == "large biomes" || t == "largebiomes"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, g);
		} else if(method == 3) {		
			if (t == "normal" || t == "default" || t == "overworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.NORMAL, true, g);
			} else if(t == "nether" || t == "hell"){
				m.addWorld(n, Environment.NETHER, s, WorldType.NORMAL, true, g);
			} else if(t == "end" || t == "the end" || t == "sky"){
				m.addWorld(n, Environment.THE_END, s, WorldType.NORMAL, true, g);
			} else if(t == "flat" ||t == "flatland" ||t == "flat land" ||t == "flat world" ||t == "flatworld"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, g);
			} else if(t == "amplified" || t == "tall"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.AMPLIFIED, true, g);
			} else if(t == "large biomes" || t == "largebiomes"){
				m.addWorld(n, Environment.NORMAL, s, WorldType.FLAT, true, g);
			}
		}
		}
		}
	}
}