package package com.ankamagames.dofus.network.messages.game.startup;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import java.lang.Exception;
import java.lang.Exception;

public class StartupActionFinishedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 1304;
    private boolean _isInitialized = false;
    private boolean success = false;
    private int actionId = 0;
    private boolean automaticAction = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 1304;
    }

    public StartupActionFinishedMessage initStartupActionFinishedMessage(boolean param1,int  param2,boolean  param3) {
         this.success = param1;
         this.actionId = param2;
         this.automaticAction = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.success = false;
         this.actionId = 0;
         this.automaticAction = false;
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
         this.serializeAs_StartupActionFinishedMessage(param1);
    }

    public void serializeAs_StartupActionFinishedMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.success);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.automaticAction);
         param1.writeByte(_loc2_);
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StartupActionFinishedMessage(param1);
    }

    public void deserializeAs_StartupActionFinishedMessage(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._actionIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StartupActionFinishedMessage(param1);
    }

    public void deserializeAsyncAs_StartupActionFinishedMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._actionIdFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.success = BooleanByteWrapper.getFlag(_loc2_,0);
         this.automaticAction = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _actionIdFunc(ICustomDataInput param1) {
         this.actionId = param1.readInt();
         if(this.actionId < 0)
            throw new Exception("Forbidden value (" + this.actionId + ") on element of StartupActionFinishedMessage.actionId.");
    }

}