package com.ankamagames.dofus.network.messages.game.context.roleplay.objects;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class ObjectGroundRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 3014;
    private boolean _isInitialized = false;
    private int cell = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.cell < 0 || this.cell > 559)
         {
            throw new Exception("Forbidden value (" + this.cell + ") on element cell.");
         }
         param1.writeVarShort(this.cell);
    }

    public void deserialize(ICustomDataInput param1) {
         this.cell = param1.readVarUhShort();
         if(this.cell < 0 || this.cell > 559)
         {
            throw new Exception("Forbidden value (" + this.cell + ") on element of ObjectGroundRemovedMessage.cell.");
         }
    }

}