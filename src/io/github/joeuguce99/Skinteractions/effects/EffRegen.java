package io.github.joeuguce99.Skinteractions.effects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

@SuppressWarnings("serial")
public class EffRegen extends Effect {
	private Expression<World> world;
	private Expression<String> seed;
	private byte method;
        
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
 		world = (Expression<World>) exprs[0];
 		if (matchedPattern == 0){
 			method = 0;
 		} else if(matchedPattern == 1){
 			seed = (Expression<String>) exprs[1];
 			method = 1;
 		} else if(matchedPattern == 2){
 			method = 2;
 		}
		return true;
	}
	
	@Override
	public String toString(Event e, boolean debug) {
		return "regenerate " + world.toString(e, debug) + "with" + (method != 0 ? (method != 2 ? "seed " + seed.toString(e, debug) : "a random seed") : "the same seed");
	}

	@Override
	protected void execute(Event e) {
		final World w = world.getSingle(e);
		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		if (method == 0){
			m.regenWorld(w.getName(), false, false, "");
		} else if(method == 1) {
			final String s = seed.getSingle(e);
			m.regenWorld(w.getName(), true, false, s);
		} else {
			m.regenWorld(w.getName(), true, true, "");
		}
			
	}

}
