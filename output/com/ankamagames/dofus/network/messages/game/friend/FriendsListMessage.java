package com.ankamagames.dofus.network.messages.game.friend;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.friend.FriendInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class FriendsListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 4002;
    private boolean _isInitialized = false;
    private Vector<FriendInformations> friendsList;
    private FuncTree _friendsListtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 4002;
    }

    public FriendsListMessage initFriendsListMessage(Vector<FriendInformations> param1) {
         this.friendsList = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.friendsList = new Vector.<FriendInformations>();
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
         this.serializeAs_FriendsListMessage(param1);
    }

    public void serializeAs_FriendsListMessage(ICustomDataOutput param1) {
         param1.writeShort(this.friendsList.length);
         int _loc2_ = 0;
         while(_loc2_ < this.friendsList.length)
         {
            param1.writeShort((this.friendsList[_loc2_] as FriendInformations).getTypeId());
            (this.friendsList[_loc2_] as FriendInformations).serialize(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FriendsListMessage(param1);
    }

    public void deserializeAs_FriendsListMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         FriendInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(FriendInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.friendsList.push(_loc5_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FriendsListMessage(param1);
    }

    public void deserializeAsyncAs_FriendsListMessage(FuncTree param1) {
         this._friendsListtree = param1.addChild(this._friendsListtreeFunc);
    }

    private void _friendsListtreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._friendsListtree.addChild(this._friendsListFunc);
            _loc3_++;
         }
    }

    private void _friendsListFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         FriendInformations _loc3_ = ProtocolTypeManager.getInstance(FriendInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.friendsList.push(_loc3_);
    }

}