package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.IgnoredInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class IgnoredAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5678;
    private boolean _isInitialized = false;
    private IgnoredInformations ignoreAdded = ;
    private boolean session = false;
    private FuncTree _ignoreAddedtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5678;
    }

    public IgnoredAddedMessage initIgnoredAddedMessage(IgnoredInformations param1,boolean  param2) {
         this.ignoreAdded = param1;
         this.session = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.ignoreAdded = new IgnoredInformations();
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
         this.serializeAs_IgnoredAddedMessage(param1);
    }

    public void serializeAs_IgnoredAddedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.ignoreAdded.getTypeId());
         this.ignoreAdded.serialize(param1);
         param1.writeBoolean(this.session);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IgnoredAddedMessage(param1);
    }

    public void deserializeAs_IgnoredAddedMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.ignoreAdded = ProtocolTypeManager.getInstance(IgnoredInformations,_loc2_);
         this.ignoreAdded.deserialize(param1);
         this._sessionFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IgnoredAddedMessage(param1);
    }

    public void deserializeAsyncAs_IgnoredAddedMessage(FuncTree param1) {
         this._ignoreAddedtree = param1.addChild(this._ignoreAddedtreeFunc);
         param1.addChild(this._sessionFunc);
    }

    private void _ignoreAddedtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.ignoreAdded = ProtocolTypeManager.getInstance(IgnoredInformations,_loc2_);
         this.ignoreAdded.deserializeAsync(this._ignoreAddedtree);
    }

    private void _sessionFunc(ICustomDataInput param1) {
         this.session = param1.readBoolean();
    }

}