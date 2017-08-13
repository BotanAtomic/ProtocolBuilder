package com.ankamagames.dofus.network.messages.game.look;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AccessoryPreviewMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6517;
    private boolean _isInitialized = false;
    private EntityLook look;
    private FuncTree _looktree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6517;
    }

    public AccessoryPreviewMessage initAccessoryPreviewMessage(EntityLook param1) {
         this.look = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.look = new EntityLook();
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
         this.serializeAs_AccessoryPreviewMessage(param1);
    }

    public void serializeAs_AccessoryPreviewMessage(ICustomDataOutput param1) {
         this.look.serializeAs_EntityLook(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AccessoryPreviewMessage(param1);
    }

    public void deserializeAs_AccessoryPreviewMessage(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AccessoryPreviewMessage(param1);
    }

    public void deserializeAsyncAs_AccessoryPreviewMessage(FuncTree param1) {
         this._looktree = param1.addChild(this._looktreeFunc);
    }

    private void _looktreeFunc(ICustomDataInput param1) {
         this.look = new EntityLook();
         this.look.deserializeAsync(this._looktree);
    }

}