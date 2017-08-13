package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.StatedElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class StatedElementUpdatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5709;
    private boolean _isInitialized = false;
    private StatedElement statedElement;
    private FuncTree _statedElementtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5709;
    }

    public StatedElementUpdatedMessage initStatedElementUpdatedMessage(StatedElement param1) {
         this.statedElement = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.statedElement = new StatedElement();
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
         this.serializeAs_StatedElementUpdatedMessage(param1);
    }

    public void serializeAs_StatedElementUpdatedMessage(ICustomDataOutput param1) {
         this.statedElement.serializeAs_StatedElement(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_StatedElementUpdatedMessage(param1);
    }

    public void deserializeAs_StatedElementUpdatedMessage(ICustomDataInput param1) {
         this.statedElement = new StatedElement();
         this.statedElement.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_StatedElementUpdatedMessage(param1);
    }

    public void deserializeAsyncAs_StatedElementUpdatedMessage(FuncTree param1) {
         this._statedElementtree = param1.addChild(this._statedElementtreeFunc);
    }

    private void _statedElementtreeFunc(ICustomDataInput param1) {
         this.statedElement = new StatedElement();
         this.statedElement.deserializeAsync(this._statedElementtree);
    }

}