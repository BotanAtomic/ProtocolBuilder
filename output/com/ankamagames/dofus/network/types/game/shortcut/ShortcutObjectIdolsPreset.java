package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutObjectIdolsPreset extends ShortcutObject implements INetworkType {

    private int protocolId = 492;
    private int presetId = 0;


    public int getTypeId() {
         return 492;
    }

    public ShortcutObjectIdolsPreset initShortcutObjectIdolsPreset(int param1,int  param2) {
         super.initShortcutObject(param1);
         this.presetId = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.presetId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutObjectIdolsPreset(param1);
    }

    public void serializeAs_ShortcutObjectIdolsPreset(ICustomDataOutput param1) {
         super.serializeAs_ShortcutObject(param1);
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutObjectIdolsPreset(param1);
    }

    public void deserializeAs_ShortcutObjectIdolsPreset(ICustomDataInput param1) {
         super.deserialize(param1);
         this._presetIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutObjectIdolsPreset(param1);
    }

    public void deserializeAsyncAs_ShortcutObjectIdolsPreset(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._presetIdFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of ShortcutObjectIdolsPreset.presetId.");
         }
    }

}