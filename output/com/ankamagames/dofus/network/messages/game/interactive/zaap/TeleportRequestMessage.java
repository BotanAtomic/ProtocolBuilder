package com.ankamagames.dofus.network.messages.game.interactive.zaap;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TeleportRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5961;
    private boolean _isInitialized = false;
    private int teleporterType = 0;
    private int mapId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.teleporterType);
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element mapId.");
         }
         param1.writeInt(this.mapId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.teleporterType = param1.readByte();
         if(this.teleporterType < 0)
         {
            throw new Exception("Forbidden value (" + this.teleporterType + ") on element of TeleportRequestMessage.teleporterType.");
         }
         this.mapId = param1.readInt();
         if(this.mapId < 0)
         {
            throw new Exception("Forbidden value (" + this.mapId + ") on element of TeleportRequestMessage.mapId.");
         }
    }

}