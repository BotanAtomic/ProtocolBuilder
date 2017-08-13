package com.ankamagames.dofus.network.messages.game.actions.sequence;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SequenceStartMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 955;
    private boolean _isInitialized = false;
    private int sequenceType = 0;
    private Number authorId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 955;
    }

    public SequenceStartMessage initSequenceStartMessage(int param1,Number  param2) {
         this.sequenceType = param1;
         this.authorId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.sequenceType = 0;
         this.authorId = 0;
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
         this.serializeAs_SequenceStartMessage(param1);
    }

    public void serializeAs_SequenceStartMessage(ICustomDataOutput param1) {
         param1.writeByte(this.sequenceType);
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element authorId.");
         }
         param1.writeDouble(this.authorId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SequenceStartMessage(param1);
    }

    public void deserializeAs_SequenceStartMessage(ICustomDataInput param1) {
         this._sequenceTypeFunc(param1);
         this._authorIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SequenceStartMessage(param1);
    }

    public void deserializeAsyncAs_SequenceStartMessage(FuncTree param1) {
         param1.addChild(this._sequenceTypeFunc);
         param1.addChild(this._authorIdFunc);
    }

    private void _sequenceTypeFunc(ICustomDataInput param1) {
         this.sequenceType = param1.readByte();
    }

    private void _authorIdFunc(ICustomDataInput param1) {
         this.authorId = param1.readDouble();
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.authorId + ") on element of SequenceStartMessage.authorId.");
         }
    }

}