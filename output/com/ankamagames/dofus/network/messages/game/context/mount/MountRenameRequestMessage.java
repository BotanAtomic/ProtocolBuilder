package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountRenameRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5987;
    private boolean _isInitialized = false;
    private String name = "";
    private int mountId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5987;
    }

    public MountRenameRequestMessage initMountRenameRequestMessage(String param1,int  param2) {
         this.name = param1;
         this.mountId = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.name = "";
         this.mountId = 0;
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
         this.serializeAs_MountRenameRequestMessage(param1);
    }

    public void serializeAs_MountRenameRequestMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeVarInt(this.mountId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountRenameRequestMessage(param1);
    }

    public void deserializeAs_MountRenameRequestMessage(ICustomDataInput param1) {
         this._nameFunc(param1);
         this._mountIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountRenameRequestMessage(param1);
    }

    public void deserializeAsyncAs_MountRenameRequestMessage(FuncTree param1) {
         param1.addChild(this._nameFunc);
         param1.addChild(this._mountIdFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _mountIdFunc(ICustomDataInput param1) {
         this.mountId = param1.readVarInt();
    }

}