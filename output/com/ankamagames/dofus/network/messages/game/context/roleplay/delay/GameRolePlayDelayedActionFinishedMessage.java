package com.ankamagames.dofus.network.messages.game.context.roleplay.delay;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class GameRolePlayDelayedActionFinishedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6150;
    private boolean _isInitialized = false;
    private Number delayedCharacterId = 0;
    private int delayTypeId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element delayedCharacterId.");
         }
         param1.writeDouble(this.delayedCharacterId);
         param1.writeByte(this.delayTypeId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.delayedCharacterId = param1.readDouble();
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element of GameRolePlayDelayedActionFinishedMessage.delayedCharacterId.");
         }
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of GameRolePlayDelayedActionFinishedMessage.delayTypeId.");
         }
    }

}