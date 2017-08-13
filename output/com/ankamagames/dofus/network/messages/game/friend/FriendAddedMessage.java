package package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class FriendAddedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5599;
    private boolean _isInitialized = false;
    private FriendInformations friendAdded = ;
    private FuncTree _friendAddedtree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5599;
    }

    public FriendAddedMessage initFriendAddedMessage(FriendInformations param1) {
         this.friendAdded = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.friendAdded = new FriendInformations();
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
         this.serializeAs_FriendAddedMessage(param1);
    }

    public void serializeAs_FriendAddedMessage(ICustomDataOutput param1) {
         param1.writeShort(this.friendAdded.getTypeId());
         this.friendAdded.serialize(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendAddedMessage(param1);
    }

    public void deserializeAs_FriendAddedMessage(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.friendAdded = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         this.friendAdded.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendAddedMessage(param1);
    }

    public void deserializeAsyncAs_FriendAddedMessage(FuncTree param1) {
         this._friendAddedtree = param1.addChild(this._friendAddedtreeFunc);
    }

    private void _friendAddedtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.friendAdded = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         this.friendAdded.deserializeAsync(this._friendAddedtree);
    }

}