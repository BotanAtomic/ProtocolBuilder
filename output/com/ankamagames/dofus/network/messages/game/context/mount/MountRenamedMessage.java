package package com.ankamagames.dofus.network.messages.game.context.mount;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MountRenamedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5983;
    private boolean _isInitialized = false;
    private int mountId = 0;
    private String name = "";


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5983;
    }

    public MountRenamedMessage initMountRenamedMessage(int param1,String  param2) {
         this.mountId = param1;
         this.name = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.mountId = 0;
         this.name = "";
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
         this.serializeAs_MountRenamedMessage(param1);
    }

    public void serializeAs_MountRenamedMessage(ICustomDataOutput param1) {
         param1.writeVarInt(this.mountId);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_MountRenamedMessage(param1);
    }

    public void deserializeAs_MountRenamedMessage(ICustomDataInput param1) {
         this._mountIdFunc(param1);
         this._nameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_MountRenamedMessage(param1);
    }

    public void deserializeAsyncAs_MountRenamedMessage(FuncTree param1) {
         param1.addChild(this._mountIdFunc);
         param1.addChild(this._nameFunc);
    }

    private void _mountIdFunc(ICustomDataInput param1) {
         this.mountId = param1.readVarInt();
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

}