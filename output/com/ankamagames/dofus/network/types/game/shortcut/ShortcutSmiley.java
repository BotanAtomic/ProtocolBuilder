package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutSmiley extends Shortcut implements INetworkType {

    private int protocolId = 388;
    private int smileyId = 0;


    public int getTypeId() {
         return 388;
    }

    public ShortcutSmiley initShortcutSmiley(int param1,int  param2) {
         super.initShortcut(param1);
         this.smileyId = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.smileyId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutSmiley(param1);
    }

    public void serializeAs_ShortcutSmiley(ICustomDataOutput param1) {
         super.serializeAs_Shortcut(param1);
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element smileyId.");
         }
         param1.writeVarShort(this.smileyId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutSmiley(param1);
    }

    public void deserializeAs_ShortcutSmiley(ICustomDataInput param1) {
         super.deserialize(param1);
         this._smileyIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutSmiley(param1);
    }

    public void deserializeAsyncAs_ShortcutSmiley(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._smileyIdFunc);
    }

    private void _smileyIdFunc(ICustomDataInput param1) {
         this.smileyId = param1.readVarUhShort();
         if(this.smileyId < 0)
         {
            throw new Exception("Forbidden value (" + this.smileyId + ") on element of ShortcutSmiley.smileyId.");
         }
    }

}