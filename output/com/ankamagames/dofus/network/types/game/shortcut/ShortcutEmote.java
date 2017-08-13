package package com.ankamagames.dofus.network.types.game.shortcut;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutEmote extends Shortcut implements INetworkType {

    private int protocolId = 389;
    private int emoteId = 0;


    public int getTypeId() {
         return 389;
    }

    public ShortcutEmote initShortcutEmote(int param1,int  param2) {
         super.initShortcut(param1);
         this.emoteId = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.emoteId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutEmote(param1);
    }

    public void serializeAs_ShortcutEmote(ICustomDataOutput param1) {
         super.serializeAs_Shortcut(param1);
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element emoteId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutEmote(param1);
    }

    public void deserializeAs_ShortcutEmote(ICustomDataInput param1) {
         super.deserialize(param1);
         this._emoteIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutEmote(param1);
    }

    public void deserializeAsyncAs_ShortcutEmote(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._emoteIdFunc);
    }

    private void _emoteIdFunc(ICustomDataInput param1) {
         this.emoteId = param1.readUnsignedByte();
         if(this.emoteId < 0 || this.emoteId > 255)
            throw new Exception("Forbidden value (" + this.emoteId + ") on element of ShortcutEmote.emoteId.");
    }

}