package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectUseOnCellMessage extends ObjectUseMessage implements INetworkMessage {

    private int protocolId = 3013;
    private boolean _isInitialized = false;
    private int cells = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_ObjectUseMessage(param1);
         if(this.cells < 0 || this.cells > 559)
         {
            throw new Exception("Forbidden value (" + this.cells + ") on element cells.");
         }
         param1.writeVarShort(this.cells);
    }

    public void deserialize(ICustomDataInput param1) {
         this.delayedCharacterId = param1.readDouble();
         if(this.delayedCharacterId < -9.007199254740992E15 || this.delayedCharacterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayedCharacterId + ") on element of GameRolePlayDelayedActionMessage.delayedCharacterId.");
         }
         this.delayTypeId = param1.readByte();
         if(this.delayTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.delayTypeId + ") on element of GameRolePlayDelayedActionMessage.delayTypeId.");
         }
         this.delayEndTime = param1.readDouble();
         if(this.delayEndTime < 0 || this.delayEndTime > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.delayEndTime + ") on element of GameRolePlayDelayedActionMessage.delayEndTime.");
         }
         this.objectGID = param1.readVarUhShort();
         if(this.objectGID < 0)
         {
            throw new Exception("Forbidden value (" + this.objectGID + ") on element of GameRolePlayDelayedObjectUseMessage.objectGID.");
         }
         this.cells = param1.readVarUhShort();
         if(this.cells < 0 || this.cells > 559)
         {
            throw new Exception("Forbidden value (" + this.cells + ") on element of ObjectUseOnCellMessage.cells.");
         }
    }

}