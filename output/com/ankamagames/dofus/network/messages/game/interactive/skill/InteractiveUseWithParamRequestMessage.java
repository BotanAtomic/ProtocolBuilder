package com.ankamagames.dofus.network.messages.game.interactive.skill;

import com.ankamagames.dofus.network.messages.game.interactive.InteractiveUseRequestMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveUseWithParamRequestMessage extends InteractiveUseRequestMessage implements INetworkMessage {

    private int protocolId = 6715;
    private boolean _isInitialized = false;
    private int id = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6715;
    }

    public InteractiveUseWithParamRequestMessage initInteractiveUseWithParamRequestMessage(int param1,int  param2,int  param3) {
         super.initInteractiveUseRequestMessage(param1,param2);
         this.id = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.id = 0;
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
         this.serializeAs_InteractiveUseWithParamRequestMessage(param1);
    }

    public void serializeAs_InteractiveUseWithParamRequestMessage(ICustomDataOutput param1) {
         super.serializeAs_InteractiveUseRequestMessage(param1);
         param1.writeInt(this.id);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveUseWithParamRequestMessage(param1);
    }

    public void deserializeAs_InteractiveUseWithParamRequestMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveUseWithParamRequestMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveUseWithParamRequestMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readInt();
    }

}