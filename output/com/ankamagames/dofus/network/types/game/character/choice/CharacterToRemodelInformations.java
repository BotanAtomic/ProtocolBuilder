package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterToRemodelInformations extends CharacterRemodelingInformation implements INetworkType {

    private int protocolId = 477;
    private int possibleChangeMask = 0;
    private int mandatoryChangeMask = 0;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharacterRemodelingInformation(param1);
         if(this.possibleChangeMask < 0)
         {
            throw new Exception("Forbidden value (" + this.possibleChangeMask + ") on element possibleChangeMask.");
         }
         param1.writeByte(this.possibleChangeMask);
         if(this.mandatoryChangeMask < 0)
         {
            throw new Exception("Forbidden value (" + this.mandatoryChangeMask + ") on element mandatoryChangeMask.");
         }
         param1.writeByte(this.mandatoryChangeMask);
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = 0;
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
         }
         this.name = param1.readUTF();
         this.breed = param1.readByte();
         this.sex = param1.readBoolean();
         this.cosmeticId = param1.readVarUhShort();
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of CharacterRemodelingInformation.cosmeticId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.colors.push(_loc4_);
            _loc3_++;
         }
         this.possibleChangeMask = param1.readByte();
         if(this.possibleChangeMask < 0)
         {
            throw new Exception("Forbidden value (" + this.possibleChangeMask + ") on element of CharacterToRemodelInformations.possibleChangeMask.");
         }
         this.mandatoryChangeMask = param1.readByte();
         if(this.mandatoryChangeMask < 0)
         {
            throw new Exception("Forbidden value (" + this.mandatoryChangeMask + ") on element of CharacterToRemodelInformations.mandatoryChangeMask.");
         }
    }

}