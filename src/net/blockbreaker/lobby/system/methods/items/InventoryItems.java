package net.blockbreaker.lobby.system.methods.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

/**
 * Created by Lukas on 10.04.2015.
 */
public class InventoryItems {

    public static void getInGameItems(Player p) {

        //====================================================

        ItemStack navigator = new ItemStack(Material.COMPASS);
        ItemMeta navigatormeta = navigator.getItemMeta();
        navigatormeta.setDisplayName(ChatColor.GOLD + "Navigator");

        ArrayList<String> navigatorlore = new ArrayList<>();
        navigatorlore.add(ChatColor.DARK_AQUA + "Auf zu den Spielen!");
        navigatormeta.setLore(navigatorlore);

        navigator.setItemMeta(navigatormeta);

        //====================================================

        ItemStack hider = new ItemStack(Material.BLAZE_ROD);
        ItemMeta hidermeta = hider.getItemMeta();
        hidermeta.setDisplayName(ChatColor.RED + "Spieler verstecken");

        ArrayList<String> hiderlore = new ArrayList<>();
        hiderlore.add(ChatColor.GOLD + "Verstecke die Spieler");
        hidermeta.setLore(hiderlore);

        hider.setItemMeta(hidermeta);

        //====================================================

        ItemStack schild = new ItemStack(Material.DIAMOND);
        ItemMeta schildmeta = schild.getItemMeta();
        schildmeta.setDisplayName(ChatColor.DARK_PURPLE + "Schutzschild");

        ArrayList<String> schildlore = new ArrayList<>();
        schildlore.add(ChatColor.DARK_RED + "Schütze dich vor den nervenden Spielern");
        schildmeta.setLore(schildlore);

        schild.setItemMeta(schildmeta);

        //====================================================

        ItemStack friends = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta friendsmeta = (SkullMeta) friends.getItemMeta();
        friendsmeta.setDisplayName(ChatColor.GOLD + "Freunde");

        friendsmeta.setOwner(p.getDisplayName());

        ArrayList<String> friendslore = new ArrayList<>();
        friendslore.add(ChatColor.GOLD + "Hast du Freunde? Dann findest du sie hier");
        friendsmeta.setLore(friendslore);

        friends.setItemMeta(friendsmeta);

        //====================================================

        ItemStack silent = new ItemStack(Material.FEATHER);
        ItemMeta silentmeta = silent.getItemMeta();
        silentmeta.setDisplayName(ChatColor.DARK_PURPLE + "Silent Lobby");

        ArrayList<String> silentlore = new ArrayList<>();
        friendslore.add(ChatColor.DARK_GREEN + "Hast du Freunde? Dann findest du sie hier");
        silentmeta.setLore(silentlore);

        silent.setItemMeta(silentmeta);

        //====================================================


        p.getInventory().setItem(0, friends);
        p.getInventory().setItem(4, navigator);
        p.getInventory().setItem(8, hider);

        if(p.hasPermission("server.silent.item")) {
            p.getInventory().setItem(1, silent);
        }

        if(p.hasPermission("server.player.protection")) {
            p.getInventory().setItem(7, schild);
        }



        p.updateInventory();
    }
}
