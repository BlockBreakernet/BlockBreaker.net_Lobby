package net.blockbreaker.lobby.system.methods.items.navigator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukas on 10.04.2015.
 */
public class NavigatorItem implements Listener {

    public static void loadNavigatorInv(Player p) {

        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.YELLOW + "Wähle deinen Spielmodus");

        //=====================================================

        ItemStack SG = new ItemStack(Material.IRON_SWORD);
        ItemMeta SGmeta = SG.getItemMeta();
        SGmeta.setDisplayName(ChatColor.GREEN + "SurvivalGames");
        List<String> sglore = new ArrayList<String>();
        sglore.add(ChatColor.AQUA + "Zu den SurvivalGames Servern");
        SGmeta.setLore(sglore);
        SG.setItemMeta(SGmeta);

        //=====================================================

        ItemStack tf = new ItemStack(Material.GOLD_HELMET);
        ItemMeta tfmeta = tf.getItemMeta();
        tfmeta.setDisplayName(ChatColor.DARK_GREEN + "Team-Force");
        List<String> tflore = new ArrayList<String>();
        tflore.add(ChatColor.AQUA + "Zu den TeamForce Servern");
        tfmeta.setLore(tflore);
        tf.setItemMeta(tfmeta);

        //=====================================================

        ItemStack rpg = new ItemStack(Material.MAP);
        ItemMeta rpgmeta = rpg.getItemMeta();
        rpgmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        rpgmeta.setDisplayName(ChatColor.RED + "RPG");
        List<String> rpglore = new ArrayList<String>();
        rpglore.add(ChatColor.AQUA + "Zum RPG Server");
        rpgmeta.setLore(rpglore);
        rpg.setItemMeta(rpgmeta);

        //=====================================================

        ItemStack paintball = new ItemStack(Material.SNOW_BALL);
        ItemMeta paintballmeta = paintball.getItemMeta();
        paintballmeta.setDisplayName(ChatColor.DARK_PURPLE + "Paintball");
        paintballmeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        paintballmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> pblore = new ArrayList<String>();
        pblore.add(ChatColor.AQUA + "Zu den PaintBall Servern");
        paintballmeta.setLore(pblore);
        paintball.setItemMeta(paintballmeta);

        //=====================================================

        ItemStack bedwars = new ItemStack(Material.CAKE);
        ItemMeta bedwarsmeta = bedwars.getItemMeta();
        bedwarsmeta.setDisplayName(ChatColor.YELLOW + "SafeTheCake");
        List<String> bwlore = new ArrayList<String>();
        bwlore.add(ChatColor.AQUA + "Zu den SafeTheCake Servern");
        bedwarsmeta.setLore(bwlore);
        bedwars.setItemMeta(bedwarsmeta);

        //=====================================================

        ItemStack skywars = new ItemStack(Material.SNOW_BLOCK);
        ItemMeta skywarsmeta = skywars.getItemMeta();
        skywarsmeta.setDisplayName(ChatColor.AQUA + "SkyWars");
        List<String> swlore = new ArrayList<String>();
        swlore.add(ChatColor.AQUA + "Zu den SkyWars Servern");
        skywarsmeta.setLore(swlore);
        skywars.setItemMeta(skywarsmeta);

        //=====================================================

        ItemStack spawn = new ItemStack(Material.EMERALD);
        ItemMeta spawnmeta = spawn.getItemMeta();
        spawnmeta.setDisplayName(ChatColor.DARK_GREEN + "Spawn");
        List<String> spawnlore = new ArrayList<String>();
        spawnlore.add(ChatColor.AQUA + "Zum Spawn");
        spawnmeta.setLore(spawnlore);
        spawn.setItemMeta(spawnmeta);

        //=====================================================

        ItemStack newbie = new ItemStack(Material.SPONGE);
        ItemMeta newbiemeta = newbie.getItemMeta();
        newbiemeta.setDisplayName(ChatColor.DARK_AQUA + "Newbie-Spawn");
        List<String> newbielore = new ArrayList<String>();
        newbielore.add(ChatColor.AQUA + "Zum Newbiespawn");
        newbiemeta.setLore(newbielore);
        newbie.setItemMeta(newbiemeta);

        //=====================================================

        ItemStack PREMIUM = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
        ItemMeta PREMIUMmeta = PREMIUM.getItemMeta();
        PREMIUMmeta.setDisplayName(ChatColor.GOLD + "Premium Bereich");
        List<String> premlore = new ArrayList<String>();
        premlore.add(ChatColor.AQUA + "Zum Premium Bereich");
        PREMIUMmeta.setLore(premlore);
        PREMIUM.setItemMeta(PREMIUMmeta);

        //=====================================================

        ItemStack comimgsoon = new ItemStack(Material.BOOK_AND_QUILL);
        ItemMeta comimgsoonmeta = comimgsoon.getItemMeta();
        comimgsoonmeta.setDisplayName(ChatColor.WHITE + "Coming Soon");
        comimgsoon.setItemMeta(comimgsoonmeta);

        //=====================================================

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte)15);
        ItemMeta glassmeta = glass.getItemMeta();
        glassmeta.setDisplayName(" ");
        glass.setItemMeta(glassmeta);

        //=====================================================

        inv.setItem(0, glass);
        inv.setItem(1, glass);
        inv.setItem(2, glass);
        inv.setItem(3, glass);
        inv.setItem(4, glass);
        inv.setItem(5, glass);
        inv.setItem(6, glass);
        inv.setItem(7, glass);
        inv.setItem(8, glass);
        inv.setItem(9, glass);
        inv.setItem(10, glass);
        inv.setItem(11, glass);
        inv.setItem(12, glass);
        inv.setItem(13, glass);
        inv.setItem(14, glass);
        inv.setItem(15, glass);
        inv.setItem(16, glass);
        inv.setItem(17, glass);
        inv.setItem(18, glass);
        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(24, glass);
        inv.setItem(25, glass);
        inv.setItem(26, glass);

        inv.setItem(3, newbie);
        inv.setItem(4, spawn);
        inv.setItem(5, PREMIUM);
        inv.setItem(9, comimgsoon);
        inv.setItem(10, tf);
        inv.setItem(11, SG);
        inv.setItem(15, bedwars);
        inv.setItem(16, paintball);
        inv.setItem(17, skywars);
        inv.setItem(22, rpg);

        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1.0F, 1.0F);
    }
}
