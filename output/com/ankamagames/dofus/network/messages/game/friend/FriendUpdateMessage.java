package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class FriendUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5924;
    private boolean _isInitialized = false;
    private FriendInformations friendUpdated;
    private FuncTree _friendUpdatedtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5924;
    }

    public FriendUpdateMessage initFriendUpdateMessage(FriendInformations param1) {
         this.friendUpdated = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.friendUpdated = new FriendInformations();
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
         this.serializeAs_FriendUpdateMessage(param1);
    }

    public void serializeAs_FriendUpdateMessage(ICustomDataOutput param1) {
         param1.writeShort(this.friendUpdated.getTypeId());
         this.friendUpdated.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendUpdateMessage(param1);
    }

    public void deserializeAs_FriendUpdateMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.friendUpdated = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         this.friendUpdated.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendUpdateMessage(param1);
    }

    public void deserializeAsyncAs_FriendUpdateMessage(FuncTree param1) {
         this._friendUpdatedtree = param1.addChild(this._friendUpdatedtreeFunc);
    }

    private void _friendUpdatedtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.friendUpdated = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         this.friendUpdated.deserializeAsync(this._friendUpdatedtree);
    }

}