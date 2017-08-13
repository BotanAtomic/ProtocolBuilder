package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameFightStartingMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 700;
    private boolean _isInitialized = false;
    private int fightType = 0;
    private Number attackerId = 0;
    private Number defenderId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.fightType);
         if(this.attackerId < -9.007199254740992E15 || this.attackerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.attackerId + ") on element attackerId.");
         }
         param1.writeDouble(this.attackerId);
         if(this.defenderId < -9.007199254740992E15 || this.defenderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.defenderId + ") on element defenderId.");
         }
         param1.writeDouble(this.defenderId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.fightType = param1.readByte();
         if(this.fightType < 0)
         {
            throw new Exception("Forbidden value (" + this.fightType + ") on element of GameFightStartingMessage.fightType.");
         }
         this.attackerId = param1.readDouble();
         if(this.attackerId < -9.007199254740992E15 || this.attackerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.attackerId + ") on element of GameFightStartingMessage.attackerId.");
         }
         this.defenderId = param1.readDouble();
         if(this.defenderId < -9.007199254740992E15 || this.defenderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.defenderId + ") on element of GameFightStartingMessage.defenderId.");
         }
    }

}