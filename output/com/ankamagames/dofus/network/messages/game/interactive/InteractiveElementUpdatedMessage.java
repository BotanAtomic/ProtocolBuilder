package com.ankamagames.dofus.network.messages.game.interactive;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.interactive.InteractiveElement;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InteractiveElementUpdatedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5708;
    private boolean _isInitialized = false;
    private InteractiveElement interactiveElement;
    private FuncTree _interactiveElementtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5708;
    }

    public InteractiveElementUpdatedMessage initInteractiveElementUpdatedMessage(InteractiveElement param1) {
         this.interactiveElement = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.interactiveElement = new InteractiveElement();
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
         this.serializeAs_InteractiveElementUpdatedMessage(param1);
    }

    public void serializeAs_InteractiveElementUpdatedMessage(ICustomDataOutput param1) {
         this.interactiveElement.serializeAs_InteractiveElement(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InteractiveElementUpdatedMessage(param1);
    }

    public void deserializeAs_InteractiveElementUpdatedMessage(ICustomDataInput param1) {
         this.interactiveElement = new InteractiveElement();
         this.interactiveElement.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InteractiveElementUpdatedMessage(param1);
    }

    public void deserializeAsyncAs_InteractiveElementUpdatedMessage(FuncTree param1) {
         this._interactiveElementtree = param1.addChild(this._interactiveElementtreeFunc);
    }

    private void _interactiveElementtreeFunc(ICustomDataInput param1) {
         this.interactiveElement = new InteractiveElement();
         this.interactiveElement.deserializeAsync(this._interactiveElementtree);
    }

}