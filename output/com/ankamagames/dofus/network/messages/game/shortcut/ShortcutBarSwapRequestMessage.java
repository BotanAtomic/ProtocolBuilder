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
import java.lang.Exception;
import java.lang.Exception;

public class ShortcutBarSwapRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6230;
    private boolean _isInitialized = false;
    private int barType = 0;
    private int firstSlot = 0;
    private int secondSlot = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6230;
    }

    public ShortcutBarSwapRequestMessage initShortcutBarSwapRequestMessage(int param1,int  param2,int  param3) {
         this.barType = param1;
         this.firstSlot = param2;
         this.secondSlot = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.barType = 0;
         this.firstSlot = 0;
         this.secondSlot = 0;
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
         this.serializeAs_ShortcutBarSwapRequestMessage(param1);
    }

    public void serializeAs_ShortcutBarSwapRequestMessage(ICustomDataOutput param1) {
         param1.writeByte(this.barType);
         if(this.firstSlot < 0 || this.firstSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.firstSlot + ") on element firstSlot.");
         }
         param1.writeByte(this.firstSlot);
         if(this.secondSlot < 0 || this.secondSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.secondSlot + ") on element secondSlot.");
         }
         param1.writeByte(this.secondSlot);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ShortcutBarSwapRequestMessage(param1);
    }

    public void deserializeAs_ShortcutBarSwapRequestMessage(ICustomDataInput param1) {
         this._barTypeFunc(param1);
         this._firstSlotFunc(param1);
         this._secondSlotFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ShortcutBarSwapRequestMessage(param1);
    }

    public void deserializeAsyncAs_ShortcutBarSwapRequestMessage(FuncTree param1) {
         param1.addChild(this._barTypeFunc);
         param1.addChild(this._firstSlotFunc);
         param1.addChild(this._secondSlotFunc);
    }

    private void _barTypeFunc(ICustomDataInput param1) {
         this.barType = param1.readByte();
         if(this.barType < 0)
         {
            throw new Exception("Forbidden value (" + this.barType + ") on element of ShortcutBarSwapRequestMessage.barType.");
         }
    }

    private void _firstSlotFunc(ICustomDataInput param1) {
         this.firstSlot = param1.readByte();
         if(this.firstSlot < 0 || this.firstSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.firstSlot + ") on element of ShortcutBarSwapRequestMessage.firstSlot.");
         }
    }

    private void _secondSlotFunc(ICustomDataInput param1) {
         this.secondSlot = param1.readByte();
         if(this.secondSlot < 0 || this.secondSlot > 99)
         {
            throw new Exception("Forbidden value (" + this.secondSlot + ") on element of ShortcutBarSwapRequestMessage.secondSlot.");
         }
    }

}