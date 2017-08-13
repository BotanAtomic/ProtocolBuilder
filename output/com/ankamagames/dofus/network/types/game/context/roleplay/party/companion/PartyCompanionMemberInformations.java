package com.ankamagames.dofus.network.types.game.context.roleplay.party.companion;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class PartyCompanionMemberInformations extends PartyCompanionBaseInformations implements INetworkType {

    private int protocolId = 452;
    private int initiative = 0;
    private int lifePoints = 0;
    private int maxLifePoints = 0;
    private int prospecting = 0;
    private int regenRate = 0;


    public int getTypeId() {
         return 452;
    }

    public PartyCompanionMemberInformations initPartyCompanionMemberInformations(int param1,int  param2,EntityLook  param3,int  param4,int  param5,int  param6,int  param7,int  param8) {
         super.initPartyCompanionBaseInformations(param1,param2,param3);
         this.initiative = param4;
         this.lifePoints = param5;
         this.maxLifePoints = param6;
         this.prospecting = param7;
         this.regenRate = param8;
         return this;
    }

    public void reset() {
         super.reset();
         this.initiative = 0;
         this.lifePoints = 0;
         this.maxLifePoints = 0;
         this.prospecting = 0;
         this.regenRate = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_PartyCompanionMemberInformations(param1);
    }

    public void serializeAs_PartyCompanionMemberInformations(ICustomDataOutput param1) {
         super.serializeAs_PartyCompanionBaseInformations(param1);
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element initiative.");
         }
         param1.writeVarShort(this.initiative);
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element lifePoints.");
         }
         param1.writeVarInt(this.lifePoints);
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element maxLifePoints.");
         }
         param1.writeVarInt(this.maxLifePoints);
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element prospecting.");
         }
         param1.writeVarShort(this.prospecting);
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element regenRate.");
         }
         param1.writeByte(this.regenRate);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_PartyCompanionMemberInformations(param1);
    }

    public void deserializeAs_PartyCompanionMemberInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._initiativeFunc(param1);
         this._lifePointsFunc(param1);
         this._maxLifePointsFunc(param1);
         this._prospectingFunc(param1);
         this._regenRateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_PartyCompanionMemberInformations(param1);
    }

    public void deserializeAsyncAs_PartyCompanionMemberInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._initiativeFunc);
         param1.addChild(this._lifePointsFunc);
         param1.addChild(this._maxLifePointsFunc);
         param1.addChild(this._prospectingFunc);
         param1.addChild(this._regenRateFunc);
    }

    private void _initiativeFunc(ICustomDataInput param1) {
         this.initiative = param1.readVarUhShort();
         if(this.initiative < 0)
         {
            throw new Exception("Forbidden value (" + this.initiative + ") on element of PartyCompanionMemberInformations.initiative.");
         }
    }

    private void _lifePointsFunc(ICustomDataInput param1) {
         this.lifePoints = param1.readVarUhInt();
         if(this.lifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.lifePoints + ") on element of PartyCompanionMemberInformations.lifePoints.");
         }
    }

    private void _maxLifePointsFunc(ICustomDataInput param1) {
         this.maxLifePoints = param1.readVarUhInt();
         if(this.maxLifePoints < 0)
         {
            throw new Exception("Forbidden value (" + this.maxLifePoints + ") on element of PartyCompanionMemberInformations.maxLifePoints.");
         }
    }

    private void _prospectingFunc(ICustomDataInput param1) {
         this.prospecting = param1.readVarUhShort();
         if(this.prospecting < 0)
         {
            throw new Exception("Forbidden value (" + this.prospecting + ") on element of PartyCompanionMemberInformations.prospecting.");
         }
    }

    private void _regenRateFunc(ICustomDataInput param1) {
         this.regenRate = param1.readUnsignedByte();
         if(this.regenRate < 0 || this.regenRate > 255)
         {
            throw new Exception("Forbidden value (" + this.regenRate + ") on element of PartyCompanionMemberInformations.regenRate.");
         }
    }

}