package com.ankamagames.dofus.network.messages.game.context.display;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class DisplayNumericalValuePaddockMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6563;
    private boolean _isInitialized = false;
    private int rideId = 0;
    private int value = 0;
    private int type = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6563;
    }

    public DisplayNumericalValuePaddockMessage initDisplayNumericalValuePaddockMessage(int param1,int  param2,int  param3) {
         this.rideId = param1;
         this.value = param2;
         this.type = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.rideId = 0;
         this.value = 0;
         this.type = 0;
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
         this.serializeAs_DisplayNumericalValuePaddockMessage(param1);
    }

    public void serializeAs_DisplayNumericalValuePaddockMessage(ICustomDataOutput param1) {
         param1.writeInt(this.rideId);
         param1.writeInt(this.value);
         param1.writeByte(this.type);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_DisplayNumericalValuePaddockMessage(param1);
    }

    public void deserializeAs_DisplayNumericalValuePaddockMessage(ICustomDataInput param1) {
         this._rideIdFunc(param1);
         this._valueFunc(param1);
         this._typeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_DisplayNumericalValuePaddockMessage(param1);
    }

    public void deserializeAsyncAs_DisplayNumericalValuePaddockMessage(FuncTree param1) {
         param1.addChild(this._rideIdFunc);
         param1.addChild(this._valueFunc);
         param1.addChild(this._typeFunc);
    }

    private void _rideIdFunc(ICustomDataInput param1) {
         this.rideId = param1.readInt();
    }

    private void _valueFunc(ICustomDataInput param1) {
         this.value = param1.readInt();
    }

    private void _typeFunc(ICustomDataInput param1) {
         this.type = param1.readByte();
         if(this.type < 0)
         {
            throw new Exception("Forbidden value (" + this.type + ") on element of DisplayNumericalValuePaddockMessage.type.");
         }
    }

}