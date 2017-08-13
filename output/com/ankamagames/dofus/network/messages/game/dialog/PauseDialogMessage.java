package com.ankamagames.dofus.network.messages.game.dialog;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class PauseDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6012;
    private boolean _isInitialized = false;
    private int dialogType = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6012;
    }

    public PauseDialogMessage initPauseDialogMessage(int param1) {
         this.dialogType = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.dialogType = 0;
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
         this.serializeAs_PauseDialogMessage(param1);
    }

    public void serializeAs_PauseDialogMessage(ICustomDataOutput param1) {
         param1.writeByte(this.dialogType);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PauseDialogMessage(param1);
    }

    public void deserializeAs_PauseDialogMessage(ICustomDataInput param1) {
         this._dialogTypeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PauseDialogMessage(param1);
    }

    public void deserializeAsyncAs_PauseDialogMessage(FuncTree param1) {
         param1.addChild(this._dialogTypeFunc);
    }

    private void _dialogTypeFunc(ICustomDataInput param1) {
         this.dialogType = param1.readByte();
         if(this.dialogType < 0)
         {
            throw new Exception("Forbidden value (" + this.dialogType + ") on element of PauseDialogMessage.dialogType.");
         }
    }

}