package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildMember;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformationsMemberUpdateMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5597;
    private boolean _isInitialized = false;
    private GuildMember member;
    private FuncTree _membertree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5597;
    }

    public GuildInformationsMemberUpdateMessage initGuildInformationsMemberUpdateMessage(GuildMember param1) {
         this.member = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.member = new GuildMember();
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
         this.serializeAs_GuildInformationsMemberUpdateMessage(param1);
    }

    public void serializeAs_GuildInformationsMemberUpdateMessage(ICustomDataOutput param1) {
         this.member.serializeAs_GuildMember(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInformationsMemberUpdateMessage(param1);
    }

    public void deserializeAs_GuildInformationsMemberUpdateMessage(ICustomDataInput param1) {
         this.member = new GuildMember();
         this.member.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInformationsMemberUpdateMessage(param1);
    }

    public void deserializeAsyncAs_GuildInformationsMemberUpdateMessage(FuncTree param1) {
         this._membertree = param1.addChild(this._membertreeFunc);
    }

    private void _membertreeFunc(ICustomDataInput param1) {
         this.member = new GuildMember();
         this.member.deserializeAsync(this._membertree);
    }

}