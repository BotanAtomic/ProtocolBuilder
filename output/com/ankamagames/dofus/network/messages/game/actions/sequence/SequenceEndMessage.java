package package com.ankamagames.dofus.network.messages.game.actions.sequence;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class SequenceEndMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 956;
    private boolean _isInitialized = false;
    private int actionId = 0;
    private Number authorId = 0;
    private int sequenceType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 956;
    }

    public SequenceEndMessage initSequenceEndMessage(int param1,Number  param2,int  param3) {
         this.actionId = param1;
         this.authorId = param2;
         this.sequenceType = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.actionId = 0;
         this.authorId = 0;
         this.sequenceType = 0;
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
         this.serializeAs_SequenceEndMessage(param1);
    }

    public void serializeAs_SequenceEndMessage(ICustomDataOutput param1) {
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SequenceEndMessage(param1);
    }

    public void deserializeAs_SequenceEndMessage(ICustomDataInput param1) {
         this._actionIdFunc(param1);
         this._authorIdFunc(param1);
         this._sequenceTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SequenceEndMessage(param1);
    }

    public void deserializeAsyncAs_SequenceEndMessage(FuncTree param1) {
         param1.addChild(this._actionIdFunc);
         param1.addChild(this._authorIdFunc);
         param1.addChild(this._sequenceTypeFunc);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readVarUhShort();
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element of SequenceEndMessage.actionId.");
    }

    private void _authorIdFunc(ICustomDataInput param1) {
         this.authorId = param1.readDouble();
         if(this.authorId < -9.007199254740992E15 || this.authorId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.authorId + ") on element of SequenceEndMessage.authorId.");
    }

    private void _sequenceTypeFunc(ICustomDataInput param1) {
         this.sequenceType = param1.readByte();
    }

}