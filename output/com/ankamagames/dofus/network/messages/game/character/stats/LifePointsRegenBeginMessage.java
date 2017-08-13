package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LifePointsRegenBeginMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5684;
    private boolean _isInitialized = false;
    private int regenRate = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of LifePointsRegenBeginMessage.regenRate.");
         }
    }

}