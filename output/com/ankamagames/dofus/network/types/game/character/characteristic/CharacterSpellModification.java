package package com.ankamagames.dofus.network.types.game.character.characteristic;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterSpellModification extends Object implements INetworkType {

    private int protocolId = 215;
    private int modificationType = 0;
    private int spellId = 0;
    private CharacterBaseCharacteristic value = ;
    private FuncTree _valuetree = ;


    public int getTypeId() {
         return 215;
    }

    public CharacterSpellModification initCharacterSpellModification(int param1,int  param2,CharacterBaseCharacteristic  param3) {
         this.modificationType = param1;
         this.spellId = param2;
         this.value = param3;
         return this;
    }

    public void reset() {
         this.modificationType = 0;
         this.spellId = 0;
         this.value = new CharacterBaseCharacteristic();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterSpellModification(param1);
    }

    public void serializeAs_CharacterSpellModification(ICustomDataOutput param1) {
         param1.writeByte(this.modificationType);
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterSpellModification(param1);
    }

    public void deserializeAs_CharacterSpellModification(ICustomDataInput param1) {
         this._modificationTypeFunc(param1);
         this._spellIdFunc(param1);
         this.value = new CharacterBaseCharacteristic();
         this.value.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterSpellModification(param1);
    }

    public void deserializeAsyncAs_CharacterSpellModification(FuncTree param1) {
         param1.addChild(this._modificationTypeFunc);
         param1.addChild(this._spellIdFunc);
         this._valuetree = param1.addChild(this._valuetreeFunc);
    }

    private void _modificationTypeFunc(ICustomDataInput param1) {
         this.modificationType = param1.readByte();
         if(this.modificationType < 0)
            throw new Exception("Forbidden value (" + this.modificationType + ") on element of CharacterSpellModification.modificationType.");
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of CharacterSpellModification.spellId.");
    }

    private void _valuetreeFunc(ICustomDataInput param1) {
         this.value = new CharacterBaseCharacteristic();
         this.value.deserializeAsync(this._valuetree);
    }

}