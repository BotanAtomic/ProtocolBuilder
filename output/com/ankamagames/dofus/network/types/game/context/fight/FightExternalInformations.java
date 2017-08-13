package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class FightExternalInformations extends Object implements INetworkType {

    private int protocolId = 117;
    private int fightId = 0;
    private int fightType = 0;
    private int fightStart = 0;
    private boolean fightSpectatorLocked = false;
    private Vector<FightTeamLightInformations> fightTeams;
    private Vector<FightOptionsInformations> fightTeamsOptions;
    private FuncTree _fightTeamstree;
    private int _fightTeamsindex = 0;
    private FuncTree _fightTeamsOptionstree;
    private int _fightTeamsOptionsindex = 0;


    public int getTypeId() {
         return 117;
    }

    public FightExternalInformations initFightExternalInformations(int param1,int  param2,int  param3,boolean  param4,Vector<FightTeamLightInformations>  param5,Vector<FightOptionsInformations>  param6) {
         this.fightId = param1;
         this.fightType = param2;
         this.fightStart = param3;
         this.fightSpectatorLocked = param4;
         this.fightTeams = param5;
         this.fightTeamsOptions = param6;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.fightType = 0;
         this.fightStart = 0;
         this.fightSpectatorLocked = false;
         this.fightTeams = new Vector.<FightTeamLightInformations>(2,true);
         this.fightTeamsOptions = new Vector.<FightOptionsInformations>(2,true);
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightExternalInformations(param1);
    }

    public void serializeAs_FightExternalInformations(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         param1.writeByte(this.fightType);
         if(this.fightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.fightStart + ") on element fightStart.");
         }
         param1.writeInt(this.fightStart);
         param1.writeBoolean(this.fightSpectatorLocked);
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this.fightTeams[_loc2_].serializeAs_FightTeamLightInformations(param1);
            _loc2_++;
         }
         int _loc3_ = 0;
         while(_loc3_ < 2)
         {
            this.fightTeamsOptions[_loc3_].serializeAs_FightOptionsInformations(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightExternalInformations(param1);
    }

    public void deserializeAs_FightExternalInformations(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this._fightTypeFunc(param1);
         this._fightStartFunc(param1);
         this._fightSpectatorLockedFunc(param1);
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this.fightTeams[_loc2_] = new FightTeamLightInformations();
            this.fightTeams[_loc2_].deserialize(param1);
            _loc2_++;
         }
         int _loc3_ = 0;
         while(_loc3_ < 2)
         {
            this.fightTeamsOptions[_loc3_] = new FightOptionsInformations();
            this.fightTeamsOptions[_loc3_].deserialize(param1);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightExternalInformations(param1);
    }

    public void deserializeAsyncAs_FightExternalInformations(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._fightTypeFunc);
         param1.addChild(this._fightStartFunc);
         param1.addChild(this._fightSpectatorLockedFunc);
         this._fightTeamstree = param1.addChild(this._fightTeamstreeFunc);
         this._fightTeamsOptionstree = param1.addChild(this._fightTeamsOptionstreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

    private void _fightTypeFunc(ICustomDataInput param1) {
         this.fightType = param1.readByte();
         if(this.fightType < 0)
         {
            throw new Exception("Forbidden value (" + this.fightType + ") on element of FightExternalInformations.fightType.");
         }
    }

    private void _fightStartFunc(ICustomDataInput param1) {
         this.fightStart = param1.readInt();
         if(this.fightStart < 0)
         {
            throw new Exception("Forbidden value (" + this.fightStart + ") on element of FightExternalInformations.fightStart.");
         }
    }

    private void _fightSpectatorLockedFunc(ICustomDataInput param1) {
         this.fightSpectatorLocked = param1.readBoolean();
    }

    private void _fightTeamstreeFunc(ICustomDataInput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this._fightTeamstree.addChild(this._fightTeamsFunc);
            _loc2_++;
         }
    }

    private void _fightTeamsFunc(ICustomDataInput param1) {
         this.fightTeams[this._fightTeamsindex] = new FightTeamLightInformations();
         this.fightTeams[this._fightTeamsindex].deserializeAsync(this._fightTeamstree.children[this._fightTeamsindex]);
         this._fightTeamsindex++;
    }

    private void _fightTeamsOptionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = 0;
         while(_loc2_ < 2)
         {
            this._fightTeamsOptionstree.addChild(this._fightTeamsOptionsFunc);
            _loc2_++;
         }
    }

    private void _fightTeamsOptionsFunc(ICustomDataInput param1) {
         this.fightTeamsOptions[this._fightTeamsOptionsindex] = new FightOptionsInformations();
         this.fightTeamsOptions[this._fightTeamsOptionsindex].deserializeAsync(this._fightTeamsOptionstree.children[this._fightTeamsOptionsindex]);
         this._fightTeamsOptionsindex++;
    }

}