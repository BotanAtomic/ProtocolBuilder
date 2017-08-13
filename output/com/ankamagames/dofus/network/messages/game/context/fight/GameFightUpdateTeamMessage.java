package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightTeamInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightUpdateTeamMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5572;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private FightTeamInformations team;
    private FuncTree _teamtree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5572;
    }

    public GameFightUpdateTeamMessage initGameFightUpdateTeamMessage(int param1,FightTeamInformations  param2) {
         this.fightId = param1;
         this.team = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.team = new FightTeamInformations();
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
         this.serializeAs_GameFightUpdateTeamMessage(param1);
    }

    public void serializeAs_GameFightUpdateTeamMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeShort(this.fightId);
         this.team.serializeAs_FightTeamInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightUpdateTeamMessage(param1);
    }

    public void deserializeAs_GameFightUpdateTeamMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this.team = new FightTeamInformations();
         this.team.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightUpdateTeamMessage(param1);
    }

    public void deserializeAsyncAs_GameFightUpdateTeamMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         this._teamtree = param1.addChild(this._teamtreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readShort();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GameFightUpdateTeamMessage.fightId.");
         }
    }

    private void _teamtreeFunc(ICustomDataInput param1) {
         this.team = new FightTeamInformations();
         this.team.deserializeAsync(this._teamtree);
    }

}