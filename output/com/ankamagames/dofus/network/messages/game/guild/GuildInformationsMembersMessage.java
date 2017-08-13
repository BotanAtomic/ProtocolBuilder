package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.guild.GuildMember;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GuildInformationsMembersMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5558;
    private boolean _isInitialized = false;
    private Vector<GuildMember> members;
    private FuncTree _memberstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5558;
    }

    public GuildInformationsMembersMessage initGuildInformationsMembersMessage(Vector<GuildMember> param1) {
         this.members = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.members = new Vector.<GuildMember>();
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
         this.serializeAs_GuildInformationsMembersMessage(param1);
    }

    public void serializeAs_GuildInformationsMembersMessage(ICustomDataOutput param1) {
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            (this.members[_loc2_] as GuildMember).serializeAs_GuildMember(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildInformationsMembersMessage(param1);
    }

    public void deserializeAs_GuildInformationsMembersMessage(ICustomDataInput param1) {
         GuildMember _loc4_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new GuildMember();
            _loc4_.deserialize(param1);
            this.members.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildInformationsMembersMessage(param1);
    }

    public void deserializeAsyncAs_GuildInformationsMembersMessage(FuncTree param1) {
         this._memberstree = param1.addChild(this._memberstreeFunc);
    }

    private void _memberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._memberstree.addChild(this._membersFunc);
            _loc3_++;
         }
    }

    private void _membersFunc(ICustomDataInput param1) {
         GuildMember _loc2_ = new GuildMember();
         _loc2_.deserialize(param1);
         this.members.push(_loc2_);
    }

}