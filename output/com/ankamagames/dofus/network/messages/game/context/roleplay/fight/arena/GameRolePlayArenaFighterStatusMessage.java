package package com.ankamagames.dofus.network.messages.game.context.roleplay.fight.arena;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameRolePlayArenaFighterStatusMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6281;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private int playerId = 0;
    private boolean accepted = false;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6281;
    }

    public GameRolePlayArenaFighterStatusMessage initGameRolePlayArenaFighterStatusMessage(int param1,int  param2,boolean  param3) {
         this.fightId = param1;
         this.playerId = param2;
         this.accepted = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.playerId = 0;
         this.accepted = false;
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
         this.serializeAs_GameRolePlayArenaFighterStatusMessage(param1);
    }

    public void serializeAs_GameRolePlayArenaFighterStatusMessage(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         param1.writeInt(this.playerId);
         param1.writeBoolean(this.accepted);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameRolePlayArenaFighterStatusMessage(param1);
    }

    public void deserializeAs_GameRolePlayArenaFighterStatusMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this._playerIdFunc(param1);
         this._acceptedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameRolePlayArenaFighterStatusMessage(param1);
    }

    public void deserializeAsyncAs_GameRolePlayArenaFighterStatusMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._acceptedFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readInt();
    }

    private void _acceptedFunc(ICustomDataInput param1) {
         this.accepted = param1.readBoolean();
    }

}