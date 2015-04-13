package net.blockbreaker.lobby.api.holo;

import net.blockbreaker.lobby.api.player.Holograms;
import net.blockbreaker.lobby.api.player.flyingitems.FlyingItem;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 13.04.2015.
 */
public class NewbieSpawnHolo {

    public static void setNewbieHolo1(Player p) {
        String[] text = null;
        text[0] = "1";
        text[1] = "2";
        Location loc = p.getLocation();

        Holograms holo = new Holograms(text, loc);
        holo.showAll();

        FlyingItem flyi = new FlyingItem();
        flyi.setLocation(loc);
        flyi.setMaterial(Material.DIAMOND_SWORD);
        flyi.spawn();
    }
}
