package com.ankamagames.dofus.network.messages.game.character.creation;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.enums.PlayableBreedEnum;
import java.lang.Exception;

public class CharacterCreationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 160;
    private boolean _isInitialized = false;
    private String name = "";
    private int breed = 0;
    private boolean sex = false;
    private int[] colors;
    private int cosmeticId = 0;
    private FuncTree _colorstree;
    private int _colorsindex = 0;


    public void serialize(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
         int _loc2_ = 0;
         while(_loc2_ < 5)
         {
            param1.writeInt(this.colors[_loc2_]);
            _loc2_++;
         }
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element cosmeticId.");
         }
         param1.writeVarShort(this.cosmeticId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.name = param1.readUTF();
         this.breed = param1.readByte();
         if(this.breed < PlayableBreedEnum.Feca || this.breed > PlayableBreedEnum.Ouginak)
         {
            throw new Exception("Forbidden value (" + this.breed + ") on element of CharacterCreationRequestMessage.breed.");
         }
         this.sex = param1.readBoolean();
         int _loc2_ = 0;
         while(_loc2_ < 5)
         {
            this.colors[_loc2_] = param1.readInt();
            _loc2_++;
         }
         this.cosmeticId = param1.readVarUhShort();
         if(this.cosmeticId < 0)
         {
            throw new Exception("Forbidden value (" + this.cosmeticId + ") on element of CharacterCreationRequestMessage.cosmeticId.");
         }
    }

}