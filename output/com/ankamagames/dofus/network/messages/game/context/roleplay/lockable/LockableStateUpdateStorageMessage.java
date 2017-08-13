package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LockableStateUpdateStorageMessage extends LockableStateUpdateAbstractMessage implements INetworkMessage {

    private int protocolId = 5669;
    private boolean _isInitialized = false;
    private int mapId = 0;
    private int elementId = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeBoolean(this.locked);
         param1.writeInt(this.mapId);
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element elementId.");
         }
         param1.writeVarInt(this.elementId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.locked = param1.readBoolean();
         this.mapId = param1.readInt();
         this.elementId = param1.readVarUhInt();
         if(this.elementId < 0)
         {
            throw new Exception("Forbidden value (" + this.elementId + ") on element of LockableStateUpdateStorageMessage.elementId.");
         }
    }

}