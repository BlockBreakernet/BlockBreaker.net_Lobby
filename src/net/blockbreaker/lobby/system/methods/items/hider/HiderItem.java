package net.blockbreaker.lobby.system.methods.items.hider;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Lukas on 11.04.2015.
 */
public class HiderItem {

    public static void openHideInv(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Spieler verstecken");

        //======================================================================

        ItemStack allon = new ItemStack(Material.WOOL, 1, (byte) 13);
        ItemMeta allonmeta = allon.getItemMeta();
        allonmeta.setDisplayName(ChatColor.GREEN + "Alle Spieler anzeigen");
        allon.setItemMeta(allonmeta);

        //======================================================================

        ItemStack vipon = new ItemStack(Material.WOOL, 1, (byte) 10);
        ItemMeta viponmeta = allon.getItemMeta();
        viponmeta.setDisplayName(ChatColor.DARK_PURPLE + "Nur Team-Mitglieder und Premium anzeigen");
        vipon.setItemMeta(viponmeta);

        //======================================================================

        ItemStack alloff = new ItemStack(Material.WOOL, 1, (byte) 14);
        ItemMeta alloffmeta = allon.getItemMeta();
        alloffmeta.setDisplayName(ChatColor.RED + "Alle Spieler ausblenden");
        alloff.setItemMeta(alloffmeta);

        //======================================================================

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
        ItemMeta glassmeta = allon.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);

        //======================================================================

        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);

        inv.setItem(0, allon);
        inv.setItem(4, vipon);
        inv.setItem(8, alloff);

        p.openInventory(inv);
        p.updateInventory();
    }
}
