package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class LockableShowCodeDialogMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5740;
    private boolean _isInitialized = false;
    private boolean changeOrUse = false;
    private int codeSize = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5740;
    }

    public LockableShowCodeDialogMessage initLockableShowCodeDialogMessage(boolean param1,int  param2) {
         this.changeOrUse = param1;
         this.codeSize = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.changeOrUse = false;
         this.codeSize = 0;
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
         this.serializeAs_LockableShowCodeDialogMessage(param1);
    }

    public void serializeAs_LockableShowCodeDialogMessage(ICustomDataOutput param1) {
         param1.writeBoolean(this.changeOrUse);
         if(this.codeSize < 0)
         {
            throw new Exception("Forbidden value (" + this.codeSize + ") on element codeSize.");
         }
         param1.writeByte(this.codeSize);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableShowCodeDialogMessage(param1);
    }

    public void deserializeAs_LockableShowCodeDialogMessage(ICustomDataInput param1) {
         this._changeOrUseFunc(param1);
         this._codeSizeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LockableShowCodeDialogMessage(param1);
    }

    public void deserializeAsyncAs_LockableShowCodeDialogMessage(FuncTree param1) {
         param1.addChild(this._changeOrUseFunc);
         param1.addChild(this._codeSizeFunc);
    }

    private void _changeOrUseFunc(ICustomDataInput param1) {
         this.changeOrUse = param1.readBoolean();
    }

    private void _codeSizeFunc(ICustomDataInput param1) {
         this.codeSize = param1.readByte();
         if(this.codeSize < 0)
         {
            throw new Exception("Forbidden value (" + this.codeSize + ") on element of LockableShowCodeDialogMessage.codeSize.");
         }
    }

}