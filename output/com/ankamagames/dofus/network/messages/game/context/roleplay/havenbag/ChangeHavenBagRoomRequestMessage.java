package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ChangeHavenBagRoomRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6638;
    private boolean _isInitialized = false;
    private int roomId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element roomId.");
         }
         param1.writeByte(this.roomId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.roomId = param1.readByte();
         if(this.roomId < 0)
         {
            throw new Exception("Forbidden value (" + this.roomId + ") on element of ChangeHavenBagRoomRequestMessage.roomId.");
         }
    }

}