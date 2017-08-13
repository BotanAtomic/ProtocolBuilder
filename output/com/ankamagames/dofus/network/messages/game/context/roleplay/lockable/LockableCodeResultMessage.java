package com.ankamagames.dofus.network.messages.game.context.roleplay.lockable;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class LockableCodeResultMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5672;
    private boolean _isInitialized = false;
    private int result = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5672;
    }

    public LockableCodeResultMessage initLockableCodeResultMessage(int param1) {
         this.result = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.result = 0;
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
         this.serializeAs_LockableCodeResultMessage(param1);
    }

    public void serializeAs_LockableCodeResultMessage(ICustomDataOutput param1) {
         param1.writeByte(this.result);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_LockableCodeResultMessage(param1);
    }

    public void deserializeAs_LockableCodeResultMessage(ICustomDataInput param1) {
         this._resultFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_LockableCodeResultMessage(param1);
    }

    public void deserializeAsyncAs_LockableCodeResultMessage(FuncTree param1) {
         param1.addChild(this._resultFunc);
    }

    private void _resultFunc(ICustomDataInput param1) {
         this.result = param1.readByte();
         if(this.result < 0)
         {
            throw new Exception("Forbidden value (" + this.result + ") on element of LockableCodeResultMessage.result.");
         }
    }

}