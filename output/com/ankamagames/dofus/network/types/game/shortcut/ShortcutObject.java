package package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ShortcutObject extends Shortcut implements INetworkType {

    private int protocolId = 367;


    public int getTypeId() {
         return 367;
    }

    public ShortcutObject initShortcutObject(int param1) {
         super.initShortcut(param1);
         return this;
    }

    public void reset() {
         super.reset();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutObject(param1);
    }

    public void serializeAs_ShortcutObject(ICustomDataOutput param1) {
         super.serializeAs_Shortcut(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutObject(param1);
    }

    public void deserializeAs_ShortcutObject(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutObject(param1);
    }

    public void deserializeAsyncAs_ShortcutObject(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}