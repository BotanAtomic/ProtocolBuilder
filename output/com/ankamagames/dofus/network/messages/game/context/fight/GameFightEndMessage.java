package package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightResultListEntry;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeamWithOutcome;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightEndMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 720;
    private boolean _isInitialized = false;
    private int duration = 0;
    private int ageBonus = 0;
    private int lootShareLimitMalus = 0;
    private Vector.<FightResultListEntry> results = ;
    private Vector.<NamedPartyTeamWithOutcome> namedPartyTeamsOutcomes = ;
    private FuncTree _resultstree = ;
    private FuncTree _namedPartyTeamsOutcomestree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private FightResultListEntry _loc7_ = null;
    private NamedPartyTeamWithOutcome _loc8_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc3_ = 0;
    private FightResultListEntry _loc3_ = ProtocolTypeManager.getInstance(FightResultListEntry,_loc2_);
    private int _loc3_ = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 720;
    }

    public GameFightEndMessage initGameFightEndMessage(int param1,int  param2,int  param3,Vector.<FightResultListEntry>  param4,Vector.<NamedPartyTeamWithOutcome>  param5) {
         this.duration = param1;
         this.ageBonus = param2;
         this.lootShareLimitMalus = param3;
         this.results = param4;
         this.namedPartyTeamsOutcomes = param5;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.duration = 0;
         this.ageBonus = 0;
         this.lootShareLimitMalus = 0;
         this.results = new Vector.<FightResultListEntry>();
         this.namedPartyTeamsOutcomes = new Vector.<NamedPartyTeamWithOutcome>();
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
         this.serializeAs_GameFightEndMessage(param1);
    }

    public void serializeAs_GameFightEndMessage(ICustomDataOutput param1) {
         if(this.duration < 0)
            throw new Exception("Forbidden value (" + this.duration + ") on element duration.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightEndMessage(param1);
    }

    public void deserializeAs_GameFightEndMessage(ICustomDataInput param1) {
         int _loc6_ = 0;
         FightResultListEntry _loc7_ = null;
         NamedPartyTeamWithOutcome _loc8_ = null;
         this._durationFunc(param1);
         this._ageBonusFunc(param1);
         this._lootShareLimitMalusFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc6_ = param1.readUnsignedShort();
            _loc7_ = ProtocolTypeManager.getInstance(FightResultListEntry,_loc6_);
            _loc7_.deserialize(param1);
            this.results.push(_loc7_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightEndMessage(param1);
    }

    public void deserializeAsyncAs_GameFightEndMessage(FuncTree param1) {
         param1.addChild(this._durationFunc);
         param1.addChild(this._ageBonusFunc);
         param1.addChild(this._lootShareLimitMalusFunc);
         this._resultstree = param1.addChild(this._resultstreeFunc);
         this._namedPartyTeamsOutcomestree = param1.addChild(this._namedPartyTeamsOutcomestreeFunc);
    }

    private void _durationFunc(ICustomDataInput param1) {
         this.duration = param1.readInt();
         if(this.duration < 0)
            throw new Exception("Forbidden value (" + this.duration + ") on element of GameFightEndMessage.duration.");
    }

    private void _ageBonusFunc(ICustomDataInput param1) {
         this.ageBonus = param1.readShort();
    }

    private void _lootShareLimitMalusFunc(ICustomDataInput param1) {
         this.lootShareLimitMalus = param1.readShort();
    }

    private void _resultstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._resultstree.addChild(this._resultsFunc);
            _loc3_++;
    }

    private void _resultsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         FightResultListEntry _loc3_ = ProtocolTypeManager.getInstance(FightResultListEntry,_loc2_);
         _loc3_.deserialize(param1);
         this.results.push(_loc3_);
    }

    private void _namedPartyTeamsOutcomestreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._namedPartyTeamsOutcomestree.addChild(this._namedPartyTeamsOutcomesFunc);
            _loc3_++;
    }

    private void _namedPartyTeamsOutcomesFunc(ICustomDataInput param1) {
         NamedPartyTeamWithOutcome _loc2_ = new NamedPartyTeamWithOutcome();
         _loc2_.deserialize(param1);
         this.namedPartyTeamsOutcomes.push(_loc2_);
    }

}