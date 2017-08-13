package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class IgnoredAddRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5673;
    private boolean _isInitialized = false;
    private String name = "";
    private boolean session = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5673;
    }

    public IgnoredAddRequestMessage initIgnoredAddRequestMessage(String param1,boolean  param2) {
         this.name = param1;
         this.session = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.name = "";
         this.session = false;
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
         this.serializeAs_IgnoredAddRequestMessage(param1);
    }

    public void serializeAs_IgnoredAddRequestMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.name);
         param1.writeBoolean(this.session);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredAddRequestMessage(param1);
    }

    public void deserializeAs_IgnoredAddRequestMessage(ICustomDataInput param1) {
         this._nameFunc(param1);
         this._sessionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredAddRequestMessage(param1);
    }

    public void deserializeAsyncAs_IgnoredAddRequestMessage(FuncTree param1) {
         param1.addChild(this._nameFunc);
         param1.addChild(this._sessionFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

    private void _sessionFunc(ICustomDataInput param1) {
         this.session = param1.readBoolean();
    }

}