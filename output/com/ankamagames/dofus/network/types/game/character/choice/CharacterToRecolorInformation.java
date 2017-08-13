package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterToRecolorInformation extends AbstractCharacterToRefurbishInformation implements INetworkType {

    private int protocolId = 212;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterToRefurbishInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         Object _loc4_ = 0;
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readInt();
            this.colors.push(_loc4_);
            _loc3_++;
         }
         this.cosmeticId = param1.readVarUhInt();
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of AbstractCharacterToRefurbishInformation.cosmeticId.");
         }
    }

}