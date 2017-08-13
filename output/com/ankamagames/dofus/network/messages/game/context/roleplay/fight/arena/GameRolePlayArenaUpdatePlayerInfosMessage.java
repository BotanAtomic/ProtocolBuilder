package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.fight.arena.ArenaRankInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaUpdatePlayerInfosMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6301;
    private boolean _isInitialized = false;
    private ArenaRankInfos solo;
    private FuncTree _solotree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6301;
    }

    public GameRolePlayArenaUpdatePlayerInfosMessage initGameRolePlayArenaUpdatePlayerInfosMessage(ArenaRankInfos param1) {
         this.solo = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.solo = new ArenaRankInfos();
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
         this.serializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(ICustomDataOutput param1) {
         this.solo.serializeAs_ArenaRankInfos(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaUpdatePlayerInfosMessage(ICustomDataInput param1) {
         this.solo = new ArenaRankInfos();
         this.solo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaUpdatePlayerInfosMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaUpdatePlayerInfosMessage(FuncTree param1) {
         this._solotree = param1.addChild(this._solotreeFunc);
    }

    private void _solotreeFunc(ICustomDataInput param1) {
         this.solo = new ArenaRankInfos();
         this.solo.deserializeAsync(this._solotree);
    }

}