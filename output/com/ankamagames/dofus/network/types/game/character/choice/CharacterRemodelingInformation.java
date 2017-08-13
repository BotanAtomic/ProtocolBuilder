package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.dofus.network.types.game.character.AbstractCharacterInformation;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterRemodelingInformation extends AbstractCharacterInformation implements INetworkType {

    private int protocolId = 479;
    private String name = "";
    private int breed = 0;
    private boolean sex = false;
    private int cosmeticId = 0;
    private int[] colors;
    private FuncTree _colorstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.id < 0 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeVarLong(this.id);
         param1.writeUTF(this.name);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
         }
         param1.writeVarShort(this.cosmeticId);
         param1.writeShort(this.colors.length);
         int _loc2_ = 0;
         while(_loc2_ < this.colors.length)
         {
            param1.writeInt(this.colors[_loc2_]);
            _loc2_++;
         }
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
    }

}