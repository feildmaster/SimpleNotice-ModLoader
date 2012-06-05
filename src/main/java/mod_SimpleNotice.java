import net.minecraft.client.Minecraft;

public class mod_SimpleNotice extends BaseMod {
    private final String channel = "SimpleNotice";

    @Override
    public String getVersion() {
        return "SimpleNotice v1.2.5-1.0";
    }

    @Override
    public void load() {
        // Register channel
        ModLoader.registerPacketChannel(this, channel);
        // Listen to ticks
        ModLoader.setInGameHook(this, true, false);
    }

    @Override
    public boolean onTickInGame(float tick, Minecraft game) {
        // !!! This value needs to be updated every update
        //NoticeGui.getInstance(game).tick(!game.x);
        NoticeGui.getInstance(game).tick(true);
        return true;
    }

    @Override
    public void receiveCustomPacket(ee packet) {
        NoticeGui.getInstance().addNotice(new String(packet.c));
    }

    @Override
    public void serverDisconnect() {
        NoticeGui.getInstance().close();
    }


}
