package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeam;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameFightSpectatorJoinMessage extends GameFightJoinMessage implements INetworkMessage {

    private int protocolId = 6504;
    private boolean _isInitialized = false;
    private Vector.<NamedPartyTeam> namedPartyTeams = ;
    private FuncTree _namedPartyTeamstree = ;
    private int _loc2_ = 0;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6504;
    }

    public GameFightSpectatorJoinMessage initGameFightSpectatorJoinMessage(boolean param1,boolean  param2,boolean  param3,boolean  param4,int  param5,int  param6,Vector.<NamedPartyTeam>  param7) {
         super.initGameFightJoinMessage(param1,param2,param3,param4,param5,param6);
         this.namedPartyTeams = param7;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.namedPartyTeams = new Vector.<NamedPartyTeam>();
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
         this.serializeAs_GameFightSpectatorJoinMessage(param1);
    }

    public void serializeAs_GameFightSpectatorJoinMessage(ICustomDataOutput param1) {
         super.serializeAs_GameFightJoinMessage(param1);
         param1.writeShort(this.namedPartyTeams.length);
         int _loc2_ = 0;
         while(_loc2_ < this.namedPartyTeams.length)
            (this.namedPartyTeams[_loc2_] as NamedPartyTeam).serializeAs_NamedPartyTeam(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightSpectatorJoinMessage(param1);
    }

    public void deserializeAs_GameFightSpectatorJoinMessage(ICustomDataInput param1) {
         NamedPartyTeam _loc4_ = null;
         super.deserialize(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc4_ = new NamedPartyTeam();
            _loc4_.deserialize(param1);
            this.namedPartyTeams.push(_loc4_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightSpectatorJoinMessage(param1);
    }

    public void deserializeAsyncAs_GameFightSpectatorJoinMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._namedPartyTeamstree = param1.addChild(this._namedPartyTeamstreeFunc);
    }

    private void _namedPartyTeamstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._namedPartyTeamstree.addChild(this._namedPartyTeamsFunc);
            _loc3_++;
    }

    private void _namedPartyTeamsFunc(ICustomDataInput param1) {
         NamedPartyTeam _loc2_ = new NamedPartyTeam();
         _loc2_.deserialize(param1);
         this.namedPartyTeams.push(_loc2_);
    }

}