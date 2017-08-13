package com.ankamagames.dofus.network.messages.game.inventory.preset;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IdolsPresetUseMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6615;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private boolean party = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6615;
    }

    public IdolsPresetUseMessage initIdolsPresetUseMessage(int param1,boolean  param2) {
         this.presetId = param1;
         this.party = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.party = false;
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
         this.serializeAs_IdolsPresetUseMessage(param1);
    }

    public void serializeAs_IdolsPresetUseMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         param1.writeBoolean(this.party);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdolsPresetUseMessage(param1);
    }

    public void deserializeAs_IdolsPresetUseMessage(ICustomDataInput param1) {
         this._presetIdFunc(param1);
         this._partyFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdolsPresetUseMessage(param1);
    }

    public void deserializeAsyncAs_IdolsPresetUseMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._partyFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of IdolsPresetUseMessage.presetId.");
         }
    }

    private void _partyFunc(ICustomDataInput param1) {
         this.party = param1.readBoolean();
    }

}