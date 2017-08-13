package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterSelectedForceMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6068;
    private boolean _isInitialized = false;
    private int id = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 1 || this.id > 2147483647)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeInt(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readInt();
         if(this.id < 1 || this.id > 2147483647)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterSelectedForceMessage.id.");
         }
    }

}