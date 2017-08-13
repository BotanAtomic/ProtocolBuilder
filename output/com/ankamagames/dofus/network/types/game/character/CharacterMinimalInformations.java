package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterMinimalInformations extends CharacterBasicMinimalInformations implements INetworkType {

    private int protocolId = 110;
    private int level = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterInformation(param1);
         param1.writeUTF(this.name);
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
         }
         this.name = param1.readUTF();
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of CharacterMinimalInformations.level.");
         }
    }

}