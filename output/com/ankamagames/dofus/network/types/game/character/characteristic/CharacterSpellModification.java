package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterSpellModification extends Object implements INetworkType {

    private int protocolId = 215;
    private int modificationType = 0;
    private int spellId = 0;
    private CharacterBaseCharacteristic value;
    private FuncTree _valuetree;


    public void serialize(ICustomDataOutput param1) {
         param1.writeByte(this.modificationType);
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
         }
         param1.writeVarShort(this.spellId);
         this.value.serializeAs_CharacterBaseCharacteristic(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.modificationType = param1.readByte();
         if(this.modificationType < 0)
         {
            throw new Exception("Forbidden value (" + this.modificationType + ") on element of CharacterSpellModification.modificationType.");
         }
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
         {
            throw new Exception("Forbidden value (" + this.spellId + ") on element of CharacterSpellModification.spellId.");
         }
         this.value = new CharacterBaseCharacteristic();
         this.value.deserialize(param1);
    }

}