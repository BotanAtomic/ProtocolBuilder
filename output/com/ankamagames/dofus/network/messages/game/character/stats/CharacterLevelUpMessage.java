package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterLevelUpMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5670;
    private boolean _isInitialized = false;
    private int newLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.newLevel < 2 || this.newLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
         }
         param1.writeByte(this.newLevel);
    }

    public void deserialize(ICustomDataInput param1) {
         this.newLevel = param1.readUnsignedByte();
         if(this.newLevel < 2 || this.newLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element of CharacterLevelUpMessage.newLevel.");
         }
    }

}