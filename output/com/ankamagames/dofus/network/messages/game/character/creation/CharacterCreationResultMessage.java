package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterCreationResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 161;
    private boolean _isInitialized = false;
    private int result = 1;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.result);
    }

    public void deserialize(ICustomDataInput param1) {
         this.result = param1.readByte();
         if(this.result < 0)
         {
            throw new Exception("Forbidden value (" + this.result + ") on element of CharacterCreationResultMessage.result.");
         }
    }

}