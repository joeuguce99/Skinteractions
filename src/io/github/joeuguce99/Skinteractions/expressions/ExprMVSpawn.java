package io.github.joeuguce99.Skinteractions.expressions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.onarandombox.MultiverseCore.api.MVWorldManager;

import ch.njol.skript.classes.Converter;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ch.njol.util.coll.CollectionUtils;

@SuppressWarnings("serial")
public class ExprMVSpawn extends PropertyExpression<World, Location> {
	@Override
	public Class<? extends Location> getReturnType() {
		return Location.class;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		setExpr((Expression<? extends World>) exprs[0]);
		return true;
	}

	@Override
	public String toString(Event e, boolean debug) {
		return null;
	}

	@Override
	protected Location[] get(Event e, World[] source) {
		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		return get(source, new Converter<World, Location>() {
		public Location convert(final World w) {
				return m.getMVWorld(w).getSpawnLocation();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final ChangeMode mode) {
		if (mode == ChangeMode.SET)
			return CollectionUtils.array(Location.class);
		return null;
	}
	
	@Override
	public void change(final Event e, final Object[] delta, final ChangeMode mode) throws UnsupportedOperationException {
		assert mode == ChangeMode.SET;
		final MultiverseCore p = ((MultiverseCore) Bukkit.getPluginManager().getPlugin("Multiverse-Core"));
		final MVWorldManager m = p.getMVWorldManager();
		final Location s = (Location) delta[0];
		final World w = getExpr().getSingle(e);
		m.getMVWorld(w).setSpawnLocation(s);
	}

}
