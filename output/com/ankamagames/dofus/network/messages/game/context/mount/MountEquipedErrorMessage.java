package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class MountEquipedErrorMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5963;
    private boolean _isInitialized = false;
    private int errorType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5963;
    }

    public MountEquipedErrorMessage initMountEquipedErrorMessage(int param1) {
         this.errorType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.errorType = 0;
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
         this.serializeAs_MountEquipedErrorMessage(param1);
    }

    public void serializeAs_MountEquipedErrorMessage(ICustomDataOutput param1) {
         param1.writeByte(this.errorType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountEquipedErrorMessage(param1);
    }

    public void deserializeAs_MountEquipedErrorMessage(ICustomDataInput param1) {
         this._errorTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountEquipedErrorMessage(param1);
    }

    public void deserializeAsyncAs_MountEquipedErrorMessage(FuncTree param1) {
         param1.addChild(this._errorTypeFunc);
    }

    private void _errorTypeFunc(ICustomDataInput param1) {
         this.errorType = param1.readByte();
         if(this.errorType < 0)
         {
            throw new Exception("Forbidden value (" + this.errorType + ") on element of MountEquipedErrorMessage.errorType.");
         }
    }

}