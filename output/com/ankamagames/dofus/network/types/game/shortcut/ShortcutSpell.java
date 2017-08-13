package package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutSpell extends Shortcut implements INetworkType {

    private int protocolId = 368;
    private int spellId = 0;


    public int getTypeId() {
         return 368;
    }

    public ShortcutSpell initShortcutSpell(int param1,int  param2) {
         super.initShortcut(param1);
         this.spellId = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.spellId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutSpell(param1);
    }

    public void serializeAs_ShortcutSpell(ICustomDataOutput param1) {
         super.serializeAs_Shortcut(param1);
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutSpell(param1);
    }

    public void deserializeAs_ShortcutSpell(ICustomDataInput param1) {
         super.deserialize(param1);
         this._spellIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutSpell(param1);
    }

    public void deserializeAsyncAs_ShortcutSpell(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._spellIdFunc);
    }

    private void _spellIdFunc(ICustomDataInput param1) {
         this.spellId = param1.readVarUhShort();
         if(this.spellId < 0)
            throw new Exception("Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

}