package package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightCommonInformations extends Object implements INetworkType {

    private int protocolId = 43;
    private int fightId = 0;
    private int fightType = 0;
    private Vector.<FightTeamInformations> fightTeams = ;
    private Vector.<uint> fightTeamsPositions = ;
    private Vector.<FightOptionsInformations> fightTeamsOptions = ;
    private FuncTree _fightTeamstree = ;
    private FuncTree _fightTeamsPositionstree = ;
    private FuncTree _fightTeamsOptionstree = ;
    private int _loc2_ = 0;
    private int _loc3_ = 0;
    private int _loc4_ = 0;
    private FightTeamInformations _loc9_ = null;
    private int _loc10_ = 0;
    private FightOptionsInformations _loc11_ = null;
    private int _loc2_ = param1.readUnsignedShort();
    private int _loc3_ = 0;
    private int _loc4_ = param1.readUnsignedShort();
    private int _loc5_ = 0;
    private int _loc6_ = param1.readUnsignedShort();
    private int _loc7_ = 0;
    private int _loc3_ = 0;
    private FightTeamInformations _loc3_ = ProtocolTypeManager.getInstance(FightTeamInformations,_loc2_);
    private int _loc3_ = 0;
    private int _loc3_ = 0;


    public int getTypeId() {
         return 43;
    }

    public FightCommonInformations initFightCommonInformations(int param1,int  param2,Vector.<FightTeamInformations>  param3,Vector.<uint>  param4,Vector.<FightOptionsInformations>  param5) {
         this.fightId = param1;
         this.fightType = param2;
         this.fightTeams = param3;
         this.fightTeamsPositions = param4;
         this.fightTeamsOptions = param5;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.fightType = 0;
         this.fightTeams = new Vector.<FightTeamInformations>();
         this.fightTeamsPositions = new Vector.<uint>();
         this.fightTeamsOptions = new Vector.<FightOptionsInformations>();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightCommonInformations(param1);
    }

    public void serializeAs_FightCommonInformations(ICustomDataOutput param1) {
         param1.writeInt(this.fightId);
         param1.writeByte(this.fightType);
         param1.writeShort(this.fightTeams.length);
         int _loc2_ = 0;
         while(_loc2_ < this.fightTeams.length)
            param1.writeShort((this.fightTeams[_loc2_] as FightTeamInformations).getTypeId());
            (this.fightTeams[_loc2_] as FightTeamInformations).serialize(param1);
            _loc2_++;
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightCommonInformations(param1);
    }

    public void deserializeAs_FightCommonInformations(ICustomDataInput param1) {
         int _loc8_ = 0;
         FightTeamInformations _loc9_ = null;
         int _loc10_ = 0;
         FightOptionsInformations _loc11_ = null;
         this._fightIdFunc(param1);
         this._fightTypeFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            _loc8_ = param1.readUnsignedShort();
            _loc9_ = ProtocolTypeManager.getInstance(FightTeamInformations,_loc8_);
            _loc9_.deserialize(param1);
            this.fightTeams.push(_loc9_);
            _loc3_++;
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightCommonInformations(param1);
    }

    public void deserializeAsyncAs_FightCommonInformations(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         param1.addChild(this._fightTypeFunc);
         this._fightTeamstree = param1.addChild(this._fightTeamstreeFunc);
         this._fightTeamsPositionstree = param1.addChild(this._fightTeamsPositionstreeFunc);
         this._fightTeamsOptionstree = param1.addChild(this._fightTeamsOptionstreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
    }

    private void _fightTypeFunc(ICustomDataInput param1) {
         this.fightType = param1.readByte();
         if(this.fightType < 0)
            throw new Exception("Forbidden value (" + this.fightType + ") on element of FightCommonInformations.fightType.");
    }

    private void _fightTeamstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._fightTeamstree.addChild(this._fightTeamsFunc);
            _loc3_++;
    }

    private void _fightTeamsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         FightTeamInformations _loc3_ = ProtocolTypeManager.getInstance(FightTeamInformations,_loc2_);
         _loc3_.deserialize(param1);
         this.fightTeams.push(_loc3_);
    }

    private void _fightTeamsPositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._fightTeamsPositionstree.addChild(this._fightTeamsPositionsFunc);
            _loc3_++;
    }

    private void _fightTeamsPositionsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of fightTeamsPositions.");
    }

    private void _fightTeamsOptionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
            this._fightTeamsOptionstree.addChild(this._fightTeamsOptionsFunc);
            _loc3_++;
    }

    private void _fightTeamsOptionsFunc(ICustomDataInput param1) {
         FightOptionsInformations _loc2_ = new FightOptionsInformations();
         _loc2_.deserialize(param1);
         this.fightTeamsOptions.push(_loc2_);
    }

}