package net.blockbreaker.lobby.system.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExpEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.block.NotePlayEvent;

/**
 * Created by Lukas on 12.04.2015.
 */
public class BlockEvents implements Listener {

    @EventHandler
    public void onDamage(BlockDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onNotePlay(NotePlayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockForm(EntityBlockFormEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onExp(BlockExpEvent e) {
        e.setExpToDrop(0);
    }
}
