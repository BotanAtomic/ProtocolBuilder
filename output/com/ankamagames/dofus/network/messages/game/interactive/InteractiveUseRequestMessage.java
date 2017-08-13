package package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class InteractiveUseRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5001;
    private boolean _isInitialized = false;
    private int elemId = 0;
    private int skillInstanceUid = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5001;
    }

    public InteractiveUseRequestMessage initInteractiveUseRequestMessage(int param1,int  param2) {
         this.elemId = param1;
         this.skillInstanceUid = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.elemId = 0;
         this.skillInstanceUid = 0;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         if(HASH_FUNCTION != null)
            HASH_FUNCTION(_loc2_);
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
         this.serializeAs_InteractiveUseRequestMessage(param1);
    }

    public void serializeAs_InteractiveUseRequestMessage(ICustomDataOutput param1) {
         if(this.elemId < 0)
            throw new Exception("Forbidden value (" + this.elemId + ") on element elemId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveUseRequestMessage(param1);
    }

    public void deserializeAs_InteractiveUseRequestMessage(ICustomDataInput param1) {
         this._elemIdFunc(param1);
         this._skillInstanceUidFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveUseRequestMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveUseRequestMessage(FuncTree param1) {
         param1.addChild(this._elemIdFunc);
         param1.addChild(this._skillInstanceUidFunc);
    }

    private void _elemIdFunc(ICustomDataInput param1) {
         this.elemId = param1.readVarUhInt();
         if(this.elemId < 0)
            throw new Exception("Forbidden value (" + this.elemId + ") on element of InteractiveUseRequestMessage.elemId.");
    }

    private void _skillInstanceUidFunc(ICustomDataInput param1) {
         this.skillInstanceUid = param1.readVarUhInt();
         if(this.skillInstanceUid < 0)
            throw new Exception("Forbidden value (" + this.skillInstanceUid + ") on element of InteractiveUseRequestMessage.skillInstanceUid.");
    }

}