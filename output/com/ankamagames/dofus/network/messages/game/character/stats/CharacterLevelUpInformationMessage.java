package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterLevelUpInformationMessage extends CharacterLevelUpMessage implements INetworkMessage {

    private int protocolId = 6076;
    private boolean _isInitialized = false;
    private String name = "";
    private Number id = 0;


    public void serialize(ICustomDataOutput param1) {
         if(this.newLevel < 2 || this.newLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.newLevel + ") on element newLevel.");
         }
         param1.writeByte(this.newLevel);
         param1.writeUTF(this.name);
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterLevelUpMessage(param1);
         this.name = param1.readUTF();
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of CharacterLevelUpInformationMessage.id.");
         }
    }

}