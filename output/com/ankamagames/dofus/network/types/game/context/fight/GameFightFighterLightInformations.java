package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GameFightFighterLightInformations extends Object implements INetworkType {

    private int protocolId = 413;
    private Number id = 0;
    private int wave = 0;
    private int level = 0;
    private int breed = 0;
    private boolean sex = false;
    private boolean alive = false;


    public int getTypeId() {
         return 413;
    }

    public GameFightFighterLightInformations initGameFightFighterLightInformations(Number param1,int  param2,int  param3,int  param4,boolean  param5,boolean  param6) {
         this.id = param1;
         this.wave = param2;
         this.level = param3;
         this.breed = param4;
         this.sex = param5;
         this.alive = param6;
         return this;
    }

    public void reset() {
         this.id = 0;
         this.wave = 0;
         this.level = 0;
         this.breed = 0;
         this.sex = false;
         this.alive = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GameFightFighterLightInformations(param1);
    }

    public void serializeAs_GameFightFighterLightInformations(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.sex);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.alive);
         param1.writeByte(_loc2_);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
         }
         param1.writeDouble(this.id);
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element wave.");
         }
         param1.writeByte(this.wave);
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeVarShort(this.level);
         param1.writeByte(this.breed);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GameFightFighterLightInformations(param1);
    }

    public void deserializeAs_GameFightFighterLightInformations(ICustomDataInput param1) {
         this.deserializeByteBoxes(param1);
         this._idFunc(param1);
         this._waveFunc(param1);
         this._levelFunc(param1);
         this._breedFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GameFightFighterLightInformations(param1);
    }

    public void deserializeAsyncAs_GameFightFighterLightInformations(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._idFunc);
         param1.addChild(this._waveFunc);
         param1.addChild(this._levelFunc);
         param1.addChild(this._breedFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.sex = BooleanByteWrapper.getFlag(_loc2_,0);
         this.alive = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.id + ") on element of GameFightFighterLightInformations.id.");
         }
    }

    private void _waveFunc(ICustomDataInput param1) {
         this.wave = param1.readByte();
         if(this.wave < 0)
         {
            throw new Exception("Forbidden value (" + this.wave + ") on element of GameFightFighterLightInformations.wave.");
         }
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readVarUhShort();
         if(this.level < 0)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of GameFightFighterLightInformations.level.");
         }
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

}