package com.ankamagames.dofus.network.messages.game.inventory.items;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.ObjectItem;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MimicryObjectPreviewMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6458;
    private boolean _isInitialized = false;
    private ObjectItem result;
    private FuncTree _resulttree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6458;
    }

    public MimicryObjectPreviewMessage initMimicryObjectPreviewMessage(ObjectItem param1) {
         this.result = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.result = new ObjectItem();
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
         this.serializeAs_MimicryObjectPreviewMessage(param1);
    }

    public void serializeAs_MimicryObjectPreviewMessage(ICustomDataOutput param1) {
         this.result.serializeAs_ObjectItem(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MimicryObjectPreviewMessage(param1);
    }

    public void deserializeAs_MimicryObjectPreviewMessage(ICustomDataInput param1) {
         this.result = new ObjectItem();
         this.result.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MimicryObjectPreviewMessage(param1);
    }

    public void deserializeAsyncAs_MimicryObjectPreviewMessage(FuncTree param1) {
         this._resulttree = param1.addChild(this._resulttreeFunc);
    }

    private void _resulttreeFunc(ICustomDataInput param1) {
         this.result = new ObjectItem();
         this.result.deserializeAsync(this._resulttree);
    }

}