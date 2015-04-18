package net.blockbreaker.lobby.api.holo;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.object.NamedHologram;
import net.blockbreaker.lobby.api.player.flyingitems.FlyingItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by Lukas on 13.04.2015.
 */
public class NewbieSpawnHolo {

    public static void setNewbieHolo1(Player p) {
        Hologram holo = new NamedHologram(p.getLocation(), "Tewst");
        holo.teleport(p.getLocation());

        FlyingItem flyi = new FlyingItem();
        flyi.setLocation(p.getLocation());
        flyi.setMaterial(Material.DIAMOND_SWORD);
        flyi.spawn();
    }
}
