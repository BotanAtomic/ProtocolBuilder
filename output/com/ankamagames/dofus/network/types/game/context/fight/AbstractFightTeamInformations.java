package com.ankamagames.dofus.network.types.game.context.fight;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractFightTeamInformations extends Object implements INetworkType {

    private int protocolId = 116;
    private int teamId = 2;
    private Number leaderId = 0;
    private int teamSide = 0;
    private int teamTypeId = 0;
    private int nbWaves = 0;


    public int getTypeId() {
         return 116;
    }

    public AbstractFightTeamInformations initAbstractFightTeamInformations(int param1,Number  param2,int  param3,int  param4,int  param5) {
         this.teamId = param1;
         this.leaderId = param2;
         this.teamSide = param3;
         this.teamTypeId = param4;
         this.nbWaves = param5;
         return this;
    }

    public void reset() {
         this.teamId = 2;
         this.leaderId = 0;
         this.teamSide = 0;
         this.teamTypeId = 0;
         this.nbWaves = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AbstractFightTeamInformations(param1);
    }

    public void serializeAs_AbstractFightTeamInformations(ICustomDataOutput param1) {
         param1.writeByte(this.teamId);
         if(this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element leaderId.");
         }
         param1.writeDouble(this.leaderId);
         param1.writeByte(this.teamSide);
         param1.writeByte(this.teamTypeId);
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element nbWaves.");
         }
         param1.writeByte(this.nbWaves);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractFightTeamInformations(param1);
    }

    public void deserializeAs_AbstractFightTeamInformations(ICustomDataInput param1) {
         this._teamIdFunc(param1);
         this._leaderIdFunc(param1);
         this._teamSideFunc(param1);
         this._teamTypeIdFunc(param1);
         this._nbWavesFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractFightTeamInformations(param1);
    }

    public void deserializeAsyncAs_AbstractFightTeamInformations(FuncTree param1) {
         param1.addChild(this._teamIdFunc);
         param1.addChild(this._leaderIdFunc);
         param1.addChild(this._teamSideFunc);
         param1.addChild(this._teamTypeIdFunc);
         param1.addChild(this._nbWavesFunc);
    }

    private void _teamIdFunc(ICustomDataInput param1) {
         this.teamId = param1.readByte();
         if(this.teamId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamId + ") on element of AbstractFightTeamInformations.teamId.");
         }
    }

    private void _leaderIdFunc(ICustomDataInput param1) {
         this.leaderId = param1.readDouble();
         if(this.leaderId < -9.007199254740992E15 || this.leaderId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.leaderId + ") on element of AbstractFightTeamInformations.leaderId.");
         }
    }

    private void _teamSideFunc(ICustomDataInput param1) {
         this.teamSide = param1.readByte();
    }

    private void _teamTypeIdFunc(ICustomDataInput param1) {
         this.teamTypeId = param1.readByte();
         if(this.teamTypeId < 0)
         {
            throw new Exception("Forbidden value (" + this.teamTypeId + ") on element of AbstractFightTeamInformations.teamTypeId.");
         }
    }

    private void _nbWavesFunc(ICustomDataInput param1) {
         this.nbWaves = param1.readByte();
         if(this.nbWaves < 0)
         {
            throw new Exception("Forbidden value (" + this.nbWaves + ") on element of AbstractFightTeamInformations.nbWaves.");
         }
    }

}