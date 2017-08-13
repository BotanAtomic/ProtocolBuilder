package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightMinimalStats;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class RefreshCharacterStatsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6699;
    private boolean _isInitialized = false;
    private Number fighterId = 0;
    private GameFightMinimalStats stats;
    private FuncTree _statstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6699;
    }

    public RefreshCharacterStatsMessage initRefreshCharacterStatsMessage(Number param1,GameFightMinimalStats  param2) {
         this.fighterId = param1;
         this.stats = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fighterId = 0;
         this.stats = new GameFightMinimalStats();
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
         this.serializeAs_RefreshCharacterStatsMessage(param1);
    }

    public void serializeAs_RefreshCharacterStatsMessage(ICustomDataOutput param1) {
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element fighterId.");
         }
         param1.writeDouble(this.fighterId);
         this.stats.serializeAs_GameFightMinimalStats(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_RefreshCharacterStatsMessage(param1);
    }

    public void deserializeAs_RefreshCharacterStatsMessage(ICustomDataInput param1) {
         this._fighterIdFunc(param1);
         this.stats = new GameFightMinimalStats();
         this.stats.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_RefreshCharacterStatsMessage(param1);
    }

    public void deserializeAsyncAs_RefreshCharacterStatsMessage(FuncTree param1) {
         param1.addChild(this._fighterIdFunc);
         this._statstree = param1.addChild(this._statstreeFunc);
    }

    private void _fighterIdFunc(ICustomDataInput param1) {
         this.fighterId = param1.readDouble();
         if(this.fighterId < -9.007199254740992E15 || this.fighterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.fighterId + ") on element of RefreshCharacterStatsMessage.fighterId.");
         }
    }

    private void _statstreeFunc(ICustomDataInput param1) {
         this.stats = new GameFightMinimalStats();
         this.stats.deserializeAsync(this._statstree);
    }

}