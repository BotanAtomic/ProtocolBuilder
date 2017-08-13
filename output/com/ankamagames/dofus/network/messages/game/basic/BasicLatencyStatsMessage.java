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
import java.lang.Exception;
import java.lang.Exception;

public class BasicLatencyStatsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5663;
    private boolean _isInitialized = false;
    private int latency = 0;
    private int sampleCount = 0;
    private int max = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5663;
    }

    public BasicLatencyStatsMessage initBasicLatencyStatsMessage(int param1,int  param2,int  param3) {
         this.latency = param1;
         this.sampleCount = param2;
         this.max = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.latency = 0;
         this.sampleCount = 0;
         this.max = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
         {
            HASH_FUNCTION(_loc2_);
         }
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
         this.serializeAs_BasicLatencyStatsMessage(param1);
    }

    public void serializeAs_BasicLatencyStatsMessage(ICustomDataOutput param1) {
         if(this.latency < 0 || this.latency > 65535)
         {
            throw new Exception("Forbidden value (" + this.latency + ") on element latency.");
         }
         param1.writeShort(this.latency);
         if(this.sampleCount < 0)
         {
            throw new Exception("Forbidden value (" + this.sampleCount + ") on element sampleCount.");
         }
         param1.writeVarShort(this.sampleCount);
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element max.");
         }
         param1.writeVarShort(this.max);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicLatencyStatsMessage(param1);
    }

    public void deserializeAs_BasicLatencyStatsMessage(ICustomDataInput param1) {
         this._latencyFunc(param1);
         this._sampleCountFunc(param1);
         this._maxFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicLatencyStatsMessage(param1);
    }

    public void deserializeAsyncAs_BasicLatencyStatsMessage(FuncTree param1) {
         param1.addChild(this._latencyFunc);
         param1.addChild(this._sampleCountFunc);
         param1.addChild(this._maxFunc);
    }

    private void _latencyFunc(ICustomDataInput param1) {
         this.latency = param1.readUnsignedShort();
         if(this.latency < 0 || this.latency > 65535)
         {
            throw new Exception("Forbidden value (" + this.latency + ") on element of BasicLatencyStatsMessage.latency.");
         }
    }

    private void _sampleCountFunc(ICustomDataInput param1) {
         this.sampleCount = param1.readVarUhShort();
         if(this.sampleCount < 0)
         {
            throw new Exception("Forbidden value (" + this.sampleCount + ") on element of BasicLatencyStatsMessage.sampleCount.");
         }
    }

    private void _maxFunc(ICustomDataInput param1) {
         this.max = param1.readVarUhShort();
         if(this.max < 0)
         {
            throw new Exception("Forbidden value (" + this.max + ") on element of BasicLatencyStatsMessage.max.");
         }
    }

}