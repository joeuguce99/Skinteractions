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
public class EffClone extends Effect{
	Expression<World> world;
	Expression<String> name;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		world = (Expression<World>) exprs[0];
		name = (Expression<String>) exprs[1];
		return true;
	}

	@Override
	public String toString(Event e, boolean debug) {
		return "clone world " + world.toString() + " to " + name.toString();
	}

	@Override
	protected void execute(Event e) {
		final World w = world.getSingle(e);
		final String n = name.getSingle(e);

		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		
		m.cloneWorld(w.getName(), n, w.getGenerator().toString());
	}
	
}
