package com.ankamagames.dofus.network.messages.game.context.roleplay.party;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyInvitationMemberInformations;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.PartyGuestInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class PartyInvitationDungeonDetailsMessage extends PartyInvitationDetailsMessage implements INetworkMessage {

    private int protocolId = 6262;
    private boolean _isInitialized = false;
    private int dungeonId = 0;
    private Vector<Boolean> playersDungeonReady;
    private FuncTree _playersDungeonReadytree;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6262;
    }

    public PartyInvitationDungeonDetailsMessage initPartyInvitationDungeonDetailsMessage(int param1,int  param2,String  param3,Number  param4,String  param5,Number  param6,Vector<PartyInvitationMemberInformations>  param7,Vector<PartyGuestInformations>  param8,int  param9,Vector<Boolean>  param10) {
         super.initPartyInvitationDetailsMessage(param1,param2,param3,param4,param5,param6,param7,param8);
         this.dungeonId = param9;
         this.playersDungeonReady = param10;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.dungeonId = 0;
         this.playersDungeonReady = new Vector.<Boolean>();
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
         this.serializeAs_PartyInvitationDungeonDetailsMessage(param1);
    }

    public void serializeAs_PartyInvitationDungeonDetailsMessage(ICustomDataOutput param1) {
         super.serializeAs_PartyInvitationDetailsMessage(param1);
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element dungeonId.");
         }
         param1.writeVarShort(this.dungeonId);
         param1.writeShort(this.playersDungeonReady.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playersDungeonReady.length)
         {
            param1.writeBoolean(this.playersDungeonReady[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyInvitationDungeonDetailsMessage(param1);
    }

    public void deserializeAs_PartyInvitationDungeonDetailsMessage(ICustomDataInput param1) {
         * _loc4_ = false;
         super.deserialize(param1);
         this._dungeonIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readBoolean();
            this.playersDungeonReady.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyInvitationDungeonDetailsMessage(param1);
    }

    public void deserializeAsyncAs_PartyInvitationDungeonDetailsMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._dungeonIdFunc);
         this._playersDungeonReadytree = param1.addChild(this._playersDungeonReadytreeFunc);
    }

    private void _dungeonIdFunc(ICustomDataInput param1) {
         this.dungeonId = param1.readVarUhShort();
         if(this.dungeonId < 0)
         {
            throw new Exception("Forbidden value (" + this.dungeonId + ") on element of PartyInvitationDungeonDetailsMessage.dungeonId.");
         }
    }

    private void _playersDungeonReadytreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._playersDungeonReadytree.addChild(this._playersDungeonReadyFunc);
            _loc3_++;
         }
    }

    private void _playersDungeonReadyFunc(ICustomDataInput param1) {
         boolean _loc2_ = param1.readBoolean();
         this.playersDungeonReady.push(_loc2_);
    }

}