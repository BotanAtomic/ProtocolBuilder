package com.ankamagames.dofus.network.messages.game.context.mount;

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

public class MountInformationRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5972;
    private boolean _isInitialized = false;
    private Number id = 0;
    private Number time = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5972;
    }

    public MountInformationRequestMessage initMountInformationRequestMessage(Number param1,Number  param2) {
         this.id = param1;
         this.time = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.time = 0;
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
         this.serializeAs_MountInformationRequestMessage(param1);
    }

    public void serializeAs_MountInformationRequestMessage(ICustomDataOutput param1) {
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.time < -9.007199254740992E15 || this.time > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element time.");
         }
         param1.writeDouble(this.time);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountInformationRequestMessage(param1);
    }

    public void deserializeAs_MountInformationRequestMessage(ICustomDataInput param1) {
         this._idFunc(param1);
         this._timeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountInformationRequestMessage(param1);
    }

    public void deserializeAsyncAs_MountInformationRequestMessage(FuncTree param1) {
         param1.addChild(this._idFunc);
         param1.addChild(this._timeFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of MountInformationRequestMessage.id.");
         }
    }

    private void _timeFunc(ICustomDataInput param1) {
         this.time = param1.readDouble();
         if(this.time < -9.007199254740992E15 || this.time > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.time + ") on element of MountInformationRequestMessage.time.");
         }
    }

}