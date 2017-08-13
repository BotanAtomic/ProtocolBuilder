package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.dofus.network.types.game.context.GameContextActorInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.dofus.network.types.game.context.EntityDispositionInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightFighterInformations extends GameContextActorInformations implements INetworkType {

    private int protocolId = 143;
    private int teamId = 2;
    private int wave = 0;
    private boolean alive = false;
    private GameFightMinimalStats stats;
    private Vector<uint> previousPositions;
    private FuncTree _statstree;
    private FuncTree _previousPositionstree;


    public int getTypeId() {
         return 143;
    }

    public GameFightFighterInformations initGameFightFighterInformations(Number param1,EntityLook  param2,EntityDispositionInformations  param3,int  param4,int  param5,boolean  param6,GameFightMinimalStats  param7,Vector<uint>  param8) {
         super.initGameContextActorInformations(param1,param2,param3);
         this.teamId = param4;
         this.wave = param5;
         this.alive = param6;
         this.stats = param7;
         this.previousPositions = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.teamId = 2;
         this.wave = 0;
         this.alive = false;
         this.stats = new GameFightMinimalStats();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterInformations(param1);
    }

    public void serializeAs_GameFightFighterInformations(ICustomDataOutput param1) {
         super.serializeAs_GameContextActorInformations(param1);
         param1.writeByte(this.teamId);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         param1.writeBoolean(this.alive);
         param1.writeShort(this.stats.getTypeId());
         this.stats.serialize(param1);
         param1.writeShort(this.previousPositions.length);
         int _loc2_ = 0;
         while(_loc2_ < this.previousPositions.length)
         {
            if(this.previousPositions[_loc2_] < 0 || this.previousPositions[_loc2_] > 559)
            {
               throw new Exception("Forbidden value (" + this.previousPositions[_loc2_] + ") on element 5 (starting at 1) of previousPositions.");
            }
            param1.writeVarShort(this.previousPositions[_loc2_]);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterInformations(param1);
    }

    public void deserializeAs_GameFightFighterInformations(ICustomDataInput param1) {
         int _loc5_ = 0;
         super.deserialize(param1);
         this._teamIdFunc(param1);
         this._waveFunc(param1);
         this._aliveFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         this.stats = ProtocolTypeManager.getInstance(GameFightMinimalStats,_loc2_);
         this.stats.deserialize(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = param1.readVarUhShort();
            if(_loc5_ < 0 || _loc5_ > 559)
            {
               throw new Exception("Forbidden value (" + _loc5_ + ") on elements of previousPositions.");
            }
            this.previousPositions.push(_loc5_);
            _loc4_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._teamIdFunc);
         param1.addChild(this._waveFunc);
         param1.addChild(this._aliveFunc);
         this._statstree = param1.addChild(this._statstreeFunc);
         this._previousPositionstree = param1.addChild(this._previousPositionstreeFunc);
    }

    private void _teamIdFunc(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of GameFightFighterInformations.teamId.");
         }
    }

    private void _waveFunc(ICustomDataInput param1) {
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of GameFightFighterInformations.wave.");
         }
    }

    private void _aliveFunc(ICustomDataInput param1) {
         this.alive = param1.readBoolean();
    }

    private void _statstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.stats = ProtocolTypeManager.getInstance(GameFightMinimalStats,_loc2_);
         this.stats.deserializeAsync(this._statstree);
    }

    private void _previousPositionstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._previousPositionstree.addChild(this._previousPositionsFunc);
            _loc3_++;
         }
    }

    private void _previousPositionsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readVarUhShort();
         if(_loc2_ < 0 || _loc2_ > 559)
         {
            throw new Exception("Forbidden value (" + _loc2_ + ") on elements of previousPositions.");
         }
         this.previousPositions.push(_loc2_);
    }

}