package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterHardcoreOrEpicInformations extends CharacterBaseInformations implements INetworkType {

    private int protocolId = 474;
    private int deathState = 0;
    private int deathCount = 0;
    private int deathMaxLevel = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterBaseInformations(param1);
         param1.writeByte(this.deathState);
         if(this.deathCount < 0)
         {
            throw new Exception("Forbidden value (" + this.deathCount + ") on element deathCount.");
         }
         param1.writeVarShort(this.deathCount);
         if(this.deathMaxLevel < 1 || this.deathMaxLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.deathMaxLevel + ") on element deathMaxLevel.");
         }
         param1.writeByte(this.deathMaxLevel);
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
         this.entityLook = new EntityLook();
         this.entityLook.deserialize(param1);
         this.breed = param1.readByte();
         this.sex = param1.readBoolean();
         this.deathState = param1.readByte();
         if(this.deathState < 0)
         {
            throw new Exception("Forbidden value (" + this.deathState + ") on element of CharacterHardcoreOrEpicInformations.deathState.");
         }
         this.deathCount = param1.readVarUhShort();
         if(this.deathCount < 0)
         {
            throw new Exception("Forbidden value (" + this.deathCount + ") on element of CharacterHardcoreOrEpicInformations.deathCount.");
         }
         this.deathMaxLevel = param1.readUnsignedByte();
         if(this.deathMaxLevel < 1 || this.deathMaxLevel > 206)
         {
            throw new Exception("Forbidden value (" + this.deathMaxLevel + ") on element of CharacterHardcoreOrEpicInformations.deathMaxLevel.");
         }
    }

}