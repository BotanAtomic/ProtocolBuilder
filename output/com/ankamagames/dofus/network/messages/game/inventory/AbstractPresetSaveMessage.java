package com.ankamagames.dofus.network.messages.game.inventory;

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

public class AbstractPresetSaveMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6736;
    private boolean _isInitialized = false;
    private int presetId = 0;
    private int symbolId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6736;
    }

    public AbstractPresetSaveMessage initAbstractPresetSaveMessage(int param1,int  param2) {
         this.presetId = param1;
         this.symbolId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.presetId = 0;
         this.symbolId = 0;
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
         this.serializeAs_AbstractPresetSaveMessage(param1);
    }

    public void serializeAs_AbstractPresetSaveMessage(ICustomDataOutput param1) {
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element presetId.");
         }
         param1.writeByte(this.presetId);
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element symbolId.");
         }
         param1.writeByte(this.symbolId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractPresetSaveMessage(param1);
    }

    public void deserializeAs_AbstractPresetSaveMessage(ICustomDataInput param1) {
         this._presetIdFunc(param1);
         this._symbolIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractPresetSaveMessage(param1);
    }

    public void deserializeAsyncAs_AbstractPresetSaveMessage(FuncTree param1) {
         param1.addChild(this._presetIdFunc);
         param1.addChild(this._symbolIdFunc);
    }

    private void _presetIdFunc(ICustomDataInput param1) {
         this.presetId = param1.readByte();
         if(this.presetId < 0)
         {
            throw new Exception("Forbidden value (" + this.presetId + ") on element of AbstractPresetSaveMessage.presetId.");
         }
    }

    private void _symbolIdFunc(ICustomDataInput param1) {
         this.symbolId = param1.readByte();
         if(this.symbolId < 0)
         {
            throw new Exception("Forbidden value (" + this.symbolId + ") on element of AbstractPresetSaveMessage.symbolId.");
         }
    }

}