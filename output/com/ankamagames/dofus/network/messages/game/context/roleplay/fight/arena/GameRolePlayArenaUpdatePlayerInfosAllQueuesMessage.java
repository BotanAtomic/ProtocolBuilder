package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena.ArenaRankInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage extends GameRolePlayArenaUpdatePlayerInfosMessage implements INetworkMessage {

    private int protocolId = 6728;
    private boolean _isInitialized = false;
    private ArenaRankInfos team = ;
    private ArenaRankInfos duel = ;
    private FuncTree _teamtree = ;
    private FuncTree _dueltree = ;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 6728;
    }

    public GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage initGameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(ArenaRankInfos param1,ArenaRankInfos  param2,ArenaRankInfos  param3) {
         super.initGameRolePlayArenaUpdatePlayerInfosMessage(param1);
         this.team = param2;
         this.duel = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.team = new ArenaRankInfos();
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
         this.serializeAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(ICustomDataOutput param1) {
         super.serializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(param1);
         this.team.serializeAs_ArenaRankInfos(param1);
         this.duel.serializeAs_ArenaRankInfos(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this.team = new ArenaRankInfos();
         this.team.deserialize(param1);
         this.duel = new ArenaRankInfos();
         this.duel.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaUpdatePlayerInfosAllQueuesMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         this._teamtree = param1.addChild(this._teamtreeFunc);
         this._dueltree = param1.addChild(this._dueltreeFunc);
    }

    private void _teamtreeFunc(ICustomDataInput param1) {
         this.team = new ArenaRankInfos();
         this.team.deserializeAsync(this._teamtree);
    }

    private void _dueltreeFunc(ICustomDataInput param1) {
         this.duel = new ArenaRankInfos();
         this.duel.deserializeAsync(this._dueltree);
    }

}