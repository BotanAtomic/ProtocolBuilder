package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SequenceNumberMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6317;
    private boolean _isInitialized = false;
    private int number = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6317;
    }

    public SequenceNumberMessage initSequenceNumberMessage(int param1) {
         this.number = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.number = 0;
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
         this.serializeAs_SequenceNumberMessage(param1);
    }

    public void serializeAs_SequenceNumberMessage(ICustomDataOutput param1) {
         if(this.number < 0 || this.number > 65535)
         {
            throw new Exception("Forbidden value (" + this.number + ") on element number.");
         }
         param1.writeShort(this.number);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SequenceNumberMessage(param1);
    }

    public void deserializeAs_SequenceNumberMessage(ICustomDataInput param1) {
         this._numberFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SequenceNumberMessage(param1);
    }

    public void deserializeAsyncAs_SequenceNumberMessage(FuncTree param1) {
         param1.addChild(this._numberFunc);
    }

    private void _numberFunc(ICustomDataInput param1) {
         this.number = param1.readUnsignedShort();
         if(this.number < 0 || this.number > 65535)
         {
            throw new Exception("Forbidden value (" + this.number + ") on element of SequenceNumberMessage.number.");
         }
    }

}