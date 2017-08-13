package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterBaseInformations extends CharacterMinimalPlusLookInformations implements INetworkType {

    private int protocolId = 45;
    private int breed = 0;
    private boolean sex = false;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalInformations(param1);
         this.entityLook.serializeAs_EntityLook(param1);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
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
    }

}