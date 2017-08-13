package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class StartupActionsObjetAttributionMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1303;
    private boolean _isInitialized = false;
    private int actionId = 0;
    private Number characterId = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
         }
         param1.writeInt(this.actionId);
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element characterId.");
         }
         param1.writeVarLong(this.characterId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.actionId = param1.readInt();
         if(this.actionId < 0)
         {
            throw new Exception("Forbidden value (" + this.actionId + ") on element of StartupActionsObjetAttributionMessage.actionId.");
         }
         this.characterId = param1.readVarUhLong();
         if(this.characterId < 0 || this.characterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.characterId + ") on element of StartupActionsObjetAttributionMessage.characterId.");
         }
    }

}