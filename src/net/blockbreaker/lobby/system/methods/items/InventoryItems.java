package net.blockbreaker.lobby.system.methods.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
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
        navigatormeta.setDisplayName("§6Navigator");

        ArrayList<String> navigatorlore = new ArrayList<>();
        navigatorlore.add("§3Auf zu den Spielen!");
        navigatormeta.setLore(navigatorlore);

        navigator.setItemMeta(navigatormeta);

        //====================================================

        ItemStack hider = new ItemStack(Material.BLAZE_ROD);
        ItemMeta hidermeta = hider.getItemMeta();
        hidermeta.setDisplayName("§cSpieler verstecken");

        ArrayList<String> hiderlore = new ArrayList<>();
        hiderlore.add("§6Verstecke die Spieler");
        hidermeta.setLore(hiderlore);

        hider.setItemMeta(hidermeta);

        //====================================================

        ItemStack schild = new ItemStack(Material.DIAMOND);
        ItemMeta schildmeta = schild.getItemMeta();
        schildmeta.setDisplayName("§5Schutzschild");

        ArrayList<String> schildlore = new ArrayList<>();
        schildlore.add("§4Schütze dich vor den nervenden Spielern");
        schildmeta.setLore(schildlore);

        schild.setItemMeta(schildmeta);

        //====================================================

        ItemStack nicker = new ItemStack(Material.NAME_TAG);
        ItemMeta nickermeta = nicker.getItemMeta();
        nickermeta.setDisplayName("§eAuto-Nicker");

        ArrayList<String> nickerlore = new ArrayList<>();
        nickerlore.add("§5Lass dich automatisch umbennen, damit du nicht erkannt wirst");
        nickermeta.setLore(nickerlore);

        nicker.setItemMeta(nickermeta);

        //====================================================

        ItemStack friends = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta friendsmeta = (SkullMeta) friends.getItemMeta();
        friendsmeta.setDisplayName("§6Freunde");

        friendsmeta.setOwner(p.getDisplayName());

        ArrayList<String> friendslore = new ArrayList<>();
        friendslore.add("§2Hast du Freunde? Dann findest du sie hier");
        friendsmeta.setLore(friendslore);

        friends.setItemMeta(friendsmeta);

        //====================================================



        //Setzt Normalo Items
        p.getInventory().setItem(0, navigator);
        p.getInventory().setItem(1, hider);
        p.getInventory().setItem(8, friends);

        //Setzt Schild Item
        if(p.hasPermission("server.schild")) {
            p.getInventory().setItem(2, schild);
        }

        //Setzt Nicker Item
        if(p.hasPermission("server.nicker")) {
            p.getInventory().setItem(4, nicker);
        }

        p.updateInventory();
    }
}
