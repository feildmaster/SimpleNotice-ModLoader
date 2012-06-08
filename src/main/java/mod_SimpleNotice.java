import net.minecraft.client.Minecraft;

public class mod_SimpleNotice extends BaseMod {
    private final String channel = "SimpleNotice";

    @Override
    public String getVersion() {
        return "v1.2.5-1.1";
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
        NoticeGui.getInstance(game).tick();
        return true;
    }

    @Override
    public void receiveCustomPacket(ee packet) {
        NoticeGui.get().addNotice(new String(packet.c));
    }

    @Override
    public void serverDisconnect() {
        NoticeGui.get().close();
    }


}
