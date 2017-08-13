package package com.ankamagames.dofus.network.types.game.data.items;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SpellItem extends Item implements INetworkType {

    private int protocolId = 49;
    private int spellId = 0;
    private int spellLevel = 0;


    public int getTypeId() {
         return 49;
    }

    public SpellItem initSpellItem(int param1,int  param2) {
         this.spellId = param1;
         this.spellLevel = param2;
         return this;
    }

    public void reset() {
         this.spellId = 0;
         this.spellLevel = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_SpellItem(param1);
    }

    public void serializeAs_SpellItem(ICustomDataOutput param1) {
         super.serializeAs_Item(param1);
         param1.writeInt(this.spellId);
         if(this.spellLevel < 1 || this.spellLevel > 200)
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SpellItem(param1);
    }

    public void deserializeAs_SpellItem(ICustomDataInput param1) {
         super.deserialize(param1);
         this._spellIdFunc(param1);
         this._spellLevelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SpellItem(param1);
    }

    public void deserializeAsyncAs_SpellItem(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._spellIdFunc);
         param1.addChild(this._spellLevelFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readInt();
    }

    private void _spellLevelFunc(ICustomDataInput param1) {
         this.spellLevel = param1.readShort();
         if(this.spellLevel < 1 || this.spellLevel > 200)
            throw new Exception("Forbidden value (" + this.spellLevel + ") on element of SpellItem.spellLevel.");
    }

}