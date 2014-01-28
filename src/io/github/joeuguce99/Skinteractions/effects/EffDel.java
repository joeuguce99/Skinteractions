package io.github.joeuguce99.Skinteractions.effects;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

@SuppressWarnings("serial")
public class EffDel extends Effect{
	Expression<World> world;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		world = (Expression<World>) exprs[0];
		return true;
	}

	@Override
	public String toString(Event e, boolean debug) {
		return "delete world " + world.toString();
	}

	@Override
	protected void execute(Event e) {
		final World w = world.getSingle(e);

		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		
		if(m.getSpawnWorld() != w){
			m.deleteWorld(w.getName());
		} else{
			Skript.error("Cannot delete spawn world");
		}
	}

}
