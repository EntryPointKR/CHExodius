package me.macjuul.chexodius;

import com.laytonsmith.PureUtilities.SimpleVersion;
import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.extensions.AbstractExtension;
import com.laytonsmith.core.extensions.MSExtension;

import static me.macjuul.chexodius.events.EventListeners.register;
import static me.macjuul.chexodius.events.EventListeners.unregister;

@MSExtension("CHExodius")
public class LifeCycle
extends AbstractExtension {
    public static CommandHelperPlugin chp;

    public Version getVersion() {
        return new SimpleVersion(2, 3, 0);
    }

    public void onShutdown() {
        System.out.println("CHExodius " + getVersion() + " has sucessfully been disabled!");
        unregister();
    }

    public void onStartup() {
        System.out.println("CHExodius " + getVersion() + " has sucessfully been enabled!");
        chp = CommandHelperPlugin.self;
        register();
    }
}