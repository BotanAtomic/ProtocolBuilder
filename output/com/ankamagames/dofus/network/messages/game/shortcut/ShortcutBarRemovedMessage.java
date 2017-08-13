package com.ankamagames.dofus.network.messages.game.shortcut;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutBarRemovedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6224;
    private boolean _isInitialized = false;
    private int barType = 0;
    private int slot = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6224;
    }

    public ShortcutBarRemovedMessage initShortcutBarRemovedMessage(int param1,int  param2) {
         this.barType = param1;
         this.slot = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.barType = 0;
         this.slot = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_ShortcutBarRemovedMessage(param1);
    }

    public void serializeAs_ShortcutBarRemovedMessage(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         if(this.slot < 0 || this.slot > 99)
         {
            throw new Exception("Forbidden value (" + this.slot + ") on element slot.");
         }
         param1.writeByte(this.slot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutBarRemovedMessage(param1);
    }

    public void deserializeAs_ShortcutBarRemovedMessage(ICustomDataInput param1) {
         this._barTypeFunc(param1);
         this._slotFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutBarRemovedMessage(param1);
    }

    public void deserializeAsyncAs_ShortcutBarRemovedMessage(FuncTree param1) {
         param1.addChild(this._barTypeFunc);
         param1.addChild(this._slotFunc);
    }

    private void _barTypeFunc(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarRemovedMessage.barType.");
         }
    }

    private void _slotFunc(ICustomDataInput param1) {
         this.slot = param1.readByte();
         if(this.slot < 0 || this.slot > 99)
         {
            throw new Exception("Forbidden value (" + this.slot + ") on element of ShortcutBarRemovedMessage.slot.");
         }
    }

}