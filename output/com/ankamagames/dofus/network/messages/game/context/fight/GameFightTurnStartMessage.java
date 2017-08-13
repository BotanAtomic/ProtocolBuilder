package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightTurnStartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 714;
    private boolean _isInitialized = false;
    private Number id = 0;
    private int waitTime = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.waitTime < 0)
         {
            throw new Exception("Forbidden value (" + this.waitTime + ") on element waitTime.");
         }
         param1.writeVarInt(this.waitTime);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameFightTurnStartMessage.id.");
         }
         this.waitTime = param1.readVarUhInt();
         if(this.waitTime < 0)
         {
            throw new Exception("Forbidden value (" + this.waitTime + ") on element of GameFightTurnStartMessage.waitTime.");
         }
    }

}