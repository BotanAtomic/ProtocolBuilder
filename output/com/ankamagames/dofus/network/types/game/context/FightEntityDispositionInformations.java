package package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class FightEntityDispositionInformations extends EntityDispositionInformations implements INetworkType {

    private int protocolId = 217;
    private Number carryingCharacterId = 0;


    public int getTypeId() {
         return 217;
    }

    public FightEntityDispositionInformations initFightEntityDispositionInformations(int param1,int  param2,Number  param3) {
         super.initEntityDispositionInformations(param1,param2);
         this.carryingCharacterId = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.carryingCharacterId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_FightEntityDispositionInformations(param1);
    }

    public void serializeAs_FightEntityDispositionInformations(ICustomDataOutput param1) {
         super.serializeAs_EntityDispositionInformations(param1);
         if(this.carryingCharacterId < -9.007199254740992E15 || this.carryingCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.carryingCharacterId + ") on element carryingCharacterId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_FightEntityDispositionInformations(param1);
    }

    public void deserializeAs_FightEntityDispositionInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._carryingCharacterIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_FightEntityDispositionInformations(param1);
    }

    public void deserializeAsyncAs_FightEntityDispositionInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._carryingCharacterIdFunc);
    }

    private void _carryingCharacterIdFunc(ICustomDataInput param1) {
         this.carryingCharacterId = param1.readDouble();
         if(this.carryingCharacterId < -9.007199254740992E15 || this.carryingCharacterId > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.carryingCharacterId + ") on element of FightEntityDispositionInformations.carryingCharacterId.");
    }

}