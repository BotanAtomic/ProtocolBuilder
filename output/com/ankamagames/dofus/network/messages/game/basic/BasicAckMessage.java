package com.ankamagames.dofus.network.messages.game.basic;

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

public class BasicAckMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6362;
    private boolean _isInitialized = false;
    private int seq = 0;
    private int lastPacketId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6362;
    }

    public BasicAckMessage initBasicAckMessage(int param1,int  param2) {
         this.seq = param1;
         this.lastPacketId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.seq = 0;
         this.lastPacketId = 0;
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
         this.serializeAs_BasicAckMessage(param1);
    }

    public void serializeAs_BasicAckMessage(ICustomDataOutput param1) {
         if(this.seq < 0)
         {
            throw new Exception("Forbidden value (" + this.seq + ") on element seq.");
         }
         param1.writeVarInt(this.seq);
         if(this.lastPacketId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastPacketId + ") on element lastPacketId.");
         }
         param1.writeVarShort(this.lastPacketId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicAckMessage(param1);
    }

    public void deserializeAs_BasicAckMessage(ICustomDataInput param1) {
         this._seqFunc(param1);
         this._lastPacketIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicAckMessage(param1);
    }

    public void deserializeAsyncAs_BasicAckMessage(FuncTree param1) {
         param1.addChild(this._seqFunc);
         param1.addChild(this._lastPacketIdFunc);
    }

    private void _seqFunc(ICustomDataInput param1) {
         this.seq = param1.readVarUhInt();
         if(this.seq < 0)
         {
            throw new Exception("Forbidden value (" + this.seq + ") on element of BasicAckMessage.seq.");
         }
    }

    private void _lastPacketIdFunc(ICustomDataInput param1) {
         this.lastPacketId = param1.readVarUhShort();
         if(this.lastPacketId < 0)
         {
            throw new Exception("Forbidden value (" + this.lastPacketId + ") on element of BasicAckMessage.lastPacketId.");
         }
    }

}