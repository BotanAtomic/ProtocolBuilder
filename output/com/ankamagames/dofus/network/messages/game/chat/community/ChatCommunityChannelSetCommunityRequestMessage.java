package package com.ankamagames.dofus.network.messages.game.chat.community;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ChatCommunityChannelSetCommunityRequestMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6729;
    private boolean _isInitialized = false;
    private int communityId = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6729;
    }

    public ChatCommunityChannelSetCommunityRequestMessage initChatCommunityChannelSetCommunityRequestMessage(int param1) {
         this.communityId = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.communityId = 0;
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
         this.serializeAs_ChatCommunityChannelSetCommunityRequestMessage(param1);
    }

    public void serializeAs_ChatCommunityChannelSetCommunityRequestMessage(ICustomDataOutput param1) {
         param1.writeShort(this.communityId);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ChatCommunityChannelSetCommunityRequestMessage(param1);
    }

    public void deserializeAs_ChatCommunityChannelSetCommunityRequestMessage(ICustomDataInput param1) {
         this._communityIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ChatCommunityChannelSetCommunityRequestMessage(param1);
    }

    public void deserializeAsyncAs_ChatCommunityChannelSetCommunityRequestMessage(FuncTree param1) {
         param1.addChild(this._communityIdFunc);
    }

    private void _communityIdFunc(ICustomDataInput param1) {
         this.communityId = param1.readShort();
    }

}